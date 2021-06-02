/**
 * Exception for the voter attempts to add a existing candidate to the ballot
 * @author Ivan
 *
 */
public class CandidateExistsException extends Exception {
	
	private String candidate;
	
	CandidateExistsException(String candidate) {
		this.candidate = candidate;
	}
	
	/**
	 * the candidate which the voter tried to add a duplicate 
	 * @return candidate field
	 */
	public String getCandidate() {
		return this.candidate;
	}
}
