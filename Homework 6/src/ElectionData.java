import java.util.LinkedList;
import java.util.Scanner;
import java.util.HashMap;

/**
 * Stores data of a election
 * @author Ivan
 *
 */
class ElectionData {
  private LinkedList<String> ballot = new LinkedList<String>();
  private HashMap<String, Integer> firstVotes = new HashMap<>();
  private HashMap<String, Integer> secondVotes = new HashMap<>();
  private HashMap<String, Integer> thirdVotes = new HashMap<>();

  
  ElectionData() {  
  }

  /**
   * Prints the ballot of the election
   */
  public void printBallot() {
	    System.out.println("The candidates are ");
	    for (String s : this.ballot) {
	      System.out.println(s);
	    }
}
  
   /**
    * processes a vote which consists of the voter's first, second and third choice
    * @param first is the voter's first choice
    * @param second is the voter's second choice
    * @param third is the voter's third choice
    * @throws DuplicateVotesException in case a voter tries to vote for the same candidate more than once
    * @throws UnknownCandidateException in case a voter tries to vote for a non-existant candidate
    */
  public void processVote(String first, String second, String third) throws DuplicateVotesException, UnknownCandidateException {
	
	 if (!ballot.contains(first))
		 throw new UnknownCandidateException(first);
	 if (!ballot.contains(second))
		 throw new UnknownCandidateException(second);
	 if (!ballot.contains(third))
		 throw new UnknownCandidateException(third);
	 
	 if (first.equals(second))
		 throw new DuplicateVotesException(first);
	 if (first.equals(third))
		 throw new DuplicateVotesException(first);
	 if (third.equals(second))
		 throw new DuplicateVotesException(third);
	 
	 firstVotes.put(first, firstVotes.get(first) + 1);
	 secondVotes.put(second, secondVotes.get(first) + 1);
	 thirdVotes.put(third, thirdVotes.get(first) + 1); 
	 
     System.out.println("You've succesfully casted your vote!");

  }
  
  
  /**
   * Adds a candidate to the ballot
   * @param name is the name of the candidate to be added
   * @throws CandidateExistsException if the user attempts to add an already existing candidate
   */
  public void addCandidate(String name) throws CandidateExistsException{
	  if (ballot.contains(name))
		  throw new CandidateExistsException(name);
	  else
	  { 
		  ballot.add(name);
		  firstVotes.put(name, 0);
		  secondVotes.put(name, 0);
		  thirdVotes.put(name, 0); 
  	   }
}
  
  /**
   * Returns the candidate with over 50% of first votes
   * @return the candidate with over 50% of first votes or if such a candidate does not exist, returns "Runnof required"
   */
  	public String findWinnerMostFirstVotes()
  	{
  		int totalVotes = 0;
  		for (String candidate : ballot) {
  			totalVotes += firstVotes.get(candidate);
  		}
  		for (String candidate : ballot) {
  			if ((double)firstVotes.get(candidate) > (double)totalVotes / 2)
  				return candidate;
  		}
  		return "Runoff required";
  	}
  	
  	/**
  	 * Returns the candidate with most points where a candidate earns 3, 2 or 1 points for each time he is a first, second or third choice respectively
  	 * @return the candidate with most points
  	 */
  	public String findWinnerMostPoints() {
  		
  		int mostPoints = 0;
  		String leader = "";
  		for(String candidate : ballot) {
  			int numOfPoints = 3 * firstVotes.get(candidate) + 2 * secondVotes.get(candidate) + thirdVotes.get(candidate);
  			if (numOfPoints > mostPoints)
  			{
  				leader = candidate;
  				mostPoints = numOfPoints;	
  			}
   		}
  		return leader;
  	}
  		
  		
  	}  	



