
public class RoboticsTeam implements IContestant
{
	String name;
	String school;
	String robotFeature;
	int previousScore; // zero if team has not competed before
	
	public RoboticsTeam (String school, String robotFeature, int previousScore) //constructor for robotics team
	{
		this.school = school;
		this.robotFeature = robotFeature;
		this.previousScore = previousScore;
	}
	
	public boolean expectToBeat (RoboticsTeam opposingTeam)  //returns true if the current robotics team is expected to beat the consumed robotics team
	{
		return (this.previousScore > opposingTeam.previousScore);
	}
}
