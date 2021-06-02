import java.util.LinkedList;

/*
 * Contains utility for processing data from a sensor which tracks seismic activity
 */

class Earthquake2 {
  Earthquake2(){}
      
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
	  LinkedList<HzReport> sortedHzReports = sortDataInHzReports(filteredData);
	  LinkedList<MaxHzReport> outputList = new LinkedList<MaxHzReport> ();

	  for (HzReport report : sortedHzReports) {
		  outputList.add(new MaxHzReport(report.date, report.maxHz()));
	  }
	  
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
  
  
  /**
   * Sorts raw data from a seismic sensor into the list of HzReports properly initialized with the 
   * date and all data related to the given date
   * @param data - raw data from the sensor we are sorting
   * @return sortedHzReports - the list of data sorted in HzReports
   */
  public LinkedList<HzReport> sortDataInHzReports(LinkedList<Double> data)
  {
	  HzReport singleDate = new HzReport (data.get(0));
	  LinkedList<HzReport> sortedHzReports = new LinkedList<HzReport> ();	

	  for (int i = 1; i < data.size(); i++) {  
		  if (isDate(data.get(i))) {
			  sortedHzReports.add(singleDate);
			  singleDate.date = data.get(i);
		  }
		  else {
			  	singleDate.readings.add(data.get(i));
			   }
		  
	  }
	  sortedHzReports.add(singleDate);
	  return sortedHzReports;
  }
	 
}