package com.github.ttwd80.tigerpayroll.db.repsitory;

import static com.github.ttwd80.tigerpayroll.db.repsitory.RoleRepositoryTestHelper.createRole;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.ttwd80.tigerpayroll.model.repository.RoleRepository;

public class RoleRepositoryIT extends BaseRepositoryIT {

	@Autowired
	RoleRepository roleRepository;

	@Before
	public void setUp() {
		super.setUp();
		roleRepository.deleteAll();
	}

	@Test
	public void testZero() {
		assertEquals(0L, roleRepository.count());
	}

	@Test
	public void testOne() {
		roleRepository.save(createRole("ROLE_1"));
		assertEquals(1L, roleRepository.count());
	}

	@Test
	public void testTwo() {
		roleRepository.save(createRole("ROLE_1"));
		roleRepository.save(createRole("ROLE_2"));
		assertEquals(2L, roleRepository.count());
	}

}
