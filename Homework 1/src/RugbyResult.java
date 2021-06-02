
public class RugbyResult implements IResult {
	
	RugbyTeam contestantA;
	RugbyTeam contestantB;
	double teamApoints;
	double teamBpoints;
	
	public RugbyResult(RugbyTeam contestantA, RugbyTeam contestantB, double teamApoints, double teamBpoints) //constructor for rugby result
	{
		this.contestantA = contestantA;
		this.contestantB = contestantB;
		this.teamApoints = teamApoints;
		this.teamBpoints = teamBpoints;
	}
	
	public boolean isValid() { //returns true if the rugby result is valid (both teams will have less than 150 points)
		return ((this.teamApoints < 150.0) && (this.teamBpoints < 150.0));
	}
	
	public RugbyTeam getWinner() // returns the winner of the match based on the result
	{
		if (this.teamApoints > this.teamBpoints)
		{
			return (this.contestantA);
		}
		else
		{
			return (this.contestantB);
		}
	}
}



