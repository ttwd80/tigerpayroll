package com.github.ttwd80.tigerpayroll.model.service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.github.ttwd80.tigerpayroll.model.entity.User;
import com.github.ttwd80.tigerpayroll.model.repository.UserRepository;
import com.github.ttwd80.tigerpayroll.model.repository.UserRoleRepository;

public class UserDetailsServiceImplSteps {

	String username;
	List<String> roles;
	UserDetailsServiceImpl sut;
	User validUser;
	User userFromDatabase;
	UserDetails userDetails;
	Exception thrownException;
	@Mock
	UserRepository userRepository;

	@Mock
	UserRoleRepository userRoleRepository;

	@Given("Given user $username has roles [$user_roles_cvs]")
	public void setUp(final String username, final String userRolesCSV) {
		this.username = username;
		roles = Arrays.asList(userRolesCSV.split(", "));
		validUser = new User();
		validUser.setUsername(username);
	}

	@When("When user logs in")
	public void login() {
		MockitoAnnotations.initMocks(this);
		sut = new UserDetailsServiceImpl(userRepository, userRoleRepository);
		when(userRepository.findOne((String) argThat(x -> !x.equals(username)))).thenReturn(null);
		when(userRepository.findOne((String) argThat(x -> x.equals(username)))).thenReturn(validUser);
		try {
			thrownException = null;
			userDetails = sut.loadUserByUsername(username);
		} catch (final Exception e) {
			thrownException = e;
		}
	}

	@Then("Then exception is thrown")
	public void thenExceptionIsThrown() {
		assertThat(thrownException, instanceOf(UsernameNotFoundException.class));
	}
}
