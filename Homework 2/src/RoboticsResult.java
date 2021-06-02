
public class RoboticsResult implements IResult{
	
	RoboticsTeam contestantA;
	RoboticsTeam contestantB;
	double teamApoints;
	double teamBpoints;
	int teamAtasks;
	int teamBtasks;
	boolean teamAFell;
	boolean teamBFell;
	
	public RoboticsResult(RoboticsTeam contestantA, RoboticsTeam contestantB, 			//constructor for RoboticsResult
							double teamApoints, int teamAtasks, boolean teamAFell, 
							double teamBpoints, int teamBtasks, boolean teamBFell)
	{
		this.contestantA = contestantA;
		this.contestantB = contestantB;
		this.teamApoints = teamApoints;
		this.teamBpoints = teamBpoints;
		this.teamAtasks = teamAtasks;
		this.teamBtasks = teamBtasks;
		this.teamAFell = teamAFell;
		this.teamBFell = teamBFell;
	}
	
	public boolean isValid() {      //returns true if a RoboticsResult is valid (both teams have less than 8 tasks and less or equal to 16 points)
		return ((this.teamAtasks < 8) && (this.teamBtasks < 8) && (this.teamApoints <= 16) && (this.teamBpoints <= 16));
	}
	
	public double getScore(double numPoints, int numTasks, boolean hasFallen) {   //consumes a number of points, number of tasks and a boolean indicating whether a robot has fallen down
				{																//and based on this returns the total score for the robot
					if (hasFallen)
					{
						return (numPoints + (double)numTasks - 5.0);
						
					}	
					else
					{
						return (numPoints + (double)numTasks);	
				
					}
				}
	
	}
	
	public RoboticsTeam getWinner() //returns the winner based on the robotics result
	{
		if (getScore(this.teamApoints, this.teamAtasks, this.teamAFell) > 
		getScore(this.teamBpoints, this.teamBtasks, this.teamBFell))
		{
			return (this.contestantA);
		}
		else
		{
			return (this.contestantB);
		}
	}
	
}	
