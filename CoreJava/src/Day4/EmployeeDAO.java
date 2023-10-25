package Day4;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
    public long count() throws SQLException;
	void deleteEmployee(int id) throws SQLException;

	void updateEmployee(Employee emp) throws SQLException;

	void createEmployee(Employee emp) throws SQLException;

	List<Employee> getAllEmployees() throws SQLException;

	Employee getEmployee(int id) throws SQLException;
	
	List<Employee> getEmployeeByDepartmentLocation(String name) throws SQLException;
	List<Employee> getEmployeeByDepartmentName(String name)throws SQLException ;
	List<Employee> getEmployeesAgeBetween(int min,int max)throws SQLException;
	List<Employee> getEmployeesBySeniority(int seniority)throws SQLException;
	List<Employee> getEmployeesBySalaryGreaterThan(int salary)throws SQLException;
	List<Employee> getEmployeesBySalaryLessThan(int salary)throws SQLException;
	void getListOfEachEmployeeInDepartment()throws SQLException;

}