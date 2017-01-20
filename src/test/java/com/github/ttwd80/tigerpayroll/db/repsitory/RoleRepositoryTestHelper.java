package com.github.ttwd80.tigerpayroll.db.repsitory;

import com.github.ttwd80.tigerpayroll.model.entity.Role;

public class RoleRepositoryTestHelper {

	public static Role createRole(String name) {
		Role role = new Role();
		role.setId(name);
		return role;
	}
}
