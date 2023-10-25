package Day4;

public class Department {
private int deptId;
private String deptName;
private String deptLocation;
private int noOfEmployees;

public Department() {
	
}

public Department(int deptId, String deptName, String deptLocation, int noOfEmployees) {
	super();
	this.deptId = deptId;
	this.deptName = deptName;
	this.deptLocation = deptLocation;
	this.noOfEmployees = noOfEmployees;
}

@Override
public String toString() {
	return "Department [deptId=" + deptId + ", deptName=" + deptName + ", deptLocation=" + deptLocation
			+ ", noOfEmployees=" + noOfEmployees + "]";
}

public int getDeptId() {
	return deptId;
}
public void setDeptId(int deptId) {
	this.deptId = deptId;
}
public String getDeptName() {
	return deptName;
}
public void setDeptName(String deptName) {
	this.deptName = deptName;
}
public String getDeptLocation() {
	return deptLocation;
}
public void setDeptLocation(String deptLocation) {
	this.deptLocation = deptLocation;
}
public int getNoOfEmployees() {
	return noOfEmployees;
}
public void setNoOfEmployees(int noOfEmployees) {
	this.noOfEmployees = noOfEmployees;
}

}
