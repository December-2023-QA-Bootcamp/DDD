package com.cms.gov.ddd.unit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;


public class DBTest {
	
	String queryFromFile = "";

	String createTable = "CREATE TABLE cms_bcrs (" + "firstname varchar(25)," + "lastname varchar(25),"
			+ "dob_date int," + "dob_month varchar(25)," + "dob_year int)";

	String insertData = "INSERT INTO cms_bcrs " + "(firstname,lastname,dob_date,dob_month,dob_year) "
			+ "VALUES ('Rahim','Afroz',28,'January',1965);" + "INSERT INTO cms_bcrs "
			+ "(firstname,lastname,dob_date,dob_month,dob_year) " + "VALUES ('Sakib','Alhasan',12,'March',1977);";

	String selectData = "SELECT * FROM cms_bcrs";

	@Test
	public void dbTest() throws SQLException {

		/*
		 * - Register DB - DriverManager - java.sql - Connection - java.sql - Statement
		 * - java.sql - ResultSet - java.sql
		 */

		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/student", "postgres",
				"hr");

		Statement statement = connection.createStatement();
		statement.execute(insertData);

		ResultSet resultSet = statement.getResultSet();
		resultSet.next();
		System.err.println(resultSet.getString(1));

		connection.close();
	}
	
	
	@Test
	public void getSqlData() throws IOException {
		File file = new File("src/test/resources/Students.sql");
		System.err.println(file.exists());
		
		FileReader fileReader = new FileReader(file);
		try (BufferedReader reader = new BufferedReader(fileReader)) {
			String line = "";
			while ((line = reader.readLine()) != null) {
				queryFromFile = queryFromFile + line;
				
			}
		}
		System.err.println(queryFromFile);
	}
}
