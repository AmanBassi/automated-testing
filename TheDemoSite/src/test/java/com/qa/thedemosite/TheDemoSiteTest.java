package com.qa.thedemosite;

import static org.junit.jupiter.api.Assertions.*;

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

class TheDemoSiteTest {
	
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
	void test() {
		driver.get("http://thedemosite.co.uk/");

        assertEquals("FREE example PHP code and online MySQL database - example username password protected site", driver.getTitle());
		
	    driver.manage().window().setSize(new Dimension(848, 1037));
	    driver.findElement(By.linkText("3. Add a User")).click();
	    driver.findElement(By.name("username")).click();
	    driver.findElement(By.name("username")).sendKeys("bassi");
	    driver.findElement(By.name("password")).sendKeys("amandeep");
	    driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
	    driver.findElement(By.name("FormsButton2")).click();
	    driver.findElement(By.linkText("4. Login")).click();
	    assertEquals(driver.findElement(By.cssSelector("center > b")).getText(), "**No login attempted**");
	    driver.findElement(By.name("username")).click();
	    driver.findElement(By.name("username")).sendKeys("bassi");
	    driver.findElement(By.name("password")).sendKeys("amandeep");
	    driver.findElement(By.name("FormsButton2")).click();
	    assertEquals(driver.findElement(By.cssSelector("center > b")).getText(), "**Successful Login**");
	}

}
