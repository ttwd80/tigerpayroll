package com.github.ttwd80.tigerpayroll.web;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class AbstractSeleniumWebIT {

	protected WebDriver webDriver;

	protected final String baseURL = "http://localhost:58080/";

	@Before
	public void setUp() {
		webDriver = new ChromeDriver();
		final Window window = webDriver.manage().window();
		window.setPosition(new Point(0, 0));
		window.setSize(new Dimension(1920, 1080));
	}

	@After
	public void cleanUp() {
		webDriver.quit();
	}
}
