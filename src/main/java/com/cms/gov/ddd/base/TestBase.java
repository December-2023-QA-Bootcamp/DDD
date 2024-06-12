package com.cms.gov.ddd.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static constant.IConstant.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LandingPage;
import pages.NewRegistrationPage;
import util.ReadConfig;

/**
 * May 21, 2024
 * Base Class to setup the driver
 * @author mdnas
 */
public class TestBase {

	protected static WebDriver driver;
	
	protected LandingPage landingPage;
	protected NewRegistrationPage newRegistrationPage;
	
	protected ReadConfig readConfig;
	
	/**
	 * Setting up the driver and timeouts for page load and element implicit wait
	 * @throws Exception 
	 */
	@BeforeMethod
	public void testSetup() throws Exception 
	{
		readConfig = new ReadConfig(CONFIG_FILE);
		
		String mode = readConfig.get(MODE);
		
		if(mode.equalsIgnoreCase(LOCAL)) 
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(mode.equalsIgnoreCase(CLOUD)) 
		{
			driver = getCloudDriverConfig();
		}
		else 
		{
			throw new Exception(String.format("MODE can only be %s or %s BUT NOT %s", LOCAL, CLOUD, mode));
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(
				str2int(readConfig.get(PAGE_LOAD_TIME))));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(
				str2int(readConfig.get(IMPLICITLY_WAIT_TIME))));
		
		driver.get(readConfig.get(URL));
		
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
	
	private int str2int(String value) {
		try 
		{
			return Integer.parseInt(value);
		}
		catch (NumberFormatException e) 
		{
			e.printStackTrace();
			return -1;
		}
	}
	
	private WebDriver getCloudDriverConfig() throws MalformedURLException 
	{
		ReadConfig readBS_config = new ReadConfig(CLOUD_CONFIG_FILE);
		
		MutableCapabilities capabilities = new MutableCapabilities();
		HashMap<String, Object> bsOpts = new HashMap<String, Object>();
		
		// ----- Desktop Browser
		bsOpts.put(BS_OS, readBS_config.get(BS_OS));
		bsOpts.put(BS_OS_VER, readBS_config.get(BS_OS_VER));
		
		// ----- Mobile Device
		//bsOpts.put(BS_DEVICE_NAME, readBS_config.get(BS_DEVICE_NAME));
		//bsOpts.put(BS_DEVICE_ORIENTATION, readBS_config.get(BS_DEVICE_ORIENTATION));
		
		capabilities.setCapability(BS_BROWSER, readBS_config.get(BS_BROWSER));
		capabilities.setCapability(BS_BEROWSER_VER, readBS_config.get(BS_BEROWSER_VER));
		
		capabilities.setCapability(BS_OPT, bsOpts);
		
		String urlString = String.format("https://%s:%s%s", readBS_config.get(BS_USER),
				readBS_config.get(BS_KEY), readBS_config.get(BS_URL));
		
		System.err.println("Remote URL - " + urlString);
		
		URL url = new URL(urlString);
		
		return new RemoteWebDriver(url, capabilities);
	}
}
