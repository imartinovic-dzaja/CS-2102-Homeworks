import java.util.*;

/**
 * Represents a "platform" for monitoring weather trends 
 * such as average temperature and total rainfall
 * @author Ivan
 *
 */
public class WeatherMonitor {
	
	private IDailyWeatherReports reports;
	
	// Constructor
	public WeatherMonitor(IDailyWeatherReports reports) {
		this.reports = reports;
	}
	

	/**
	 * Produce the average monthly temperature for the given month and year
	 * @param month - the month for which we want to know the average temperature
	 * @param year - the year for which we want to know the average temperature
	 * @return the average temperature for the given month and tear, returns -999 if the
	 * list of DailyWeatherReports is empty, and returns -888 if the list does not contain
	 * any DailyReports with populated temperature values for the given month and year
	 */
	public double averageTempForMonth(int month, int year) {
		return (this.reports.getAverageTemperatureForMonthAndYear(month, year));
		}
	
	/**
	 * Produce the total monthly rainfall for the given month and year
	 * @param month - the month for which we want to know the total rainfall
	 * @param year - the year for which we want to know the total rainfall
	 * @return the total rainfall for the given month and tear, returns -999 if the
	 * list of DailyWeatherReports is empty, and returns -888 if the list does not contain
	 * any DailyReports with populated rainfall values for the given month and year
	 */
	public double totalRainfallForMonth(int month, int year) {
		return (this.reports.getTotalRainfallForMonthAndYear(month, year));
		}
	
	/**
	 * Adds a DailyWeatherReport to the reports field with given date and list of readings
	 * @param date for which we want to add a DailyWeatherReport
	 * @param readings are the corresponding readings for the DailyWeatherReport
	 */
	public void addDailyReport (GregorianCalendar date, LinkedList<Reading> readings) {
		DailyWeatherReport newReport = new DailyWeatherReport(date);

		if (readings.size() == 0) {
			reports.add(newReport);
			return;}
		
		for (Reading reading : readings) {
			newReport.addRainfall(reading.getRainfall());
			newReport.addTemperature(reading.getTemperature());
		}
		reports.add(newReport);
	}
}
