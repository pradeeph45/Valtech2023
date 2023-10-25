package Day2;

import java.util.Comparator;

public class SortByName implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.Name.compareTo(o2.Name);
	}
	  
  }
