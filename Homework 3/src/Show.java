import java.util.LinkedList;
/*
 * Contains information about a TV show
 */
class Show {

	String title;
	double broadcastTime;
	LinkedList<Episode> episodes;
	double avgLength;
	boolean isSpecial;
	
	public Show(String title, double broadcastTime, LinkedList<Episode> episodes, boolean isSpecial)
	{
		this.title = title;
		this.broadcastTime = broadcastTime;
		this.episodes = episodes;
		this.isSpecial = isSpecial;
	}
	
	/**
	 * Sets the average runtime of a TV show
	 * @param avgLength is the average time we are trying to set the runtime to
	 */
	public void setAvgLength(double avgLength)
	{
		this.avgLength = avgLength;
	}
	
}
