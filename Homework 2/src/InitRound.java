import java.util.LinkedList;

public class InitRound extends AbsRound {
	LinkedList<Match> matches;
	
	//constructor
	public InitRound (LinkedList<Match> matches){  
		super(matches);
	}
	
	/**
	 * goes through the list of matches and check if the contestant is among the winners any of the matches
	 * @param inputContestant is the contestant for which we are checking if he/she/they are the winner
	 * @return isTheWinner returns true if the InputContestant won at least a single match withing matches
	 */
	public boolean isWinner(IContestant inputContestant) {
		   boolean isTheWinner = false;
		   for (IContestant contestant : this.getMatchWinners())
		   {
			   if (inputContestant.equals(contestant))
			   {
				   isTheWinner = true;
				   break;
			   }
		   }
		   
		   return isTheWinner;
	 
	}
	


}
