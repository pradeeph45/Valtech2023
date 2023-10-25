package firstWeb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public void deleteEmployee(int id) throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("DELETE FROM EMPLOYEE WHERE ID=?");
		ps.setInt(1, id);
		int rowsUpdated = ps.executeUpdate();
		System.out.println("Rows Updated" + rowsUpdated);
		con.close();

	}

	@Override
	public void updateEmployee(Employee emp) throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con
				.prepareStatement("UPDATE EMPLOYEE SET NAME=?,AGE=?,EXPERIENCE=?,SENIORITY=?,SALARY=?,DEPT_ID=? WHERE ID=?");
		populatePreparedStatementFromEmployee(emp, ps);
		ps.setInt(6, emp.getId());
		int rowsUpdated = ps.executeUpdate();
		System.out.println("Rows Updated" + rowsUpdated);
		con.close();
	}

	@Override
	public void createEmployee(Employee emp) throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con
				.prepareStatement("INSERT INTO EMPLOYEE (NAME,AGE,EXPERIENCE,SENIORITY,SALARY,DEPT_ID) VALUES(?,?,?,?,?,?)");
		populatePreparedStatementFromEmployee(emp, ps);
		int rowsUpdated = ps.executeUpdate();
		System.out.println("Rows Updated" + rowsUpdated);
		con.close();
	}

	private void populatePreparedStatementFromEmployee(Employee emp, PreparedStatement ps) throws SQLException {
		ps.setString(1, emp.getName());
		ps.setInt(2, emp.getAge());
		ps.setInt(3, emp.getExperience());
		ps.setInt(4, emp.getSeniority());
		ps.setInt(5, emp.getSalary());
		ps.setInt(6, emp.getDeptId());
	}

	@Override
	public List<Employee> getAllEmployees() throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT ID,NAME,AGE,EXPERIENCE,SENIORITY,SALARY,DEPT_ID FROM EMPLOYEE");
		ResultSet rs = ps.executeQuery();
		List<Employee> emps = new ArrayList<>();
		while (rs.next()) {
			emps.add(mapRowToEmployee(rs));
		}
		con.close();
		return emps;
	}

	@Override
	public Employee getEmployee(int id) throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con
				.prepareStatement("SELECT ID,NAME,AGE,EXPERIENCE,SENIORITY,SALARY,DEPT_ID FROM EMPLOYEE WHERE ID=?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			Employee e = mapRowToEmployee(rs);
			con.close();
			return e;
		} else {
			System.out.println("No Row with id = " + id + " found...");
			return null;
		}
	}

	private Employee mapRowToEmployee(ResultSet rs) throws SQLException {
		Employee e = new Employee();
		e.setId(rs.getInt(1));
		e.setName(rs.getString(2));
		e.setAge(rs.getInt(3));
		e.setExperience(rs.getInt(4));
		e.setSeniority(rs.getInt(5));
		e.setSalary(rs.getInt(6));
		e.setDeptId(rs.getInt(7));
		return e;
	}

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private Connection getConnection() throws SQLException {

		return DriverManager.getConnection("jdbc:mysql://localhost:3306/valtech2023?useSSL=false", "root", "root");
	}


	@Override
	public long count() throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT COUNT(ID) FROM EMPLOYEE");
		ResultSet rs = ps.executeQuery();
		long count = 0;
		if (rs.next()) {
			count = rs.getLong(1);
		}
		con.close();
		return count;
	}

	@Override
	public List<Employee> getEmployeeByDepartmentLocation(String location) throws SQLException {
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("SELECT * FROM EMPLOYEE WHERE DEPT_ID IN (SELECT DEPT_ID FROM DEPARTMENT WHERE DEPTLOCATION=?)");
		ps.setString(1, location);
		ResultSet rs=ps.executeQuery();
		List<Employee> emp=new ArrayList<>();
		while(rs.next()) {
			emp.add(mapRowToEmployeeWithoutID(rs));
		}
		con.close();
		System.out.println(emp.size());
		return emp;
	}

	@Override
	public List<Employee> getEmployeeByDepartmentName(String name) throws SQLException{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("SELECT * FROM EMPLOYEE WHERE DEPT_ID IN (SELECT DEPT_ID FROM DEPARTMENT WHERE DEPTNAME=?)");
		ps.setString(1, name);
		ResultSet rs=ps.executeQuery();
		List<Employee> emp=new ArrayList<>();
		while(rs.next()) {
			emp.add(mapRowToEmployeeWithoutID(rs));
		}
		con.close();
		System.out.println(emp.size());
		return emp;
	}

	@Override
	public List<Employee> getEmployeesAgeBetween(int min, int max)throws SQLException {
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("SELECT * FROM EMPLOYEE WHERE AGE BETWEEN ? AND ?");
		ps.setInt(1, min);
		ps.setInt(2, max);
		ResultSet rs=ps.executeQuery();
		List<Employee> emp=new ArrayList<>();
		while(rs.next()) {
			emp.add(mapRowToEmployeeWithoutID(rs));
		}
		con.close();
		return emp;
	}

	@Override
	public List<Employee> getEmployeesBySeniority(int seniority)throws SQLException {
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("SELECT * FROM EMPLOYEE ORDER BY SENIORITY DESC LIMIT ?");
		ps.setInt(1, seniority);
		ResultSet rs=ps.executeQuery();
		List<Employee> emp=new ArrayList<>();
		while(rs.next()) {
			emp.add(mapRowToEmployeeWithoutID(rs));
		}
		con.close();
		return emp;
	}

	@Override
	public List<Employee> getEmployeesBySalaryGreaterThan(int salary)throws SQLException {
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("SELECT * FROM EMPLOYEE WHERE SALARY>=?");
		ps.setInt(1, salary);
		ResultSet rs=ps.executeQuery();
		List<Employee> emp=new ArrayList<>();
		while(rs.next()) {
			emp.add(mapRowToEmployeeWithoutID(rs));
		}
		con.close();
		return emp;
	}

	@Override
	public List<Employee> getEmployeesBySalaryLessThan(int salary) throws SQLException{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("SELECT * FROM EMPLOYEE WHERE SALARY<?");
		ps.setInt(1, salary);
		ResultSet rs=ps.executeQuery();
		List<Employee> emp=new ArrayList<>();
		while(rs.next()) {
			emp.add(mapRowToEmployeeWithoutID(rs));
		}
		con.close();
		return emp;
	}

	@Override
	public void getListOfEachEmployeeInDepartment() throws SQLException{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("UPDATE DEPARTMENT D SET EMPLIST=(SELECT COUNT(*) FROM EMPLOYEE E WHERE E.DEPTID=D.DEPTID)");
		int rowsUpdated=ps.executeUpdate();
		System.out.println("Rows update:"+rowsUpdated);
		con.close();
		
	}
	private Employee mapRowToEmployeeWithoutID(ResultSet rs) throws SQLException {
		Employee e=new Employee();
		
		e.setName(rs.getString(1));
		e.setAge(rs.getInt(2));
		e.setExperience(rs.getInt(3));
		e.setSeniority(rs.getInt(4));
		e.setSalary(rs.getInt(5));
		e.setId(rs.getInt(6));
		e.setDeptId(rs.getInt(7));
		return e;
	}
	
	public static void main(String[] args) throws SQLException {
		EmployeeDAO dao = new EmployeeDAOImpl();
//     System.out.println(dao.getEmployee(1));
//     System.out.println(dao.getEmployee(2));
	  // dao.createEmployee(new Employee("Ravi", 33, 5, 4, 102000,105));
//     Employee e=dao.getEmployee(3);
//     e.setSeniority(5);
//     dao.updateEmployee(e);
	  // dao.deleteEmployee(4);
	//	System.out.println(dao.count());
		//System.out.println(dao.getAllEmployees());
		//System.out.println(dao.getEmployeesBySeniority(1));
	}

	@Override
	public int firstId() throws SQLException {
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("SELECT MIN(ID) FROM EMPLOYEE");
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			int id=rs.getInt(1);
			con.close();
			return id;
		}
		return 0;
	}

	@Override
	public int lastId() throws SQLException {
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("SELECT MAX(ID) FROM EMPLOYEE");
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			int id=rs.getInt(1);
			con.close();
			return id;
		}
		return 0;
	}

	@Override
	public int nextId(int id) throws SQLException {
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("SELECT MIN(ID) FROM EMPLOYEE WHERE ID>?");
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			 id=rs.getInt(1);
			con.close();
			return id;
		}
		return id==0?lastId():id;
		
	}

	@Override
	public int previousId(int id) throws SQLException {
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("SELECT MAX(ID) FROM EMPLOYEE WHERE ID<?");
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			 id=rs.getInt(1);
			con.close();
			return id;
		}
		
		return id==0?firstId():id;
	}


}

