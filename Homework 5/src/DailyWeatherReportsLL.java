import java.util.LinkedList;
import java.util.*;


/**
 * Represents a data structure (linked list) which holds DailyWeatherReport-s
 * @author Ivan
 *
 */
public class DailyWeatherReportsLL implements IDailyWeatherReports{
	
	private LinkedList<DailyWeatherReport> list;
	
	// Constructor
	public DailyWeatherReportsLL() { this.list = new LinkedList<DailyWeatherReport> ();}
	
	
	/**
	 * Adds a DailyWeatherReport to the list
	 * @param report is the report to be added
	 */
	public void add(DailyWeatherReport report) {
		this.list.add(report);
	}
	
	/**
	 * Filters out the DailyWeatherReports by month and year
	 * @param month is the month from 1 to 12 to filter by
	 * @param year is the year to filter by
	 * @return filteredReports which contain only reports of given month and year
	 */
	public DailyWeatherReportsLL filterByMonthAndYear(int month, int year) {
		
		DailyWeatherReportsLL filteredReports = new DailyWeatherReportsLL ();
		
		if(this.list.isEmpty()) {
			return filteredReports;}
		
		
		for (DailyWeatherReport report : list) {
			
			if (report.getDate().get(GregorianCalendar.MONTH) == (month - 1) && report.getDate().get(GregorianCalendar.YEAR) == year)
				{
					filteredReports.add(report);
				}
		}

		return filteredReports;
	}
	
	/**
	 * Produce the average monthly temperature for the given month and year
	 * @param month - the month for which we want to know the average temperature
	 * @param year - the year for which we want to know the average temperature
	 * @return the average temperature for the given month and tear, returns -999 if the
	 * list of DailyWeatherReports is empty, and returns -888 if the list does not contain
	 * any DailyReports with populated temperature values for the given month and year
	 */
	public double getAverageTemperatureForMonthAndYear(int month, int year) {
		DailyWeatherReportsLL forList = this.filterByMonthAndYear(month, year);
		if (forList.list.isEmpty()) {return -999;}
		
		double sum = 0.0;
		int numOfInvalidReadings = 0;
		
		for (DailyWeatherReport report : forList.list) {
			if (report.getAverageTemperature() == -888) 
			{
				numOfInvalidReadings++;
			}
			else {
				
			sum += report.getAverageTemperature();
			}
		}
		if (numOfInvalidReadings == forList.list.size()) {return -888;} // if all readings are invalid return -888
		return (sum/(forList.list.size() - numOfInvalidReadings)); // Otherwise return the average of the valid readings
	}
	
	/**
	 * Produce the total monthly rainfall for the given month and year
	 * @param month - the month for which we want to know the total rainfall
	 * @param year - the year for which we want to know the total rainfall
	 * @return the total rainfall for the given month and tear, returns -999 if the
	 * list of DailyWeatherReports is empty, and returns -888 if the list does not contain
	 * any DailyReports with populated rainfall values for the given month and year
	 */
	public double getTotalRainfallForMonthAndYear(int month, int year) {
		DailyWeatherReportsLL forList = this.filterByMonthAndYear(month, year);
		if (forList.list.isEmpty()) {return -999;}
		
		double sum = 0.0;
		int numOfInvalidReadings = 0; 						// keep track of all the invalid readings
		
		for (DailyWeatherReport report : forList.list) {
			if (report.getTotalRainfall() == -888) 
			{
				numOfInvalidReadings++;
			}
			else {
				
			sum += report.getTotalRainfall();
			}
		}
		if (numOfInvalidReadings == forList.list.size()) {return -888;} // if all readings are invalid return -888
		return (sum); 														// Otherwise return the sum of the valid readings
	}
	
	
}
