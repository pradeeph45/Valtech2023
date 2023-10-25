package CoreJava;

import java.sql.ResultSet;

public class Student {
private int rollNo;
private String name;
private int sem;
private String course;
private int age;

public Student() {

}

public String toString() {
return "Student [rollNo=" + rollNo + ", name=" + name + ", sem=" + sem + ", Course=" + course + ", age="
		+ age  + "]";
}

public Student(int rollNo, String name, int sem, String course, int age) {
	
	this.rollNo = rollNo;
	this.name = name;
	this.sem = sem;
	this.course = course;
	this.age = age;
}
public int getRollNo() {
	return rollNo;
}
public void setRollNo(int rollNo) {
	this.rollNo = rollNo;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getSem() {
	return sem;
}
public void setSem(int i) {
	this.sem =  i;
}
public String getCourse() {
	return course;
}
public void setCourse(String course) {
	this.course = course;
}
public int getAge() {
	return age;
}
public int setAge(int age) {
	return this.age = age;
}


}
