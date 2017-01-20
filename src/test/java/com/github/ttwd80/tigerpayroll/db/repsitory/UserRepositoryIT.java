package com.github.ttwd80.tigerpayroll.db.repsitory;

import static com.github.ttwd80.tigerpayroll.db.repsitory.UserRepositoryTestHelper.*;
import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.github.ttwd80.tigerpayroll.model.entity.User;
import com.github.ttwd80.tigerpayroll.model.repository.UserRepository;

public class UserRepositoryIT extends BaseRepositoryIT {

	@Autowired
	UserRepository userRepository;

	@Override
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

	@Test
	public void testCreatedDateNotNull() {
		final User user = createUser("user");
		userRepository.save(user);
		final User userFromDb = userRepository.findOne("user");
		assertNotNull(userFromDb.getCreatedDate());
	}

	@Test
	public void testCreatedDateValidFromDatabase() {
		final DateTime dateBefore = new DateTime();
		final User user = createUser("user");
		userRepository.save(user);
		final DateTime dateAfter = new DateTime();
		final User userFromDb = userRepository.findOne("user");
		final DateTime date = userFromDb.getCreatedDate();
		assertTrue(dateBefore.compareTo(date) <= 0);
		assertTrue(date.compareTo(dateAfter) <= 0);
	}

	@Test
	public void testModifiedNull() {
		final User user = createUser("user");
		userRepository.save(user);
		assertNull(user.getLastModifiedDate());
	}

	@Test
	@Transactional
	public void testModifiedAfterCreated() {
		User user = createUser("user");
		userRepository.save(user);

		user = userRepository.findOne("user");
		user.setPassword("$$$");
		userRepository.saveAndFlush(user);

		final User fromDatabase = userRepository.findOne("user");
		final DateTime dateCreated = fromDatabase.getCreatedDate();
		final DateTime dateLastModified = fromDatabase.getLastModifiedDate();
		assertTrue(dateCreated.compareTo(dateLastModified) < 0);
	}
}
