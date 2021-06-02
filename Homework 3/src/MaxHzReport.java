/*
 * Contains information about data from a seismic sensor
 * Holds a date and a maximum reading for that date
 */
class MaxHzReport {
  double date;
  double maxReading;

  MaxHzReport(double date, double maxread) {
    this.date = date;
    this.maxReading = maxread;
  }

  // the equals method for use in testing
	public boolean equals(Object other) 
	{
		if(!(other instanceof MaxHzReport)) 
		{
			return false;
		}
		
		MaxHzReport otherR = (MaxHzReport) other;
		
		return otherR.date == this.date &&
			otherR.maxReading == this.maxReading;
	}
  
  // the toString method so that reports display when tests fail
	public String toString()
	{
		return "Report["+ date + ", " + maxReading + "]";
	}
}
