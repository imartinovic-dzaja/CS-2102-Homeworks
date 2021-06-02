import java.util.LinkedList;
/**
 * Contains utility for managing Shows
 */
class ShowManager1 {
	
	ShowManager1() {}

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
	LinkedList<Show> lateNight = new LinkedList<Show> ();
	
	for (Show show : shows) {
		if (show.isSpecial || (show.broadcastTime >= 100 && show.broadcastTime < 600)) {break;}
		if (show.broadcastTime >= 600 && show.broadcastTime < 1700 ) {dayTime.add(show);}
		else if (show.broadcastTime >= 1700 && show.broadcastTime < 2000 ) {primeTime.add(show);}
		else if (show.broadcastTime >= 2000 || show.broadcastTime < 100 ) {lateNight.add(show);}
		else {break;}
	    }
	
	return (new ShowSummary(dayTime, primeTime, lateNight));

	}
}

