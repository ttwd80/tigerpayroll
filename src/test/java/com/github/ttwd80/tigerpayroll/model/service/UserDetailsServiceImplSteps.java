package com.github.ttwd80.tigerpayroll.model.service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.mockito.ArgumentMatcher;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.github.ttwd80.tigerpayroll.model.entity.Role;
import com.github.ttwd80.tigerpayroll.model.entity.User;
import com.github.ttwd80.tigerpayroll.model.entity.UserRole;
import com.github.ttwd80.tigerpayroll.model.repository.UserRepository;
import com.github.ttwd80.tigerpayroll.model.repository.UserRoleRepository;

public class UserDetailsServiceImplSteps {

	UserDetailsServiceImpl sut;
	Map<String, List<UserRole>> map = new LinkedHashMap<>();

	@Mock
	private UserRepository userRepository;

	@Mock
	private UserRoleRepository userRoleRepository;

	Exception thrownException;

	UserDetails userDetails;

	@Given("user configuration: $table")
	public void userConfiguration(final ExamplesTable table) {
		for (final Map<String, String> row : table.getRows()) {
			map.put(row.get("username"), toListUserRole(row.get("roles")));
		}
	}

	private List<UserRole> toListUserRole(final String csv) {
		final List<String> items = Arrays.asList(csv.split(", "));
		final List<UserRole> list = items.stream().filter(x -> x.length() > 0).map(value -> {
			final UserRole userRole = new UserRole();
			final Role role = new Role();
			role.setId(value);
			userRole.setRole(role);
			return userRole;
		}).collect(Collectors.toList());
		return list;
	}

	@When("user $username logs in")
	public void userLogsIn(final String username) {
		MockitoAnnotations.initMocks(this);
		sut = new UserDetailsServiceImpl(userRepository, userRoleRepository);
		final ArgumentMatcher<String> notInMap = x -> !map.containsKey(x);
		final ArgumentMatcher<String> inMap = x -> map.containsKey(x);
		when(userRepository.findOne(argThat(notInMap))).thenReturn(null);
		when(userRepository.findOne(argThat(inMap))).thenReturn(createUser(username));
		when(userRoleRepository.findByUserByUsernameUsername(username)).thenReturn(map.get(username));
		try {
			thrownException = null;
			userDetails = null;
			userDetails = sut.loadUserByUsername(username);
		} catch (final Exception e) {
			thrownException = e;
		}
	}

	private User createUser(final String username) {
		final User user = new User();
		user.setUsername(username);
		user.setPassword("***");
		return user;
	}

	@Then("an exception is thrown")
	public void anExceptionIsThrown() {
		assertThat(thrownException, instanceOf(UsernameNotFoundException.class));
	}

	@Then("there are no roles")
	public void thereAreNoRoles() {
		assertThat(userDetails.getAuthorities().size(), is(0));
	}

	@Then("the user gets these roles: $table")
	public void theUserGetsTheseRoles(final ExamplesTable table) {
		final List<String> listsExpected = new ArrayList<>();
		for (final Map<String, String> row : table.getRows()) {
			listsExpected.add(row.get("role"));
		}
		final Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
		final List<String> listActual = authorities.stream().map(x -> x.getAuthority()).collect(Collectors.toList());
		assertThat(listActual.size(), equalTo(listsExpected.size()));
		assertThat(listActual.containsAll(listsExpected), equalTo(true));
		assertThat(listsExpected.containsAll(listActual), equalTo(true));

	}
}
