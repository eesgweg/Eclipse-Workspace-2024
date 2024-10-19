package DatesTimes;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate today = LocalDate.now();
		LocalTime time = LocalTime.now();
		System.out.println(today);
		System.out.println("Day: "+today.getDayOfMonth()+" year: "+today.getYear()+" month: "+today.getMonth());
		System.out.println(today.getDayOfWeek());
		System.out.println(today.atTime(12, 0));
		System.out.println(today.plusDays(5));
		System.out.println(today.minusMonths(2));
		System.out.println(today.format(DateTimeFormatter.ofPattern("MM/dd/YYYY")));
		System.out.println(time);
		System.out.println(time.format(DateTimeFormatter.ofPattern("hh:mm:ss a")));
		System.out.println(time.getHour()+" "+time.getMinute()+" "+time.getSecond());
		System.out.println(time.plusHours(3));
		System.out.println(time.minusMinutes(40));
		System.out.println(LocalDate.of(2024, 12, 15));
		System.out.println(LocalTime.of(12,13,22));
				}

}
