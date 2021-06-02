import java.util.LinkedList;

/**
 * represents a round in a tournament 
 * @author Ivan
 *
 */
public abstract class AbsRound implements IWinner {
	LinkedList<Match> matches;
	
	// constructor
	public AbsRound (LinkedList<Match> matches) {
		this.matches = matches;
	}
	
	/**
	 * goes through all matches of the round and creates a list of all the winners of each match
	 * @param 
	 * @return the list of winners of each match in a round
	 */
   	public LinkedList<IContestant> getMatchWinners(){
		   
		 LinkedList<IContestant> winners = new LinkedList<IContestant>();
			   
		 for (Match m : matches) {
			 if (!(m.winner() == null)) {
			 winners.add(m.winner());
			 }
		}
		 return winners;
	 }
   	
   	
   	/**
   	 * Goes through the matches in the round and counts the number of winners
   	 * @param  
   	 * @return The number of winners of all matches in the round
   	 */ 	
	public int getNumWinners() {
		int numWinners = 0;
		for (IContestant contestant: this.getMatchWinners())
		{
			numWinners = numWinners + 1;
		}
		return numWinners;
	}
	
}



