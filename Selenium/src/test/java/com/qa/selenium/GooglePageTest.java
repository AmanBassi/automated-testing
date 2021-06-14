package com.qa.selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class GooglePageTest {
	
	private static WebDriver driver;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1366, 768));
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	void test() throws InterruptedException {
		driver.get("https://google.com");

        assertEquals("Google", driver.getTitle());
        
        driver.get("https://www.google.co.uk/");
        driver.manage().window().setSize(new Dimension(848, 1037));
        driver.findElement(By.id("L2AGLb")).click();
        driver.findElement(By.name("q")).click();
        driver.findElement(By.name("q")).sendKeys("kittens");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector(".eA0Zlc:nth-child(3) .fWhgmd")).click();
        assertEquals(driver.getTitle(), "kittens - Google Search");
        assertEquals(driver.findElement(By.cssSelector(".tvh9oe:nth-child(2) .pM4Snf")).getText(), "Live Science");
	}

}
