package pages;

import java.time.Duration;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewRegistrationPage {

	private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	WebDriver driver;
	WebDriverWait wait;
	
	public NewRegistrationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	
	@FindBy(id = "cms-newuser-firstName")
	private WebElement firstNameInput;
	
	@FindBy(id = "cms-newuser-lastName")
	private WebElement lastNameInput;
	
	@FindBy(id = "cms-newuser-birthMonth")
	private WebElement birthMonthInput;
	
	@FindBy(id = "cms-newuser-birthDate")
	private WebElement birthDateInput;
	
	@FindBy(id = "cms-newuser-birthYear")
	private WebElement birthYearInput;
	
	public void inputFirstName(String firstName) {
		wait.until(ExpectedConditions.elementToBeClickable(firstNameInput));
		firstNameInput.sendKeys(firstName);
		LOGGER.info(firstName + " - has been entered >>> " + firstNameInput);
	}
	
	public void inputLastName(String lastName) {
		wait.until(ExpectedConditions.elementToBeClickable(lastNameInput));
		lastNameInput.sendKeys(lastName);
		LOGGER.info(lastName + " - has been entered >>> " + lastNameInput);
	}
	
	public void inputDobMonth(String dobMonth) {
		selectElement(birthMonthInput, dobMonth);
	}
	
	public void inputDobDate(String dobDate) {
		selectElement(birthDateInput, dobDate);
	}
	
	public void inputDobYear(String dobYear) {
		selectElement(birthYearInput, dobYear);
	}
	
	private void selectElement(WebElement element, String text) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		Select select = new Select(element);
		select.selectByVisibleText(text);
		LOGGER.info(text + " - has been selected >>> " + element);
	}
}
