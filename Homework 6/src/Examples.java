import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import  org.junit.Assert;
import org.junit.Test;

// Homework completed by: Ivan Martinovic

public class Examples {
	
	/* Assumptions:
	 *  1) Assume no candidate is an empty string
	 *  2) Assume null will not be given as a name
	 *  3) The UnknownCandidateException is thrown before the DuplicateVotesException if both apply; 
	 *  4) At least one valid vote has been processed
	 */ 
    VotingMachine VM = new VotingMachine();

	
	ElectionData Setup1 () {

	    ElectionData ED = new ElectionData();
	    
	  
	    // put candidates on the ballot
	    try {

	       ED.addCandidate("gompei");
	       ED.addCandidate("husky");
	       ED.addCandidate("ziggy");

	    } catch (Exception e) {}

	    // cast votes

	    try {

	      ED.processVote("gompei", "husky", "ziggy");
	      ED.processVote("gompei", "ziggy", "husky");
	      ED.processVote("husky", "gompei", "ziggy");

	    } catch (Exception e) {}

	    return(ED);

	  }
	  @Test
	  public void testMostFirstWinnerWhenThereIsAClearWinner () {
	    assertEquals("gompei", Setup1().findWinnerMostFirstVotes());
	  }
	  
	  ElectionData Setup2 () {

		    ElectionData ED = new ElectionData();
		  
		    // put candidates on the ballot
		    try {

		       ED.addCandidate("gompei");
		       ED.addCandidate("husky");
		       ED.addCandidate("ziggy");

		    } catch (Exception e) {}

		    // cast votes

		    try {

		      ED.processVote("gompei", "husky", "ziggy");
		      ED.processVote("gompei", "ziggy", "husky");
		      ED.processVote("husky", "gompei", "ziggy");
		      ED.processVote("ziggy", "gompei", "husky");

		    } catch (Exception e) {}

		    return(ED);

		  }
	  @Test
	  public void testMostFirstWinnerWhenThePersonWithMostVotesHasExactly50 () {
	    assertEquals("Runoff required", Setup2().findWinnerMostFirstVotes());
	  }
	  
	  ElectionData Setup3 () {

		    ElectionData ED = new ElectionData();
		  
		    // put candidates on the ballot
		    try {

		       ED.addCandidate("gompei");
		       ED.addCandidate("husky");
		       ED.addCandidate("ziggy");

		    } catch (Exception e) {}

		    // cast votes

		    try {

		      ED.processVote("gompei", "husky", "ziggy");
		      ED.processVote("ziggy", "gompei", "husky");
		      ED.processVote("husky", "gompei", "ziggy");

		    } catch (Exception e) {}

		    return(ED);

		  }
	  @Test
	  public void testMostFirstWinnerWhenEverybodyHasLessThan50() {
	    assertEquals("Runoff required", Setup3().findWinnerMostFirstVotes());
	  }
	  
	  
	  ElectionData Setup4 () {

		    ElectionData ED = new ElectionData();
		  
		    // put candidates on the ballot
		    try {

		       ED.addCandidate("gompei");
		       ED.addCandidate("husky");
		       ED.addCandidate("ziggy");

		    } catch (Exception e) {}

		    // cast votes

		    try {

		      ED.processVote("gompei", "husky", "ziggy");
		      ED.processVote("gompei", "husky", "ziggy");
		      ED.processVote("gompei", "husky", "ziggy");

		    } catch (Exception e) {}

		    return(ED);

		  }
	  @Test
	  public void testfindWinnerMostPointsWhenThereIsAClearWinner() {
	    assertEquals("gompei", Setup4().findWinnerMostPoints());
	  }
	  
	  ElectionData Setup5() {

		    ElectionData ED = new ElectionData();
		  
		    // put candidates on the ballot
		    try {

		       ED.addCandidate("gompei");
		       ED.addCandidate("husky");
		       ED.addCandidate("ziggy");
		       ED.addCandidate("random1");
		       ED.addCandidate("random2");
		       ED.addCandidate("random3");
		       ED.addCandidate("random4");
		       ED.addCandidate("random5");


		    } catch (Exception e) {}

		    // cast votes

		    try {

		      ED.processVote("gompei", "husky", "ziggy");
		      ED.processVote("ziggy", "gompei", "husky");
		      ED.processVote("husky", "ziggy", "gompei");

		    } catch (Exception e) {}

		    return(ED);

		  }
	  
	  @Test
	  public void testfindWinnerMostPointsWhenThereIsATieBetweenThreePeople() {
	    assertTrue((Setup5().findWinnerMostPoints().equals("gompei") || Setup4().findWinnerMostPoints().equals("husky") || Setup4().findWinnerMostPoints().equals("ziggy")));
	  }
	  
	  
	  ElectionData Setup6() throws CandidateExistsException {

		    ElectionData ED = new ElectionData();
		  
		    // put candidates on the ballot
		    try {

		       ED.addCandidate("gompei");
		       ED.addCandidate("husky");
		       ED.addCandidate("ziggy");
		       ED.addCandidate("gompei");


		    } catch (CandidateExistsException e) {
		    	throw e;
		    }

		    return ED;

		  }
	  
	  @Test(expected=CandidateExistsException.class)
	  public void testCandidateExistsExceptionBeingThrown() throws CandidateExistsException
	  {
	  	this.Setup6();
	  }
	  
	  ElectionData Setup7() throws DuplicateVotesException, UnknownCandidateException {

		    ElectionData ED = new ElectionData();
		  
		    // put candidates on the ballot
		    try {

		       ED.addCandidate("gompei");
		       ED.addCandidate("husky");
		       ED.addCandidate("ziggy");

		    } catch (Exception e) {}

		    // cast votes

		    try {

		      ED.processVote("gompei", "gompei", "ziggy");

		    } catch (DuplicateVotesException e) {
		    	throw e;
		    }
		    catch (UnknownCandidateException e) {
		    	throw e;
		    }

		    return ED;

		  }
	  
	  @Test(expected=DuplicateVotesException.class)
	  public void testDuplicateVotesExceptionBeingThrown() throws DuplicateVotesException, UnknownCandidateException{
	    this.Setup7();
	  }
	  
	  ElectionData Setup8() throws DuplicateVotesException, UnknownCandidateException{

		    ElectionData ED = new ElectionData();
		  
		    // put candidates on the ballot
		    try {

		       ED.addCandidate("gompei");
		       ED.addCandidate("husky");
		       ED.addCandidate("ziggy");

		    } catch (Exception e) {}

		    // cast votes

		    try {

		      ED.processVote("random", "gompei", "ziggy");

		    }  
		    catch (DuplicateVotesException e) {
		    	throw e;
		    }
		    catch (UnknownCandidateException e) {
		    	throw e;
		    }

		    return ED;

		  }
	  
	  @Test(expected=UnknownCandidateException.class)
	  public void testUnknownCandidateExceptionBeingThrown()throws DuplicateVotesException, UnknownCandidateException{
		    this.Setup8();
		  }
	  
	  
	  String Setup9() throws DuplicateVotesException, UnknownCandidateException
{

		    ElectionData ED = new ElectionData();
		  
		    // put candidates on the ballot
		    try {

		       ED.addCandidate("gompei");
		       ED.addCandidate("husky");
		       ED.addCandidate("ziggy");

		    } catch (Exception e) {}

		    // cast votes

		    try {

		      ED.processVote("random", "ziggy", "ziggy");

		    }  
			    catch (DuplicateVotesException e) {
			    	throw e;
			    }
			    catch (UnknownCandidateException e) {
			    	throw e;
			    }
		    

		    return("Successful");

		  }
	  
	  @Test(expected=UnknownCandidateException.class)
	  public void testUnknownCandidateExceptionAndDuplicateVotesExceptionsBothSupposedToBeThrown() throws DuplicateVotesException, UnknownCandidateException{
	    this.Setup9();	  }
	  
	  String Setup10() {

		    ElectionData ED = new ElectionData();
		  
		    // put candidates on the ballot
		    try {

		       ED.addCandidate("gompei");
		       ED.addCandidate("husky");
		       ED.addCandidate("ziggy");

		    } catch (Exception e) {}

		    // cast votes

		    try {

		      ED.processVote("random1", "random2", "ziggy");

		    } catch (Exception e) {
		    	if (e instanceof UnknownCandidateException) {
		    		UnknownCandidateException eU = (UnknownCandidateException)e;
		    		return eU.getUnknownCandidate() + " is not in the ballot";
		    	}
		    }

		    return("Successful");

		  }
	  
	  @Test //test whether the first candidate encountered is being returned
	  public void testUnknownCandidateExceptionBeingThrownAndTwoUnknownCandidates() {
	    assertEquals(this.Setup10(), "random1 is not in the ballot");
	  }
	  
}
