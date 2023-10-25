package CoreJava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentInterfaceImpl implements StudentInterface{

	@Override
	public long count() throws SQLException {
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("SELECT COUNT(ROLLNO) FROM STUDENT");
		ResultSet rs=ps.executeQuery();
		long len=0;
		while(rs.next()) {
			len=rs.getLong(1);
		}
		con.close();
		return len;
	}

	@Override
	public void deleteStudent(int rollNo) throws SQLException {
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("DELETE FROM STUDENT WHERE ROLLNO=?");
		ps.setInt(1, rollNo);
		int rowsUpdated=ps.executeUpdate();
		System.out.println("Rows Deleted = "+rowsUpdated);
		
		
	}

	@Override
	public Student updateStudent(Student s) throws SQLException {
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("UPDATE STUDENT SET NAME=? WHERE ID=?");
		ps.setString(1, s.getName());
		ps.setInt(2, s.getRollNo());
		int rowsUpdated=ps.executeUpdate();
		System.out.println("Rows Updated "+ rowsUpdated);
		con.close();
		return s;
		
	}

	@Override
	public Student createStudent(Student s) throws SQLException {
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("INSERT INTO STUDENT VALUES(?,?,?,?,?)");
		ps.setInt(1, s.getRollNo());
		ps.setString(2, s.getName());
		ps.setInt(3, s.getSem());
		ps.setString(4, s.getCourse());
		ps.setInt(5, s.getAge());
		int rowsUpdated=ps.executeUpdate();
		System.out.println("Rows Updated "+rowsUpdated);
		con.close();
		return s;
		
	}

	@Override
	public List<Student> getAllStudents() throws SQLException {
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("SELECT ROLLNO,NAME,CLASS,COURSE,AGE FROM STUDENT");
		ResultSet rs=ps.executeQuery();
		List<Student> list=new ArrayList<Student>();
		while(rs.next()) {
			
			list.add(mapRowsToStudent(rs));
		}
		con.close();
		return list;
	}

	@Override
	public Student getStudent(int rollNo) throws SQLException {
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("SELECT ROLLNO,NAME,CLASS,COURSE,AGE FROM STUDENT WHERE ROLLNO=?");
		ps.setInt(1,rollNo );
		ResultSet rs=ps.executeQuery();
		if (rs.next()) {
			Student s=mapRowsToStudent(rs);
			return s;
			
		}
		else {
			System.out.println("No Row found with rollNo "+rollNo);
		return null;}
	}
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/student2023?useSSL=false", "root", "root");
	}
	public Student mapRowsToStudent(ResultSet rs) throws SQLException {
		Student s=new Student();
		s.setRollNo(rs.getInt(1));
		s.setName(rs.getString(2));
		s.setSem(rs.getInt(3));
		s.setCourse(rs.getString(4));
		s.setAge(rs.getInt(5));
		return s;
		
	}
   public static void main(String[] args) throws SQLException {
	StudentInterfaceImpl si=new StudentInterfaceImpl();
//	   System.out.println(si.createStudent(new Student(1,"Abhi",7,"CSE",21)));
//	   System.out.println(si.createStudent(new Student(2,"Alone Musk",4,"CSE",20)));
	System.out.println(si.getAllStudents());
//	System.out.println(si.getStudent(1));
	//System.out.println(si.count());
	si.deleteStudent(1);
	System.out.println(si.getAllStudents());
}
}
