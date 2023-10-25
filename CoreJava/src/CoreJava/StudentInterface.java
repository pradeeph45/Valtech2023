package CoreJava;

import java.sql.SQLException;
import java.util.List;

import Day4.Employee;

public interface StudentInterface {
	  public long count() throws SQLException;
		void deleteStudent(int rollNo) throws SQLException;

		Student updateStudent(Student s) throws SQLException;

		Student createStudent(Student s) throws SQLException;

		List<Student> getAllStudents() throws SQLException;

		Student getStudent(int rollNo) throws SQLException;

}
