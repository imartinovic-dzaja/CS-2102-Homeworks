import java.util.LinkedList;

/*
 * Contains statistic utilities for analysing runtimes of a list of shows
 */

class DataSmooth2 {
  DataSmooth2(){}
  
  
  /**
   * creates a list of smoothed average runtimes for the inputed list of shows
   * @param shows is the list of shows we want to find the smoothed runtimes for
   * @return the smoothed average runtimes
   */
  public LinkedList<Double> dataSmooth(LinkedList<Show> shows)  
  {
	  LinkedList<Double> rawRuntimes = new LinkedList<Double> ();
	  
	  for (Show show : shows) {
		  LinkedList<Double> runtimes = getShowRuntimes(show);
		  
		  rawRuntimes.add(getAverage(runtimes));
	  }
	  
   	  return smoothOut(rawRuntimes);
  	
  }  
  
  
  /**
   * creates a list of runtimes for a show
   * @param show for which we want to construct the list of runtimes
   * @return runtimesForASingleShow i.e. the list of runtimes of the show
   */
  public LinkedList<Double> getShowRuntimes (Show show) {
	  LinkedList<Double> runtimesForASingleShow = new LinkedList<Double> ();
	  
	  for (Episode episode : show.episodes) {
		  runtimesForASingleShow.add(new Double(episode.runTime));
	  }
  return runtimesForASingleShow;
  }
  
  
  /**
   * Calculates the average runtime from a list of runtimes
   * If the list is empty returns 0.0
   * @param runtimes the list for which we want to find the average
   * @return the average runtime
   */
  public Double getAverage (LinkedList<Double> runtimes) {
	  double runtimeSum = 0.0;
	  for (Double runtime : runtimes) {
		  runtimeSum = runtimeSum + runtime;
	  }
	  
	  if (runtimes.equals(new LinkedList<Double> ())) {
		 return 0.0;
	  }
	  
	  else {
		  return (runtimeSum/runtimes.size());
	  }
  }
  
  
  /**
   * smooths out a given list of doubles, where the first and last element are the same as in the 
   * original list, and all intermediate values are the average of the values before and after it
   * @param rawValues is the list of doubles we want to smooth
   * @return the smoothed values 
   */
  public LinkedList<Double> smoothOut (LinkedList<Double> rawValues) {
	  LinkedList<Double> smoothValues = new LinkedList<Double> ();
	  smoothValues.add(rawValues.get(0));
	  for (int i = 1; i < rawValues.size() - 1; i++) {
		  smoothValues.add((rawValues.get(i-1) + rawValues.get(i) + rawValues.get(i+1))/3);
  	  }
	  smoothValues.add(rawValues.get(rawValues.size() - 1));
	  return smoothValues;
  }
}