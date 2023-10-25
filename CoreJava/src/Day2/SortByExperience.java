package Day2;

import java.util.Comparator;

public class SortByExperience implements Comparator<Employee> {
@Override
public int compare(Employee o1, Employee o2) {
	
	return o2.experience-o1.experience;
}
}
