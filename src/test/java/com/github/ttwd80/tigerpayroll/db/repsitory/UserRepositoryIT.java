package com.github.ttwd80.tigerpayroll.db.repsitory;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.ttwd80.tigerpayroll.model.entity.User;
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
		logger.info("testInsertOne begin");
		User user = new User();
		user.setUsername("admin");
		user.setPassword("*");
		user.setLocked(false);
		userRepository.save(user);
		logger.info("testInsertOne end");
		assertEquals(1L, userRepository.count());
	}

	@Test
	public void testInsertTwo() {
		{
			User user = new User();
			user.setUsername("admin1");
			user.setPassword("*");
			user.setLocked(false);
			userRepository.save(user);
		}
		{
			User user = new User();
			user.setUsername("admin2");
			user.setPassword("*");
			user.setLocked(false);
			userRepository.save(user);
		}
		assertEquals(2L, userRepository.count());
	}
}
