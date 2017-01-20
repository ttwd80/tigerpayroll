package com.github.ttwd80.tigerpayroll.db.repsitory;

import com.github.ttwd80.tigerpayroll.model.entity.User;

public class UserRepositoryTestHelper {

	public static User createUser(String username) {
		User user = new User();
		user.setUsername(username);
		user.setPassword("*");
		user.setLocked(false);
		return user;
	}

}
