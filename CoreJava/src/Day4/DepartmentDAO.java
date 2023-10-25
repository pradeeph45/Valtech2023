package Day4;

import java.sql.SQLException;

public interface DepartmentDAO {
 void deleteDepartment(int deptId) throws SQLException;
 void updateDepartment(Department dep) throws SQLException;
 void createDepartment(Department dep) throws SQLException;
 Department getDepartment(int deptId) throws SQLException;

 


}
