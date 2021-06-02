import java.util.LinkedList;

/*
 * Contains utility for processing data from a sensor which tracks seismic activity
 */

class Earthquake1 {
  Earthquake1(){}

  // checks whether a datum is a date
  boolean isDate(double anum) { return (int)anum > 10000000; }
  // extracts the month from an 8-digit date
  int extractMonth(double dateNum) { return ((int)dateNum % 10000) / 100; }
 
  /**
   * Consumes a month expressed as an integer and a list of doubles representing data 
   * Produces a list of data with dates which fall within the inputed month along with the
   * max seismic reading for that particular date
   * @param data  - the raw data from the seismic sensor which has to be analysed
   * @param month - the month for which we are interested in
   * @return all daily maximums for all existing dates for the month of interest
   */
  public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data, int month) {
	  LinkedList<Double> filteredData = filterMonth(data, month);

	  Double currentDate = filteredData.get(0);
	  Double  maxDailyReading = 0.0;
	  
	  LinkedList<MaxHzReport> outputList = new LinkedList<MaxHzReport> ();

	  for (int i = 1; i < filteredData.size(); i++) {

		  if (isDate(filteredData.get(i))) {
			  outputList.add(new MaxHzReport(currentDate, maxDailyReading));
			  currentDate = filteredData.get(i);
			  maxDailyReading = 0.0;
		  }
		  else {
			  if (filteredData.get(i).doubleValue() > maxDailyReading.doubleValue()) {
				  maxDailyReading = filteredData.get(i);
			  }
		  }
	  }
	  outputList.add(new MaxHzReport(currentDate, maxDailyReading));
	  return outputList;
		 
}  
  
/**
 * Consumes a data set from a seismic sensor and a month of interest, and filters out the data
 * such that only data points which are relevant to the month of interest remain 
 * @param data - raw data which we are filtering
 * @param month - which we are interested in
 * @return the filtered data
 */
  public LinkedList<Double> filterMonth(LinkedList<Double> data, int month) {
	  boolean isInRightRange = false;
	  LinkedList<Double> filteredData = new LinkedList<Double> ();
	  
	  for (Double dataPoint : data) {
		  if (isDate(dataPoint)) {
			  if (extractMonth(dataPoint) == month) {
				  isInRightRange = true;
			  }
			  else {
				  isInRightRange = false;
			  }
		}
		if (isInRightRange == true) {
			filteredData.add(dataPoint);
		}
	  }
	  return filteredData;
  }
		  
  }
