
public class Match {
	
	IContestant contestantA;
	IContestant contestantB;
	IResult result; 
	
	public Match(IContestant contestantA, IContestant contestantB, IResult result) // constructor for Match
	{
		this.contestantA = contestantA;
		this.contestantB = contestantB;
		this.result = result;
	}
	
	public IContestant winner() { 				// returns the winner of a match (assuming there are not ties
		if (result.isValid())
		{
			return result.getWinner();
		}
		else
		{
			return null;
		}
	}
}



