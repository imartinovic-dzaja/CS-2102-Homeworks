import org.junit.Test;
import static org.junit.Assert.*;

//Homework Submitted by: Joshua Unger and Ivan Martinovic

public class Examples {



   //Testing RugbyResult.isValid()
   RugbyTeam rugTeamA = new RugbyTeam ( "USA", "Red", false, 10, 5);
   RugbyTeam rugTeamB = new RugbyTeam ( "USA", "Blue", true, 10, 5);
   RugbyTeam rugTeamC = new RugbyTeam ( "USA", "Green", false, 5, 5);
   RugbyTeam rugTeamD = new RugbyTeam ( "USA", "Yellow", true, 5, 5);
   RugbyTeam rugTeamE = new RugbyTeam ( "USA", "Yellow", true, 5, 5);

   RugbyResult rugbyBothLessThan150 = new RugbyResult (rugTeamA, rugTeamB, 100.0, 80.0);
   RugbyResult rugbyBothGreaterThan150 = new RugbyResult (rugTeamA, rugTeamB, 160.0, 155.0);
   RugbyResult rugbyFirstGreaterThan150 = new RugbyResult (rugTeamA, rugTeamB, 160.0, 80.0);
   RugbyResult rugbySecondGreaterThan150 = new RugbyResult (rugTeamA, rugTeamB, 100.0, 160.0);
   RugbyResult rugbyFirstBoundary150 = new RugbyResult (rugTeamA, rugTeamB, 150.0, 100.0);
   RugbyResult rugbySecondBoundary150 = new RugbyResult (rugTeamA, rugTeamB, 100.0, 150.0);
   RugbyResult rugbyBothBoundary150 = new RugbyResult (rugTeamA, rugTeamB, 150.0, 150.0);




   @Test
   public void testIsValidRugbyWhenBothLessThan150() {
       assertTrue(rugbyBothLessThan150.isValid());
   }

   @Test
   public void testIsValidRugbyWhenBothGreaterThan150() {
       assertFalse(rugbyBothGreaterThan150.isValid());
   }

   @Test
   public void testIsValidRugbyWhenFirstGreaterThan150() {
       assertFalse(rugbyFirstGreaterThan150.isValid());
   }

   @Test
   public void testIsValidRugbyWhenSecondGreaterThan150 () {
       assertFalse(rugbySecondGreaterThan150.isValid());
   }

   @Test
   public void testIsValidRugbyWhenFirstBoundary150 () {
       assertFalse(rugbyFirstBoundary150.isValid());
   }

   @Test
   public void testIsValidRugbyWhenSecondBoundary150 () {
       assertFalse(rugbySecondBoundary150.isValid());
   }

   @Test
   public void testIsValidRugbyWhenBothBoundary150 () {
       assertFalse(rugbyBothBoundary150.isValid());
   }



   //Testing RoboticsResult.isValid()


   RoboticsTeam robTeamA = new RoboticsTeam( "WPI", "Jumping", 0);
   RoboticsTeam robTeamB = new RoboticsTeam( "WPI", "Running", 5);
   RoboticsTeam robTeamC = new RoboticsTeam( "WPI", "Climbing", 5);
   RoboticsTeam robTeamD = new RoboticsTeam( "WPI", "Driving", 10);

   RoboticsResult roboticsEverythingInOrder = new RoboticsResult (robTeamA, robTeamB, 10.0 , 5 , false, 10.0 , 5 , false);
   RoboticsResult roboticsPointsGreaterThan16 = new RoboticsResult (robTeamA, robTeamB, 18.0 , 5 ,false, 10.0 , 5 , false);
   RoboticsResult roboticsPointsBoundary16 = new RoboticsResult (robTeamA, robTeamB, 10.0 , 5 , false, 16.0 , 5 , false);
   RoboticsResult roboticsTasksGreaterThan8 = new RoboticsResult (robTeamA, robTeamB, 10.0 , 10 , false, 10.0 , 5 , false);
   RoboticsResult roboticsTasksBoundary8 = new RoboticsResult (robTeamA, robTeamB, 10.0 , 5 , false, 10.0 , 8 , false);
   RoboticsResult roboticsPointsGreaterThan16andTasksGreaterThan8 = new RoboticsResult (robTeamA, robTeamB, 20.0 , 5 , false, 10.0 , 10 , false);
   RoboticsResult roboticsEverythingMessedUp = new RoboticsResult (robTeamA, robTeamB, 20.0 , 10 , false, 20.0 ,10 , false);

   @Test
   public void isValidRoboticsWhenEverythingInOrder() {
       assertTrue(roboticsEverythingInOrder.isValid());
   }

   @Test
   public void isValidRoboticsWhenPointsGreaterThan16() {
       assertFalse(roboticsPointsGreaterThan16.isValid());
   }


   @Test
   public void isValidRoboticsWhenPointsBoundary16() {
       assertTrue(roboticsPointsBoundary16.isValid());
   }

   @Test
   public void isValidRoboticsWhenTasksGreaterThan8()  {
       assertFalse(roboticsTasksGreaterThan8.isValid());
   }

   @Test
   public void isValidRoboticsWhenTasksBoundary8() {
       assertFalse(roboticsTasksBoundary8.isValid());
   }

   @Test
   public void isValidRoboticsWhenPointsGreaterThan16andTasksGreaterThan8() {
       assertFalse(roboticsPointsGreaterThan16andTasksGreaterThan8.isValid());
   }

   @Test
   public void isValidRoboticsWhenEverythingMessedUp()  {
       assertFalse(roboticsEverythingMessedUp.isValid());
   }


   // Testing RoboticsResult.getScore()

   @Test
   public void getScoreFellDownAndBothZero() {
       assertEquals (roboticsEverythingMessedUp.getScore(0.0, 0, true), -5.0, 0.01);
   }

   @Test
   public void getScoreFellDownAndFirstZero() {
       assertEquals (roboticsEverythingMessedUp.getScore(0.0, 5, true), 0, 0.01);
   }

   @Test
   public void getScoreFellDownAndSecondZero() {
       assertEquals (roboticsEverythingMessedUp.getScore(5.0, 0, true), 0.0, 0.01);
   }

   @Test
   public void getScoreFellDownAndNoneZero() {
       assertEquals (roboticsEverythingMessedUp.getScore(5.0, 5, true), 5.0, 0.01);
   }

   @Test
   public void getScoreDidNotFallDownAndBothZero() {
       assertEquals (roboticsEverythingMessedUp.getScore(0.0, 0, false), 0.0, 0.01);
   }

   @Test
   public void getScoreDidNotFallDownAndFirstZero() {
       assertEquals (roboticsEverythingMessedUp.getScore(0.0, 5, false), 5.0, 0.01);
   }

   @Test
   public void getScoreDidNotFallDownAndSecondZero() {
       assertEquals (roboticsEverythingMessedUp.getScore(5.0, 0, false), 5.0, 0.01);
   }

   @Test
   public void getScoreDidNotFallDownAndNoneZero() {
       assertEquals (roboticsEverythingMessedUp.getScore(5.0, 5, false), 10.0, 0.01);
   }

   // testing RugbyResult.getWinner();

   RugbyResult rugbyFirstWins = new RugbyResult (rugTeamA, rugTeamB, 100.0, 80.0);
   RugbyResult rugbySecondtWins = new RugbyResult (rugTeamA, rugTeamB, 80.0, 100.0);

   @Test
   public void getWinnerRugbyFirstWins() {
       assertEquals (rugbyFirstWins.getWinner(), rugTeamA);
   }

   @Test
   public void getWinnerRugbySecondWins() {
       assertEquals (rugbySecondtWins.getWinner(), rugTeamB);
   }

   // Testing RoboticsResult.getWinner()
   RoboticsResult roboticsNoneFallFirstHasMorePoints = new RoboticsResult (robTeamA, robTeamB, 10.0 , 5 , false, 5.0 , 5 , false);
   RoboticsResult roboticsNoneFallSecondHasMorePoints = new RoboticsResult (robTeamA, robTeamB, 5.0 , 5 , false, 10.0 , 5 , false);
   RoboticsResult roboticsNoneFallFirstHasMoreTasks = new RoboticsResult (robTeamA, robTeamB, 10.0 , 7 , false, 10.0 , 5 , false);
   RoboticsResult roboticsNoneFallSecondHasMoreTasks = new RoboticsResult (robTeamA, robTeamB, 10.0 , 5 , false, 10.0 , 7 ,  false);
   RoboticsResult roboticsFirstFallsBothHaveSamePointsAndTasks = new RoboticsResult (robTeamA, robTeamB, 10.0 , 5 ,  true, 10.0 , 5 , false);
   RoboticsResult roboticsSecondFallsBothHaveSamePointsAndTasks = new RoboticsResult (robTeamA, robTeamB, 10.0 , 5 , false, 10.0 , 5 , true);

   @Test
   public void getWinnerRoboticsWhenNoneFallFirstHasMorePoints() {
       assertEquals(roboticsNoneFallFirstHasMorePoints.getWinner(), robTeamA);
   }

   @Test
   public void getWinnerRoboticsWhenNoneFallSecondHasMorePoints() {
       assertEquals(roboticsNoneFallSecondHasMorePoints.getWinner(), robTeamB);
   }

   @Test
   public void getWinnerRoboticsWhenNoneFallFirstHasMoreTasks() {
       assertEquals(roboticsNoneFallFirstHasMoreTasks.getWinner(), robTeamA);
   }

   @Test
   public void getWinnerRoboticsWhenNoneFallSecondHasMoreTasks() {
       assertEquals(roboticsNoneFallSecondHasMoreTasks.getWinner(), robTeamB);
   }

   @Test
   public void getWinnerRoboticsWhenFirstFallsBothHaveSamePointsAndTasks() {
       assertEquals(roboticsFirstFallsBothHaveSamePointsAndTasks.getWinner(), robTeamB);
   }

   @Test
   public void getWinnerRoboticsWhenSecondFallsBothHaveSamePointsAndTasks() {
       assertEquals(roboticsSecondFallsBothHaveSamePointsAndTasks.getWinner(), robTeamA);
   }

   // Testing winner

   RugbyResult rugbyTeamAWins = new RugbyResult (rugTeamA, rugTeamB, 100.0, 80.0);
   RugbyResult rugbyTeamBWins = new RugbyResult (rugTeamA, rugTeamB, 80.0, 100.0);
   RoboticsResult roboticsTeamAWins = new RoboticsResult (robTeamA, robTeamB, 10.0 , 5 , false, 5.0 , 5 , false);
   RoboticsResult roboticsTeamBWins = new RoboticsResult (robTeamA, robTeamB, 5.0 , 5 , false, 10.0 , 5 , false);

   Match winnerRoboticsWhenNotValid = new Match(robTeamA,robTeamB,roboticsEverythingMessedUp);
   Match winnerRoboticsWhenValidTeamA = new Match(robTeamA, robTeamB,roboticsTeamAWins);
   Match winnerRoboticsWhenValidTeamB = new Match(robTeamA, robTeamB,roboticsTeamBWins);
   Match winnerRugbyWhenNotValid = new Match(rugTeamA,rugTeamB,rugbyBothGreaterThan150);
   Match winnerRugbyWhenValidTeamA = new Match(rugTeamA,rugTeamB,rugbyTeamAWins);
   Match winnerRugbyWhenValidTeamB = new Match(rugTeamA,rugTeamB,rugbyTeamBWins);

   @Test
   public void winnerRoboticsWhenNotValid(){
       assertEquals(winnerRoboticsWhenNotValid.winner(), null);

   }
   @Test
   public void winnerRoboticsWhenValidTeamA(){
       assertEquals(winnerRoboticsWhenValidTeamA.winner(), robTeamA);
   }
   @Test
   public void winnerRoboticsWhenValidTeamB(){
       assertEquals(winnerRoboticsWhenValidTeamB.winner(), robTeamB);
   }
   @Test
   public void winnerRugbyWhenNotValid(){
       assertEquals(winnerRugbyWhenNotValid.winner(), null);

   }
   @Test
   public void winnerRugbyWhenValidTeamA(){
       assertEquals(winnerRugbyWhenValidTeamA.winner(),rugTeamA);
   }
   @Test
   public void winnerRugbyWhenValidTeamB(){
       assertEquals(winnerRugbyWhenValidTeamB.winner(),rugTeamB);
   }

   // Testing RugbyTeam expectToBeat

   @Test
   public void expectToBeatRugbyFirstTeamHasIntimidationSecondDoesNot(){
       assertEquals(rugTeamB.expectToBeat(rugTeamA),true);
   }

   @Test
   public void expectToBeatRugbySecondTeamHasIntimidationFirstDoesNot(){
       assertEquals(rugTeamA.expectToBeat(rugTeamB),false);
   }

   @Test
   public void expectToBeatRugbyBothHaveIntimidationFirstHasMorePoints(){
       assertEquals(rugTeamB.expectToBeat(rugTeamD),true);
   }

   @Test
   public void expectToBeatRugbyBothHaveIntimidationSecondHasMorePoints(){
       assertEquals(rugTeamD.expectToBeat(rugTeamB),false);
   }

   @Test
   public void expectToBeatRugbyBothDontHaveIntimidationFirstHasMorePoints(){
       assertEquals(rugTeamA.expectToBeat(rugTeamC),true);
   }

   @Test
   public void expectToBeatRugbyBothDontHaveIntimidationSecondHasMorePoints(){
       assertEquals(rugTeamC.expectToBeat(rugTeamA),false);
   }

   @Test
   public void expectToBeatRugbyNoClearWinner(){
       assertEquals(rugTeamE.expectToBeat(rugTeamD),false);
   }

   // Testing RoboticsTeam expectToBeat

   @Test
   public void expectToBeatRoboticsFirstHasHigherPreviousScore(){
       assertEquals(robTeamD.expectToBeat(robTeamA),true);
   }

   @Test
   public void expectToBeatRoboticsSecondHasHigherPreviousScore(){
       assertEquals(robTeamA.expectToBeat(robTeamD),false);
   }

   @Test
   public void expectToBeatRoboticsNoClearWinner(){
       assertEquals(robTeamB.expectToBeat(robTeamC),false);
   }
}


