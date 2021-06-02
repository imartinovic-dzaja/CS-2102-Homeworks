/**
 * Represents any data structure which holds DailyWeatherReports
 * @author Ivan
 *
 */

public interface IDailyWeatherReports {
	
	/**
	 * Filters out DailyWeatherReports based on month and year
	 * @param month - the month by which we want to filter reports
	 * @param year - the year by which we want to filter reports
	 * @return - the filtered DailyWeather reports 
	 */
	public IDailyWeatherReports filterByMonthAndYear(int month, int year);
	
	/**
	 * Adds a DailyWeatherReport to the data structure
	 * @param report
	 */
	public void add(DailyWeatherReport report);
	
	/**
	 * Produce the average monthly temperature for the given month and year
	 * @param month - the month for which we want to know the average temperature
	 * @param year - the year for which we want to know the average temperature
	 * @return the average temperature for the given month and tear, returns -999 if the
	 * list of DailyWeatherReports is empty, and returns -888 if the list does not contain
	 * any DailyReports with populated temperature values for the given month and year
	 */
	public double getAverageTemperatureForMonthAndYear(int month, int year);
	
	/**
	 * Produce the total monthly rainfall for the given month and year
	 * @param month - the month for which we want to know the total rainfall
	 * @param year - the year for which we want to know the total rainfall
	 * @return the total rainfall for the given month and tear, returns -999 if the
	 * list of DailyWeatherReports is empty, and returns -888 if the list does not contain
	 * any DailyReports with populated rainfall values for the given month and year
	 */
	public double getTotalRainfallForMonthAndYear(int month, int year);
	
}
