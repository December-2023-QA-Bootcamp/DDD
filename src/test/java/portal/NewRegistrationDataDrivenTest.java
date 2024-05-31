package portal;


import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cms.gov.ddd.base.TestBase;

import dto.Student;
import query.StudentQueries;

public class NewRegistrationDataDrivenTest extends TestBase{

	@DataProvider(name = "students_obj")
	public Object[][] getStudentObjects(){
		List<Student> list = StudentQueries.getStudents();
		Object[][] objects = new Object[list.size()][];
		for(int i = 0; i < list.size(); i++) {
			objects[i] = new Object[] {list.get(i)};
		}
		return objects;
	}
	
	@DataProvider(name = "students_iterator")
	public Iterator<Student> getStudentIterator(){
		List<Student> list = StudentQueries.getStudents();
		return list.iterator();
	}
	
	@Test(dataProvider = "students_iterator")
	public void new_registration_test(Student student) throws InterruptedException {
		landingPage.clickNewRegistration();		
		landingPage.clickSelectYourApplication();
		landingPage.clickBcrsWeb();
		landingPage.clickIAgree();
		landingPage.clickNext();
		
		newRegistrationPage.inputFirstName(student.getFirstname());
		newRegistrationPage.inputLastName(student.getLastname());
		newRegistrationPage.inputDobMonth(student.getDob_month());
		newRegistrationPage.inputDobDate(student.getDob_date() + "");
		newRegistrationPage.inputDobYear(student.getDob_year() + "");
		
		Thread.sleep(3000);
	}
}
