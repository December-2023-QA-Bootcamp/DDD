package portal;


import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.cms.gov.ddd.base.TestBase;

public class NewRegistrationTest extends TestBase{

	@Test
	public void new_registration_test() throws InterruptedException {
		landingPage.clickNewRegistration();		
		landingPage.clickSelectYourApplication();
		landingPage.clickBcrsWeb();
		landingPage.clickIAgree();
		landingPage.clickNext();
		
		newRegistrationPage.inputFirstName("Jean");
		newRegistrationPage.inputLastName("Doe");
		newRegistrationPage.inputDobMonth("May");
		newRegistrationPage.inputDobDate("3");
		newRegistrationPage.inputDobYear("1998");
		
		Thread.sleep(3000);
	}
}
