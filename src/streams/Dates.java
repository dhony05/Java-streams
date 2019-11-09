package streams;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class Dates {
	
	public static void main(String[] args) {
		
		Date date = new Date();
		System.out.println("Date: " + date);
		
		//date.getMonth();
		
		// LOCAL
		
		LocalDateTime localTime = LocalDateTime.now();
		System.out.println("\nLocal Time: " + localTime);
		
		LocalDate localDate = LocalDate.now();
		System.out.println("\nLocal Date: " + localDate);
		
		// covert from local time to local date
		localDate = localTime.toLocalDate();
		
		// getMonth method in local time and local date
		Month month = localTime.getMonth();
		String monthToString = month.toString().substring(0,1) + month.toString().substring(1).toLowerCase();
		System.out.println("Current month: " + monthToString);
		
		int day = localTime.getDayOfMonth();
		String dayToString = "";
		String[]ordinal = {"n/a","st","nd","rd","th"};
		for (int i = 0; i < ordinal.length; i++) {
			if(day <=3) {
				dayToString = String.valueOf(day) + ordinal[day];
			} else {
				dayToString = String.valueOf(day) + ordinal[ordinal.length-1];
			}
		}
		System.out.println("Day of Month: " + dayToString);
		
		int seconds = localTime.getSecond();
		System.out.println("Seconds: " + seconds);
		
		
		LocalDate day2 = LocalDate.of(1999, 7, 23);
		System.out.println(day2);
		
		LocalDateTime day3 = localTime.withDayOfMonth(10)
				.withYear(2003)
				.withMonth(2)
				.withHour(12);
		System.out.println(day3);
		
		LocalTime time = LocalTime.of(13, 30);
		System.out.println(time);
		
		
		
		// ZONED
		
		ZonedDateTime zDate = 
				ZonedDateTime.parse("2019-04-01T16:24:11.252+05:30[Asia/Calcutta]");
		
		System.out.println("Zoned date: " + zDate);
		
		//convert between time zones
		ZoneId id = ZoneId.of("Europe/Paris");
		System.out.println("ID for Paris: " + id);
		
		ZonedDateTime parisTime = zDate.toInstant().atZone(id);
		System.out.println("Paris time: " + parisTime);
		
		
		// add days to the time
		ZonedDateTime zDate2 = zDate.plus(Period.ofDays(10));
		System.out.println("10 days later: " + zDate2);
		
		
		// get your time zone
		ZoneId currentTimeZone = ZoneId.systemDefault();
		System.out.println("Time zone: " + currentTimeZone);
		
		
		
		
		
	}

}

