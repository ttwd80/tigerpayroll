package com.github.ttwd80.tigerpayroll.db.repsitory;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration({ "classpath:test-datasource.xml", "classpath:application-context-spring-data-jpa.xml" })
public class BaseRepositoryIT extends AbstractJUnit4SpringContextTests {

	@Autowired
	DataSource dataSource;

	JdbcTemplate jdbcTemplate;

	Logger logger = LoggerFactory.getLogger(getClass());

	@Before
	public void setUp() {
		jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.execute("DROP SCHEMA IF EXISTS \"public\" CASCADE");
		jdbcTemplate.execute("CREATE SCHEMA \"public\"");
		final Resource jdbcScript = new ClassPathResource("db-schema.txt");
		final ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator(jdbcScript);
		resourceDatabasePopulator.setContinueOnError(false);
		resourceDatabasePopulator.execute(dataSource);
	}

	@Test
	public void testTrue() {
		assertTrue(true);
	}
}
