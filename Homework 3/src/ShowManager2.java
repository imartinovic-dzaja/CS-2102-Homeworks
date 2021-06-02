import java.util.LinkedList;

/**
 * Contains utility for managing Shows
 */
class ShowManager2 {
	
	ShowManager2() {}

	/**
	 * Sorts non-special shows in different categories based on them being a daytime, 
	 * primetime or latenight show
	 * @param shows is the list of shows we want to organize
	 * @return the summary of the shows sorted in their respective categories
	 */
	public ShowSummary organizeShows(LinkedList<Show> shows)
	{
		LinkedList<Show> dayTime = new LinkedList<Show> ();
		LinkedList<Show> primeTime = new LinkedList<Show> ();
		
		LinkedList<Show> filter1 = new LinkedList<Show> ();
		LinkedList<Show> filter2 = new LinkedList<Show> ();
		LinkedList<Show> filter3 = new LinkedList<Show> ();

		
		for (Show show : shows) {
			if (show.isSpecial || (show.broadcastTime >= 100 && show.broadcastTime < 600)) {break;}
			else {filter1.add(show);}
		}
		
		for (Show show : filter1) {
			if (show.broadcastTime >= 600 && show.broadcastTime < 1700 ) {dayTime.add(show);}
			else {filter2.add(show);}
		}
		
		for (Show show : filter2) {
			if (show.broadcastTime >= 1700 && show.broadcastTime < 2000 ) {primeTime.add(show);}
			else {filter3.add(show);}
		}
		
		return (new ShowSummary(dayTime, primeTime, filter3));

	}
	
}
