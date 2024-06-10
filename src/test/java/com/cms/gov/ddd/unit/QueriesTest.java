package com.cms.gov.ddd.unit;

import org.testng.annotations.Test;
import java.util.List;

import org.testng.annotations.Test;

import dto.Student;
import query.StudentQueries;

public class QueriesTest {

	@Test
	public void student_queries() {
		List<Student> students = StudentQueries.getStudents();
		System.err.println(students.size());
		students.stream().forEach(e -> System.err.println(e.getFirstname()));
	}
}
