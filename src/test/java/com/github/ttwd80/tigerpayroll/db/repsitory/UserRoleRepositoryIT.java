package com.github.ttwd80.tigerpayroll.db.repsitory;

import static com.github.ttwd80.tigerpayroll.db.repsitory.RoleRepositoryTestHelper.*;
import static com.github.ttwd80.tigerpayroll.db.repsitory.UserRepositoryTestHelper.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.ttwd80.tigerpayroll.model.entity.Role;
import com.github.ttwd80.tigerpayroll.model.entity.User;
import com.github.ttwd80.tigerpayroll.model.entity.UserRole;
import com.github.ttwd80.tigerpayroll.model.repository.RoleRepository;
import com.github.ttwd80.tigerpayroll.model.repository.UserRepository;
import com.github.ttwd80.tigerpayroll.model.repository.UserRoleRepository;

public class UserRoleRepositoryIT extends BaseRepositoryIT {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	UserRoleRepository userRoleRepository;

	@Override
	@Before
	public void setUp() {
		super.setUp();
		userRoleRepository.deleteAll();
		roleRepository.deleteAll();
		userRepository.deleteAll();

		final User user1 = createUser("user1");
		final User user2 = createUser("user2");
		final User user3 = createUser("user3");
		userRepository.save(user1);
		userRepository.save(user2);
		userRepository.save(user3);

		final Role role1 = createRole("ROLE_A");
		final Role role2 = createRole("ROLE_B");
		final Role role3 = createRole("ROLE_C");
		roleRepository.save(role1);
		roleRepository.save(role2);
		roleRepository.save(role3);

		final UserRole userRole1 = new UserRole();
		userRole1.setRole(role1);
		userRole1.setUserByUsername(user1);
		userRoleRepository.save(userRole1);

		final UserRole userRole2 = new UserRole();
		userRole2.setRole(role2);
		userRole2.setUserByUsername(user1);
		userRoleRepository.save(userRole2);

		final UserRole userRole3 = new UserRole();
		userRole3.setRole(role3);
		userRole3.setUserByUsername(user1);
		userRoleRepository.save(userRole3);
	}

	@Test
	public void testUserWithNoRoles() {
		final List<UserRole> items = userRoleRepository.findByUserByUsernameUsername("user2");
		assertEquals(0, items.size());
	}

	@Test
	public void testUserWithMultipleRoles() {
		final List<UserRole> items = userRoleRepository.findByUserByUsernameUsername("user1");
		assertEquals(3, items.size());
	}

}
