package com.cms.gov.ddd.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LandingPage;
import pages.NewRegistrationPage;

/**
 * May 21, 2024
 * Base Class to setup the driver
 * @author mdnas
 */
public class TestBase {

	protected static WebDriver driver;
	
	protected LandingPage landingPage;
	protected NewRegistrationPage newRegistrationPage;
	
	/**
	 * Setting up the driver and timeouts for page load and element implicit wait
	 */
	@BeforeMethod
	public void testSetup() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://portal.cms.gov/portal/");
		
		initPageObject();
	}
	
	/**
	 * Close the current browser
	 */
	@AfterMethod
	public void tearDownBrowser() {
		driver.quit();
	}
	
	private void initPageObject() {
		landingPage = new LandingPage(driver);
		newRegistrationPage = new NewRegistrationPage(driver);
	}
}
