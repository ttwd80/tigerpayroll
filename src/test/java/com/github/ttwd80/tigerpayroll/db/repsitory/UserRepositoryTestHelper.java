package com.github.ttwd80.tigerpayroll.db.repsitory;

import com.github.ttwd80.tigerpayroll.model.entity.User;

public class UserRepositoryTestHelper {

	public static User createUser(final String username) {
		final User user = new User();
		user.setUsername(username);
		user.setFullName(username + " " + "blake");
		user.setPassword("*");
		user.setLocked(false);
		return user;
	}

}
