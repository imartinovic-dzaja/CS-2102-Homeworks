/**
 * Exception for when the voter attempts to vote for a candidate which does not exist in the ballot
 * @author Ivan
 *
 */
public class UnknownCandidateException extends Exception{
	private String unknownCandidate;
	
	public UnknownCandidateException(String name) {
		this.unknownCandidate = name;
	}
	
	/**
	 * returns the non-existent candidate
	 * @return unknownCandidate field
	 */
	public String getUnknownCandidate() {
		return this.unknownCandidate;
	}
}
