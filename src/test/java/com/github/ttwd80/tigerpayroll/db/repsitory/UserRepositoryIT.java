package com.github.ttwd80.tigerpayroll.db.repsitory;

import static com.github.ttwd80.tigerpayroll.db.repsitory.UserRepositoryTestHelper.createUser;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.ttwd80.tigerpayroll.model.repository.UserRepository;

public class UserRepositoryIT extends BaseRepositoryIT {

	@Autowired
	UserRepository userRepository;

	@Before
	public void setUp() {
		super.setUp();
		userRepository.deleteAll();
	}

	@Test
	public void testStartWithZero() {
		assertEquals(0L, userRepository.count());
	}

	@Test
	public void testInsertOne() {
		userRepository.save(createUser("user#1"));
		assertEquals(1L, userRepository.count());
	}

	@Test
	public void testInsertTwo() {
		userRepository.save(createUser("user#1"));
		userRepository.save(createUser("user#2"));
		assertEquals(2L, userRepository.count());
	}

}
