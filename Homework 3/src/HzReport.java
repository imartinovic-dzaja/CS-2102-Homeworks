import java.util.LinkedList;

/*
 * Contains information about data from a seismic sensor
 * Holds a date and a a list of readings for that date
 */

public class HzReport {
	double date;
	LinkedList<Double> readings = new LinkedList<Double> ();
	
	public HzReport (double date){
		this.date = date;
	}
	
	/**
	 * Returns the maximum recorded daily reading of frequency for the given HzReport
	 * @return the maximum value among the list of doubles inside the readings field
	 */
	public double maxHz() {
		double maxValue = 0.0;
		for (Double reading : readings) {
			if (reading.doubleValue() > maxValue)
			{maxValue = reading.doubleValue();}
		}
	return maxValue;
	}
}	
