package Day5;

import java.time.LocalDate;
import java.util.Date;

public class DateSample {

	public static void main(String[] args) {
		// index of year starts with 1900
		// index of month starts with 0
		// index of date starts with 1
		Date date = new Date(47, 7, 15);
		System.out.println(date);
		LocalDate localDate = LocalDate.of(1947, 8, 15);
		System.out.println(localDate);
	}

}
