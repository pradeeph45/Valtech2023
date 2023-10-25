package Day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Employee {
  String Name;
  int age;
  double salary;
  int seniority;
  int experience;
  public Employee(String Name,int age,double salary,int seniority,int experience) {
	  this.Name=Name;
	  this.age=age;
	  this.salary=salary;
	  this.seniority=seniority;
	  this.experience=experience;
  }
  public String getName() {
	  return Name;
  }

  @Override
	public String toString() {
		
		return "Name = "+ Name + " Age = "+age+" salary = "+salary+ " experience = "+experience+ " seniority = "+seniority;
	}
  
  
  
  public static void main(String[] args) {
	ArrayList<Employee> a=new ArrayList<>();
	a.add(new Employee("Pradeep", 27, 60000, 5, 3));
	a.add(new Employee("Praveen", 28, 70000, 4, 4));
	a.add(new Employee("Kartik", 29, 90000, 2, 6));
	a.add(new Employee("Murali", 31, 100000, 1, 7));
	a.add(new Employee("Govind", 30, 60000, 3, 5));
	
	System.out.println("Sorting by experience");
	Collections.sort(a, new SortByExperience());
	for(Employee e:a) {
		System.out.println(e);
	}
	System.out.println();
    
	System.out.println("Sorting by seniority");
	Collections.sort(a, new SortBySeniority());
	for(Employee e:a) {
		System.out.println(e);
	}
    System.out.println();
    
    System.out.println("Sorting by name");
	Collections.sort(a, new SortByName());
	for(Employee e:a) {
		System.out.println(e);
	}
}
}
