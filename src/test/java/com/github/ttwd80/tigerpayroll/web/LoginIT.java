package com.github.ttwd80.tigerpayroll.web;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class LoginIT extends AbstractSeleniumWebIT {

	@Test
	public void testLoginBad() {
		webDriver.get(baseURL);
		webDriver.findElement(By.id("username")).sendKeys("admin");
		webDriver.findElement(By.id("password")).sendKeys("bad!!!");
		webDriver.findElement(By.id("submit")).click();
		final String actual = webDriver.getCurrentUrl();
		final String expected = "http://localhost:58080/login?fail=true";
		assertEquals(expected, actual);
	}

	@Test
	public void testLoginGood() {
		webDriver.get(baseURL);
		webDriver.findElement(By.id("username")).sendKeys("admin");
		webDriver.findElement(By.id("password")).sendKeys("admin");
		webDriver.findElement(By.id("submit")).click();
		final String actual = webDriver.getCurrentUrl();
		final String expected = "http://localhost:58080/admin/index";
		assertEquals(expected, actual);
	}
}
