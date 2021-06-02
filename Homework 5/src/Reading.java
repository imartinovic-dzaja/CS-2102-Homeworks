/**
 * Represents a reading from a weather sensor
 * @author Ivan
 *
 */

public class Reading {
	private Time time;
	private double temperature;
	private double rainfallSinceLast;
	
	//Constructor
	public Reading(Time time, double temperature, double rainfallSinceLast) {
		this.time = time;
		this.temperature = temperature;
		this.rainfallSinceLast = rainfallSinceLast;
	}
	
	
	/**
	 * returns the field value for temperature
	 * @return the reading for temperature 
	 */
	public double getTemperature() {
		return this.temperature;
	}
	
	/**
	 * returns the field value for rainfall
	 * @return the reading for rainfall
	 */
	public double getRainfall() {
		return this.rainfallSinceLast;
	}
}
