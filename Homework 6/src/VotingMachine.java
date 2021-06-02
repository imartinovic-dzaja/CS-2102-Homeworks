import java.util.Scanner;

/**
 * Represents an interface through which a voter may cast a vote or add a candidate
 * @author Ivan
 *
 */
public class VotingMachine {

	  private Scanner keyboard = new Scanner(System.in);
	  private ElectionData electionData = new ElectionData();
	  
	  
	 /**
	  * The main interface method which handles user inputs 
	  */
	 public void screen() {
	        this.electionData.printBallot();
	        System.out.println("Enter your first Election Choice");
	        String firstChoice = keyboard.nextLine();
	        System.out.println("Enter your second Election Choice");
	        String secondChoice = keyboard.nextLine();
	        System.out.println("Enter your third Election Choice");
	        String thirdChoice = keyboard.nextLine();
	        
	        try {
	        	electionData.processVote(firstChoice, secondChoice, thirdChoice);
	        }
	        catch (UnknownCandidateException e) {
	        	System.out.println("The following candidate does not exist in the ballout: "+ e.getUnknownCandidate());
	        	System.out.println("Would you like to add the candidate to the ballout: Y  or y for yes, anything else for no");
	        	String choice = keyboard.nextLine();
	        	if (choice.equals("y") || choice.equals("Y"))
	        		{
	        		addWriteIn(e.getUnknownCandidate());
	        		screen();
	        		}
	        	else {
	        	screen();}
	        }
	        catch (DuplicateVotesException e) {
	        	System.out.println("Voting for the same candidate more than once is not allowed");
	        	System.out.println("You have voted for " + e.getCandidateWithDuplicateVotes() + " more than once");
	        	screen();
	        	
	        }
	   }
	   
	   
	 /**
	  * Adds a candidate to the ballot
	  * @param candidate to be added
	  */
	   public void addWriteIn(String candidate) {
		   try {
			   electionData.addCandidate(candidate);
		   }
		   catch (CandidateExistsException e) {
			   System.out.println("The candidate already exists");
		   }
		   System.out.println("Candidate added succesfully");
	   }
	   
}
