package dto;

public class Student {

	private String firstname;
	private String lastname;
	private int dob_date;
	private String dob_month;
	private int dob_year;
	
	public Student() {}
	
	/**
	 * 
	 * @param firstname String
	 * @param lastname String
	 * @param dob_date int
	 * @param dob_month String
	 * @param dob_year int
	 */
	public Student(String firstname, String lastname, int dob_date, String dob_month, int dob_year) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob_date = dob_date;
		this.dob_month = dob_month;
		this.dob_year = dob_year;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getDob_date() {
		return dob_date;
	}
	public void setDob_date(int dob_date) {
		this.dob_date = dob_date;
	}
	public String getDob_month() {
		return dob_month;
	}
	public void setDob_month(String dob_month) {
		this.dob_month = dob_month;
	}
	public int getDob_year() {
		return dob_year;
	}
	public void setDob_year(int dob_year) {
		this.dob_year = dob_year;
	}
	
	
}
