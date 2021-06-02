import java.util.LinkedList;

/*
 * Contains statistic utilities for analysing runtimes of a list of shows
 */
class DataSmooth1 {
  DataSmooth1(){}
  
  /**
   * creates a list of smoothed average runtimes for the inputed list of shows
   * @param shows is the list of shows we want to find the smoothed runtimes for
   * @return the smoothed average runtimes
   */ 
  public LinkedList<Double> dataSmooth(LinkedList<Show> shows)  // include check when shows is empty
  {	  
	  for (Show show : shows) {
		  double runtimeSum = 0;
		  int numOfEpisodes = 0;   // needs exception handling
		  
		  for (Episode episode : show.episodes) {
			  runtimeSum = runtimeSum + episode.runTime;
			  numOfEpisodes++;
		  }
		  
		  if (numOfEpisodes == 0) {
			  show.setAvgLength(0.0);
		  }
		  
		  else {
			  show.setAvgLength(runtimeSum/numOfEpisodes);
		  }
	  }
	  
  	return smoothOutRuntimes(shows);
  }
  
  /**
   * smooths out a the average runtimes of a list of shows, where the first and last element are 
   * the same as in the original list, and all intermediate values are the average of the values
   * before and after it
   * @param rawValues is the list of doubles we want to smooth
   * @return the smoothed values 
   */
  public LinkedList<Double> smoothOutRuntimes (LinkedList<Show> shows) {
	  LinkedList<Double> smoothValues = new LinkedList<Double> ();
	  smoothValues.add(shows.get(0).avgLength);
	  for (int i = 1; i < shows.size() - 1; i++) {
		  smoothValues.add((shows.get(i-1).avgLength + shows.get(i).avgLength +shows.get(i+1).avgLength)/3);
  	  }
	  smoothValues.add(shows.get(shows.size() - 1).avgLength);
	  return smoothValues;
  }
}
