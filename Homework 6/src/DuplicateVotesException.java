/**
 * Exception for when the voter attempts to vote for a single candidate more than once
 * @author Ivan
 *
 */
public class DuplicateVotesException extends Exception{
	
	private String candidateWithDuplicateVotes;
	
	public DuplicateVotesException(String name) {
		this.candidateWithDuplicateVotes = name;
	}
	
	/**
	 * returns the candidate for which the voter tried to vote more than once
	 * @return candidateWithDuplicateVotes field
	 */
	public String getCandidateWithDuplicateVotes() {
		return this.candidateWithDuplicateVotes;
	}
}
