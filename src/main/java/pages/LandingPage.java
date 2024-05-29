package pages;

import java.time.Duration;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {

	private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	WebDriver driver;
	WebDriverWait wait;
	
	public LandingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	
	@FindBy(id = "cms-newuser-reg")
	private WebElement newRegistrationBtn;
	
	final String selectApplicationLocator = "ng-select-container";
	
	@FindBy(className = selectApplicationLocator)
	private WebElement selectYourApplicationBtn;
	
	@FindBy(xpath = "//span[@class='ng-option-label' and text()='BCRS Web']")
	private WebElement BCRSWebOpt;
	
	@FindBy(id = "cms-tos-reg")
	private WebElement iAgreeBtn;
	
	@FindBy(id = "termsAndCondNext")
	private WebElement nextBtn;
	
	public void clickNewRegistration() {
		wait.until(ExpectedConditions.elementToBeClickable(newRegistrationBtn));
		newRegistrationBtn.click();
		LOGGER.info("New Registration Button has been clicked");
	}
	
	public void clickSelectYourApplication() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(selectYourApplicationBtn));
			selectYourApplicationBtn.click();
		}catch (StaleElementReferenceException e) {
			driver.findElement(By.className(selectApplicationLocator)).click();
		}
		LOGGER.info("Application Button has been clicked");
	}
	
	public void clickBcrsWeb() {
		wait.until(ExpectedConditions.elementToBeClickable(BCRSWebOpt));
		BCRSWebOpt.click();
		LOGGER.info("BCRS has been clicked");
	}
	
	public void clickIAgree() {
		wait.until(ExpectedConditions.elementToBeClickable(iAgreeBtn));
		iAgreeBtn.click();
		LOGGER.info("I Agree has been clicked");
	}
	
	public void clickNext() {
		wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
		nextBtn.click();
		LOGGER.info("Next Button has been clicked");
	}
}
