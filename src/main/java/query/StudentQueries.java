package query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Student;
import util.DBUtil;

public class StudentQueries {

	static DBUtil dbUtil;
	
	private static void init() {
		dbUtil = new DBUtil();
	}
	
	public static List<Student> getStudents() {
		init();
		String query = "SELECT * FROM cms_bcrs";
		dbUtil.executeQuery(query);
		ResultSet resultSet = dbUtil.getResultSet();
		
		List<Student> listOfStudents = new ArrayList<Student>();
		
		try {
			while (resultSet.next()) {
				String firstname = resultSet.getString(1);
				String lastname = resultSet.getString(2);
				int dobdate = resultSet.getInt(3);
				String dobMonth = resultSet.getString(4);
				int dobyear = resultSet.getInt(5);

				Student student = new Student(firstname, lastname, dobdate, dobMonth, dobyear);
				listOfStudents.add(student);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listOfStudents;
	}
}
