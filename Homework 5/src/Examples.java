import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;
import java.util.LinkedList;

// Student who worked on the assignment: Ivan Martinovic

public class Examples {
	
	
	// Examples of a Time objects
		Time time1 = new Time (10 , 10);
		Time time2 = new Time(20, 20);
		Time time3 = new Time(15, 35);
		
	// Examples of a Reading objects
	Reading reading1 = new Reading (time1, 50, 50);
	Reading reading2 = new Reading(time2, 0, 0);
	Reading reading3 = new Reading(time3, 25, 25);
	
	
// Dates
	
// A single date for a specific month and year
GregorianCalendar date1 = new GregorianCalendar (2000 , 0, 1);

// Another single date for a specific month and year

GregorianCalendar date2 = new GregorianCalendar (2001 , 0, 10);
	
// Another single date for a specific month and year	
GregorianCalendar date3 = new GregorianCalendar (2002 , 0, 20);

// Two dates with the same month and year

GregorianCalendar date4 = new GregorianCalendar (1995 , 11, 15);

GregorianCalendar date5 = new GregorianCalendar (1995 , 11, 20);	

// Another Two dates with the same month and year 
	
GregorianCalendar date6 = new GregorianCalendar (1997 , 0, 20);

GregorianCalendar date7 = new GregorianCalendar (1997 , 0, 21);


		
	WeatherMonitor weatherMonitor = new WeatherMonitor(new DailyWeatherReportsLL());

	
	@Before
	public void setup() {

	
	// List of Daily Weather Reports
	
	LinkedList<Reading> listForDate1 = new LinkedList<Reading>();
	listForDate1.add(reading1);
	listForDate1.add(reading2);
	listForDate1.add(reading3);

	LinkedList<Reading> listForDate2 = new LinkedList<Reading>();
	
	LinkedList<Reading> listForDate3 = new LinkedList<Reading>();
	listForDate3.add(reading1);

	
	LinkedList<Reading> listForDate4 = new LinkedList<Reading>();
	listForDate4.add(reading1);
	listForDate4.add(reading2);

	LinkedList<Reading> listForDate5 = new LinkedList<Reading>();
	listForDate5.add(reading2);
	listForDate5.add(reading3);
	
	LinkedList<Reading> listForDate6 = new LinkedList<Reading>();
	listForDate6.add(reading1);
	listForDate6.add(reading2);
	listForDate6.add(reading3);
	
	LinkedList<Reading> listForDate7 = new LinkedList<Reading>();
	
	
	// Weather Monitor
	weatherMonitor.addDailyReport(date1, listForDate1);
	weatherMonitor.addDailyReport(date2, listForDate2);
	weatherMonitor.addDailyReport(date3, listForDate3);
	weatherMonitor.addDailyReport(date4, listForDate4);
	weatherMonitor.addDailyReport(date5, listForDate5);
	weatherMonitor.addDailyReport(date6, listForDate6);
	weatherMonitor.addDailyReport(date7, listForDate7);
	}
		
	
	@Test
	public void testAvgTempForMonthWhenNoEntriesExistsForSpecifiedMonthAndYear() {
		assertEquals(-999, weatherMonitor.averageTempForMonth(1, 3000), 1);
	}
	
	@Test
	public void testAvgTempForMonthWhenThereIsOnlyADateWithEmptyReadings() {
		assertEquals(-888, weatherMonitor.averageTempForMonth(1, 2001), 1);
	}
	
	@Test
	public void testAvgTempForMonthWhenThereIsOnlyOneReadingForTheGivenMonthAndYear() {
		assertEquals(50.0, weatherMonitor.averageTempForMonth(1, 2002), 1);
	}
	
	@Test
	public void testAvgTempForMonthWhenTheIsOnlyOneMatchingDateWithManyReadings() {
		assertEquals(25.0, weatherMonitor.averageTempForMonth(1, 2000), 1);
	}
	
	@Test
	public void testAvgTempForMonthWhenThereAreTwoMatchingDatesWithManyReadings() {
		assertEquals(18.75, weatherMonitor.averageTempForMonth(12, 1995), 1);
	}
	
	@Test 
	public void testAvgTempForMonthWhenThereAreTwoMatchingDatesOneWithAndOneWithoutReadings() {
		assertEquals(25, weatherMonitor.averageTempForMonth(1, 1997), 1);
	}
	/////////////////////////////////////
	
	@Test
	public void testTotalRainfallforMonthWhenNoEntriesExistsForSpecifiedMonthAndYear() {
		assertEquals(-999, weatherMonitor.totalRainfallForMonth(1, 3000), 1);
	}
	
	@Test
	public void testTotalRainfallForMonthWhenThereIsOnlyADateWithEmptyReadings() {
		assertEquals(-888, weatherMonitor.totalRainfallForMonth(1, 2001), 1);
	}
	
	@Test
	public void testTotalRainfallForMonthWhenThereIsOnlyOneReadingForTheGivenMonthAndYear() {
		assertEquals(50.0, weatherMonitor.totalRainfallForMonth(1, 2002), 1);
	}
	
	@Test
	public void testTotalRainfallForMonthWhenTheIsOnlyOneMatchingDateWithManyReadings() {
		assertEquals(75.0, weatherMonitor.totalRainfallForMonth(1, 2000), 1);
	}
	
	@Test
	public void testTotalRainfallForMonthWhenThereAreTwoMatchingDatesWithManyReadings() {
		assertEquals(75.0, weatherMonitor.totalRainfallForMonth(12, 1995), 1);
	}
	
	@Test 
	public void testTotalRainfallForMonthWhenThereAreTwoMatchingDatesOneWithAndOneWithoutReadings() {
		assertEquals(75.0, weatherMonitor.totalRainfallForMonth(1, 1997), 1);
	}
	
	
	
}
