package jodatimeapi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class JodaTimeApiExplanation {

	/**
	 * The new Date and Time API of Java 8 is based on Joda Time API (joda.org)
	 * First, let's talk about LocalDate, LocalTime and LocalDateTime classes
	 */
	public static void localDateTimeExamples() {
		// LocalDate refers to date only
		System.out.println(LocalDate.now()); // the now() method returns current local date
		
		// LocalTime refers to time only
		System.out.println(LocalTime.now()); // in this case, now() method returns current local time
		
		// LocalDateTime refers to date and time
		System.out.println(LocalDateTime.now()); // here, now() method returns current local date and time
	}
	
	/**
	 * Utilities:
	 * There are many methods from these three classes, that provides easier development
	 */
	public static void utilitiesExamples() {
		// Both classes has these methods, and of course, which used on appropriated
		System.out.println(LocalDateTime.now().getNano()); // get milliseconds from the LocalDateTime or LocalTime
		System.out.println(LocalDateTime.now().getSecond()); // get seconds from LocalDateTime or LocalTime
		System.out.println(LocalDateTime.now().getHour()); // get hour from LocalDateTime or LocalTime
		System.out.println(LocalDateTime.now().getDayOfMonth()); // get day of month from LocalDateTime or LocalDate
		System.out.println(LocalDateTime.now().getMonth()); // get month from LocalDateTime or LocalDate
		System.out.println(LocalDateTime.now().getYear()); // get year from LocalDateTime or LocalDate
		
		// There are many other methods that you can check deeply in:
		// https://docs.oracle.com/javase/8/docs/api/java/time/LocalDateTime.html
	}
	
	/**
	 * Operations:
	 * Now there are simpler methods that provide operations on date and time objects from new API
	 */
	public static void operationsExamples() {
		
		// Firstly, we can also instantiate a new LocalDateTime this way:
		LocalDateTime dt1 = LocalDateTime.of(2018, Month.MAY, 8, 14, 36);
		System.out.println(dt1);
		
		// You can also provide less parameters 
		dt1 = LocalDateTime.of(2000, 1, 1, 12, 30);
		System.out.println(dt1);
		
		// It is also possible to pass Integer value instead of the month enumeration
		dt1 = LocalDateTime.of(2018, 05, 8, 14, 45);
		
		System.out.println(dt1);
		System.out.println("After six months: " + dt1.plusMonths(6)); // The date after 6 months
		System.out.println("Before six months: " + dt1.minusMonths(6)); // The date 6 months before
		System.out.println("Before 1000 minutes: " + dt1.minus(1000L, ChronoUnit.MINUTES)); // Before 1000 minutes
		
		// There are many other functionalities that you can check in:
		// https://docs.oracle.com/javase/8/docs/api/java/time/package-summary.html
	}
	
	/**
	 * Zone:
	 * ZoneId object can be used to represent Zone
	 * And ZonedDateTime is a DateTime object based on a zone
	 */
	public static void zoneExamples() {
		ZoneId zone = ZoneId.systemDefault(); // Get the local zone of the system
		System.out.println(zone);

		ZoneId la = ZoneId.of("America/Los_Angeles"); // Instantiate a ZoneId based on zone id
		ZonedDateTime zt = ZonedDateTime.now(la); // Get the date time based on Zone
		System.out.println(zt);
		
		// More in: https://docs.oracle.com/javase/8/docs/api/java/time/ZoneId.html and related
	}
	
	/**
	 * Period:
	 * Period object can be used to represent quantity of time
	 */
	public static void periodExample() {
		LocalDate today = LocalDate.now();
		LocalDate birthday = LocalDate.of(1985, 11, 29);
		Period p = Period.between(birthday, today); // It will return a Period object containing the difference between these 2 dates
		System.out.printf("age is %d year %d months %d days", p.getYears(), p.getMonths(), p.getDays()); // This will print my age :)
		
		// More in: https://docs.oracle.com/javase/8/docs/api/java/time/Period.html
	}

	/**
	 * Execution of examples
	 */	
	public static void main(String[] args) {
		localDateTimeExamples();
		utilitiesExamples();
		operationsExamples();
		zoneExamples();
		periodExample();
	}
}
