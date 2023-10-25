package Day4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentDAOImpl implements DepartmentDAO {

	@Override
	public void deleteDepartment(int deptId) throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("DELETE FROM DEPARTMENT WHERE DEPT_ID=?");
		ps.setInt(1, deptId);
		int rowsUpdated = ps.executeUpdate();
		System.out.println("Rows Updated = " + rowsUpdated);
		con.close();

	}

	@Override
	public void updateDepartment(Department dep) throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con
				.prepareStatement("UPDATE DEPARTMENT SET DEPTNAME=?,DEPTLOCATION=?,NOOFEMPLOYEES=? WHERE DEPT_ID=?");
		ps.setInt(4, dep.getDeptId());
		int rowsUpdated = ps.executeUpdate();
		System.out.println("Rows Updated = " + rowsUpdated);
		con.close();

	}

	@Override
	public void createDepartment(Department dep) throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement(
				"INSERT INTO DEPARTMENT(DEPT_ID,DEPTNAME,DEPTLOCATION,NOOFEMPLOYEES) VALUES(?,?,?,?)");
		ps.setInt(1, dep.getDeptId());
		ps.setString(2, dep.getDeptName());
		ps.setString(3, dep.getDeptLocation());
		ps.setInt(4, dep.getNoOfEmployees());
		int rowsUpdated = ps.executeUpdate();
		System.out.println("Rows Updated = " + rowsUpdated);
		con.close();

	}

	@Override
	public Department getDepartment(int deptId) throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con
				.prepareStatement("SELECT DEPT_ID,DEPTNAME,DEPTLOCATION,NOOFEMPLOYEES FROM DEPARTMENT WHERE DEPT_ID=?");
		ps.setInt(1, deptId);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			Department dep = mapRowToDepartment(rs);
			con.close();
			return dep;
		} else {
			System.out.println("No Row with Dept_Id " + deptId + " found");
			return null;
		}
	}

	private Department mapRowToDepartment(ResultSet rs) throws SQLException {
		Department dep = new Department();
		dep.setDeptId(rs.getInt(1));
		dep.setDeptName(rs.getString(2));
		dep.setDeptLocation(rs.getString(3));
		dep.setNoOfEmployees(rs.getInt(4));
		return dep;

	}

	static {
		try {
			Class.forName("com.mysql.jdbc.driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/valtech2023?useSSL=false", "root", "root");
	}

	public static void main(String[] args) throws SQLException {
		DepartmentDAO dep = new DepartmentDAOImpl();
//	dep.createDepartment(new Department(101,"HR","1st Floor",25));
//dep.createDepartment(new Department(102,"Retail","2nd Floor",50));
		// dep.createDepartment(new Department(103,"Finance","3rd Floor",30));
//dep.createDepartment(new Department(104,"IT","4th Floor",20));
//	dep.createDepartment(new Department(105,"L&D","Ground Floor",10));
		// System.out.println(dep.getDepartment(101));
		// System.out.println(dep.getDepartment(102));
//	System.out.println(dep.getDepartment(103));
//	System.out.println(dep.getDepartment(104));
		//System.out.println(dep.getDepartment(105));
		
		
	}
}
