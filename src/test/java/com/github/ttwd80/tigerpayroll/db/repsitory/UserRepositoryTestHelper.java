package com.github.ttwd80.tigerpayroll.db.repsitory;

import java.math.BigDecimal;

import com.github.ttwd80.tigerpayroll.model.entity.User;

public class UserRepositoryTestHelper {

	public static User createUser(final String username) {
		final User user = new User();
		user.setUsername(username);
		user.setFullName(username + " " + "blake");
		user.setPassword("*");
		user.setLocked(false);
		user.setBasicSalary(new BigDecimal("4500.00"));
		return user;
	}

}
