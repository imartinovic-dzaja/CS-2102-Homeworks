import java.util.LinkedList;

public class AdvancedRound extends AbsRound {
   LinkedList<Match> matches;
   LinkedList<IContestant> contestants;

   //constructor
   public AdvancedRound(LinkedList<Match> matches, LinkedList<IContestant> contestants) {
       super(matches);
       this.contestants = contestants;
   }
   
   /**
    * goes through all the contestants in the list of contestants advancing from the previous rounds
    * and finds if the consumed contestant is among the list of contestants
    * @param inputContestant is the contestant for which we are checking whether he/she/they are among the list of contestants
    * @return isTheWinner is true if the inputContestant is among the list of contestants
    */
   public boolean isWinner(IContestant inputContestant) {
	   boolean isTheWinner = false;
	   for (IContestant contestant : contestants)
	   {
		   if (inputContestant.equals(contestant))
		   {
			   isTheWinner = true;
			   break;
		   }
	   }
	   
	   return isTheWinner;
 
}
 }