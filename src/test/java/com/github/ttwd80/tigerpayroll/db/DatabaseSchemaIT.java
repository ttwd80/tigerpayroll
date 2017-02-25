package com.github.ttwd80.tigerpayroll.db;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration("classpath:test-datasource.xml")
public class DatabaseSchemaIT extends AbstractJUnit4SpringContextTests {

	@Autowired
	DataSource dataSource;

	JdbcTemplate jdbcTemplate;

	Resource jdbcScript;

	@Before
	public void setUp() {
		jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcScript = new ClassPathResource("db-schema.txt");
	}

	@Test
	public void testClean() {
		final List<String> tablenames = readTableNames();
		clean(tablenames);
		assertEquals(0, countTotalTables());
	}

	@Test
	public void testCreateScript() {
		final List<String> tablenames = readTableNames();
		clean(tablenames);
		final ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator(jdbcScript);
		resourceDatabasePopulator.setContinueOnError(false);
		resourceDatabasePopulator.execute(dataSource);
		assertEquals(7, countTotalTables());

	}

	private int countTotalTables() {
		final String sql = "select count(*) from information_schema.tables where table_schema = 'public'";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	private void clean(final List<String> tablenames) {
		final String command = "DROP TABLE IF EXISTS \"%s\" CASCADE";
		for (final String tablename : tablenames) {
			final String sql = String.format(command, tablename);
			jdbcTemplate.execute(sql);
		}

	}

	private List<String> readTableNames() {
		final List<String> items = new ArrayList<>();
		try (InputStream is = jdbcScript.getInputStream()) {
			final List<String> lines = IOUtils.readLines(is, "UTF-8");
			for (final String line : lines) {
				if (line.startsWith("CREATE TABLE ")) {
					final String[] words = line.split(" ");
					final String word = words[2];
					final int n = word.length();
					if (word.charAt(0) == '\"' && word.charAt(n - 1) == '\"') {
						items.add(word.substring(1, n - 1));
					}
				}
			}
			return items;
		} catch (final IOException e) {
			throw new RuntimeException(e);
		}
	}

}
