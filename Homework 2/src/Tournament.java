import java.util.LinkedList;

public class Tournament {
	
	LinkedList<IWinner> rounds;
	
	// constructor
	public Tournament(LinkedList<IWinner> rounds) {
		this.rounds = rounds;
	}
	
	// check if the input is a valid winner of the tournament
	boolean finalWinnerIsValid(IContestant inputContestant) {
		
		double numOfRounds = 0.0;
		int numOfWins = 0;
		
		for (IWinner round : rounds)      
		{
			numOfRounds = numOfRounds + 1.0 ;    // count the number of rounds in a match
			if(round.isWinner(inputContestant))
			{
				numOfWins = numOfWins + 1;  	// count the number of wins 
			}
		}
		
		return (numOfWins >= (numOfRounds / 2));
	}
}