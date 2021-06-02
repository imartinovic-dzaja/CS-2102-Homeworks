import java.util.*;

/**
 * Represents a collection of daily readings for temperature and rainfall
 * from weather sensors
 * @author Ivan
 *
 */
public class DailyWeatherReport {
	private	GregorianCalendar date;
	private LinkedList<Double> temperatures;
	private LinkedList<Double> rainfalls; 
	
	// Constructor
	public DailyWeatherReport(GregorianCalendar date) {
		this.date = date;
		this.temperatures = new LinkedList<Double> ();
		this.rainfalls = new LinkedList<Double> ();
	}
	
	/**
	 * Adds a temperature reading to the list of readings
	 * @param temperature reading to be added
	 */
	public void addTemperature(double temperature) {
		this.temperatures.add(temperature);
	}
	
	/**
	 * Adds a rainfall reading to the list of reading
	 * @param rainfall reading to be added
	 */
	public void addRainfall(double rainfall) {
		this.rainfalls.add(rainfall);
	}
	
	/**
	 * Returns the date of the DailyWeatherReport
	 * @return
	 */
	public GregorianCalendar getDate() {
		return this.date;
	}
	
	/**
	 * Returns the daily average temperature
	 * @return returns the daily average temperature or -888 if the list of temperatures is empty
	 *  
	 */
	public double getAverageTemperature() {
		if (this.temperatures.isEmpty()) {return -888;}
		double sum = 0.0;
		for (Double temperature : this.temperatures)  {
			sum = sum + temperature;
		}
		return (sum/this.temperatures.size());
	}
	
	/**
	 * Returns the daily total rainfall 
	 * @return the total daily rainfall or -888 if the list of rainfall rainfalls is empty
	 */
	public double getTotalRainfall() {
		if (this.rainfalls.isEmpty()) {return -888;}
		double sum = 0.0;
		for (Double rainfall : this.rainfalls)  {
			sum = sum + rainfall;
		}
		return (sum);
	}
}
