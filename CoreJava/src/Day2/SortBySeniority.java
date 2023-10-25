package Day2;

import java.util.Comparator;

public class SortBySeniority implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		return o2.seniority-o1.seniority;
	}
	  
  }
