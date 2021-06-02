
public class RugbyTeam implements IContestant {
	
	String name;
	String country;
	String jerseyColor;
	boolean hasRitual;
	int wins;
	int losses;
	
	public RugbyTeam(String country, String jerseyColor, boolean hasRitual, int wins, int losses) //constructor for rugby team
	{
		this.country = country;
		this.jerseyColor = jerseyColor;
		this.hasRitual = hasRitual;
		this.wins = wins;
		this.losses = losses;
	}
	
	public boolean expectToBeat(RugbyTeam opposingTeam) // returns true if the current team is expected to beat the consumed team
	{
		if (this.hasRitual)
		{
			if (opposingTeam.hasRitual)
			{
				return ((this.wins - this.losses) > (opposingTeam.wins - opposingTeam.losses));
			}
			else
			{
				return true;
						
			}
		}
		else
		{
			if (opposingTeam.hasRitual)
			{
				return false;
			}
			else
			{
				return ((this.wins - this.losses) > (opposingTeam.wins - opposingTeam.losses));
			}
		
		}	
	}	
			
}
