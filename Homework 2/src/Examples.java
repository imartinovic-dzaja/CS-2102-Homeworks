import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;

// Homework submitted by Joshua Unger and Ivan Martinovic

public class Examples {

   RugbyTeam rugTeamA = new RugbyTeam ("USA", "Red", false, 10, 5);
   RugbyTeam rugTeamB = new RugbyTeam ("USA", "Blue", true, 10, 5);
   RugbyTeam rugTeamC = new RugbyTeam ("USA", "Green", false, 5, 5);
   RugbyTeam rugTeamD = new RugbyTeam ("USA", "Yellow", true, 5, 5);
   RugbyTeam rugTeamE = new RugbyTeam ("USA", "Orange", true, 5,5);

   RugbyResult rugbyBothLessThan150 = new RugbyResult (rugTeamA, rugTeamB, 100.0, 80.0);
   RugbyResult rugbyBothGreaterThan150 = new RugbyResult (rugTeamA, rugTeamB, 160.0, 155.0);
   RugbyResult rugbyFirstGreaterThan150 = new RugbyResult (rugTeamA, rugTeamB, 160.0, 80.0);
   RugbyResult rugbySecondGreaterThan150 = new RugbyResult (rugTeamA, rugTeamB, 100.0, 160.0);
   RugbyResult rugbyFirstBoundary150 = new RugbyResult (rugTeamA, rugTeamB, 150.0, 100.0);
   RugbyResult rugbySecondBoundary150 = new RugbyResult (rugTeamA, rugTeamB, 100.0, 150.0);
   RugbyResult rugbyBothBoundary150 = new RugbyResult (rugTeamA, rugTeamB, 150.0, 150.0);

   RoboticsTeam robTeamA = new RoboticsTeam("WPI", "Jumping", 0);
   RoboticsTeam robTeamB = new RoboticsTeam("WPI", "Running", 5);
   RoboticsTeam robTeamC = new RoboticsTeam("WPI", "Climbing", 5);
   RoboticsTeam robTeamD = new RoboticsTeam("WPI", "Driving", 10);

   RoboticsResult roboticsEverythingInOrder = new RoboticsResult (robTeamA, robTeamB, 10.0 , 5 , false, 10.0 , 5 , false);
   RoboticsResult roboticsPointsGreaterThan16 = new RoboticsResult (robTeamA, robTeamB, 18.0 , 5 ,false, 10.0 , 5 , false);
   RoboticsResult roboticsPointsBoundary16 = new RoboticsResult (robTeamA, robTeamB, 10.0 , 5 , false, 16.0 , 5 , false);
   RoboticsResult roboticsTasksGreaterThan8 = new RoboticsResult (robTeamA, robTeamB, 10.0 , 10 , false, 10.0 , 5 , false);
   RoboticsResult roboticsTasksBoundary8 = new RoboticsResult (robTeamA, robTeamB, 10.0 , 5 , false, 10.0 , 8 , false);
   RoboticsResult roboticsPointsGreaterThan16andTasksGreaterThan8 = new RoboticsResult (robTeamA, robTeamB, 20.0 , 5 , false, 10.0 , 10 , false);
   RoboticsResult roboticsEverythingMessedUp = new RoboticsResult (robTeamA, robTeamB, 20.0 , 10 , false, 20.0 ,10 , false);

   RugbyResult rugbyTeamAWins = new RugbyResult (rugTeamA, rugTeamB, 100.0, 80.0);
   RugbyResult rugbyTeamBWins = new RugbyResult (rugTeamA, rugTeamB, 80.0, 100.0);
   RoboticsResult roboticsTeamAWins = new RoboticsResult (robTeamA, robTeamB, 10.0 , 5 , false, 5.0 , 5 , false);
   RoboticsResult roboticsTeamBWins = new RoboticsResult (robTeamA, robTeamB, 5.0 , 5 , false, 10.0 , 5 , false);
   RoboticsResult roboticsTeamCWins = new RoboticsResult (robTeamC, robTeamD, 5.0 , 5 , false, 10.0 , 5 , false);
   RoboticsResult roboticsTeamAWinsVSC = new RoboticsResult (robTeamA, robTeamC, 10.0 , 5 , false, 5.0 , 5 , false);


   Match winnerRoboticsWhenNotValid = new Match(robTeamA,robTeamB,roboticsEverythingMessedUp);
   Match winnerRoboticsWhenValidTeamA = new Match(robTeamA, robTeamB,roboticsTeamAWins);
   Match winnerRoboticsWhenValidTeamB = new Match(robTeamA, robTeamB,roboticsTeamBWins);
   Match winnerRugbyWhenNotValid = new Match(rugTeamA,rugTeamB,rugbyBothGreaterThan150);
   Match winnerRugbyWhenValidTeamA = new Match(rugTeamA,rugTeamB,rugbyTeamAWins);
   Match winnerRugbyWhenValidTeamB = new Match(rugTeamA,rugTeamB,rugbyTeamBWins);
   Match winnerRoboticsTeamAVBA = new Match(robTeamA, robTeamB,roboticsTeamAWins);
   Match winnerRoboticsTeamCVDC = new Match(robTeamC, robTeamD,roboticsTeamCWins);
   Match winnerRoboticsTeamAVCA = new Match(robTeamA, robTeamC,roboticsTeamAWinsVSC);


   LinkedList<Match> emptyListOfMatches = new LinkedList<Match>();
   LinkedList<Match> listOfMatches = new LinkedList<Match>();
   LinkedList<Match> listOfMatchesVersionTwo = new LinkedList<Match>();
   LinkedList<Match> listOfMatchesVersionThree = new LinkedList<Match>();
   LinkedList<Match> ListOfMatchesWithInvalid = new LinkedList<Match>();

   LinkedList<IContestant> listOfExpected = new LinkedList<IContestant>();
   LinkedList<IContestant> emptyListOfContestants = new LinkedList<IContestant>();
   LinkedList<IContestant> Tournament1 = new LinkedList<IContestant>();

   LinkedList<IWinner> TournamentRounds1 = new LinkedList<IWinner>();
   LinkedList<IWinner> TournamentRounds2 = new LinkedList<IWinner>();
   LinkedList<IWinner> TournamentRounds3 = new LinkedList<IWinner>();


   public Examples() {
       listOfMatches.add(winnerRoboticsWhenValidTeamA);
       listOfMatches.add(winnerRoboticsWhenValidTeamB);
       listOfMatches.add(winnerRugbyWhenValidTeamA);
       listOfMatches.add(winnerRugbyWhenValidTeamB);

       listOfMatchesVersionTwo.add(winnerRoboticsTeamAVBA);
       listOfMatchesVersionTwo.add(winnerRoboticsTeamCVDC);

       listOfMatchesVersionThree.add(winnerRoboticsTeamAVCA);

       listOfExpected.add(robTeamA);
       listOfExpected.add(robTeamB);
       listOfExpected.add(rugTeamA);
       listOfExpected.add(rugTeamB);

       ListOfMatchesWithInvalid.add(winnerRoboticsWhenNotValid);
       ListOfMatchesWithInvalid.add(winnerRoboticsWhenValidTeamA);
       ListOfMatchesWithInvalid.add(winnerRoboticsWhenValidTeamB);
       ListOfMatchesWithInvalid.add(winnerRugbyWhenValidTeamA);
       ListOfMatchesWithInvalid.add(winnerRugbyWhenValidTeamB);

       Tournament1.add(robTeamA);
       Tournament1.add(robTeamC);

       TournamentRounds1.add(InitRoundForTournament);
       TournamentRounds1.add(AdvancedRound1ForTournament);

       TournamentRounds2.add(InitRoundEmpty);
       TournamentRounds2.add(AdvancedRoundEmpty);

       TournamentRounds3.add(InitRoundForTournament);
       TournamentRounds3.add(AdvancedRoundEmpty);

   }

   InitRound MatchesNonEmpty = new InitRound(listOfMatches);
   InitRound MatchesEmpty = new InitRound(emptyListOfMatches);
   InitRound MatchesWithInvalid = new InitRound(ListOfMatchesWithInvalid);

   // Due to the getMatchWinners method not being overridden in either the InitRound class or the AdvancedRound class,
   // we do not need to check an example with a AdvancedRound and an InitRound, we are able to just choose one

   //Tests for getMatchWinner()

   @Test
   public void getMatchWinnersCheckWhenWeExpectAList() {
       assertEquals(MatchesNonEmpty.getMatchWinners(), listOfExpected); 
   }

   @Test
   public void getMatchWinnersCheckEdgeCaseWhenWeExpectAEmptyList(){
       assertEquals(MatchesEmpty.getMatchWinners(), emptyListOfContestants);
   }

   @Test
   public void getMatchWinnersCheckEdgeWhereWeHaveAnInvalidMatch(){
       assertEquals(MatchesWithInvalid.getMatchWinners(), listOfExpected);
   }

   // Tests for getNumWinner()

   @Test
   public void getNumWinnersCheckWhereWeExpectAValidResultOfANumber(){
       assertEquals(MatchesNonEmpty.getNumWinners(), 4);
   }

   @Test
   public void getNumWinnersCheckWhereWeExpectAValidResultOfANumberButHasAInvalidMatchWithinIt(){
       assertEquals(MatchesWithInvalid.getNumWinners(), 4);
   }

   @Test
   public void getNumWinnersWhereWeExpectItToReturnZeroAsTheListOfWinnersIsEmpty(){
       assertEquals(MatchesEmpty.getNumWinners(),0);
   }

   // Tests for isWinner AdvancedRound Class

   AdvancedRound AdvancedRoundGood = new AdvancedRound(listOfMatches,listOfExpected);
   AdvancedRound AdvancedRoundBad = new AdvancedRound(emptyListOfMatches,emptyListOfContestants);

   @Test
   public void isWinnerAdvancedRoundWhereContestantShouldMoveOn(){
       assertTrue(AdvancedRoundGood.isWinner(robTeamA));
   }

   @Test
   public void isWinnerAdvancedRoundWhereContestantShouldNotMoveOn(){
       assertFalse(AdvancedRoundGood.isWinner(rugTeamE));
   }

   @Test
   public void isWinnerAdvancedRoundWhereNoContestantsInRound(){
       assertFalse(AdvancedRoundBad.isWinner(rugTeamA));
   }
   
   @Test
   public void isWinnerAdvancedRoundWhereNoContestantsInRoundAndInputIsNull() {
       assertFalse(AdvancedRoundBad.isWinner(null));

   }
   // Tests for isWinner InitRound Class

   @Test
   public void isWinnerInitRoundWhereContestantShouldMoveOn(){
       assertTrue(MatchesNonEmpty.isWinner(robTeamA));
   }

   @Test
   public void isWinnerInitRoundWhereContestantShouldNotMoveOn(){
       assertFalse(MatchesNonEmpty.isWinner(robTeamC));
   }

   @Test
   public void isWinnerInitRoundWhereContestantDidNotPlayInAMatch(){
       assertFalse(MatchesNonEmpty.isWinner(rugTeamE));
   }

   @Test
   public void IsWinnerInitRoundWhereNoMatchesWherePlayed(){
       assertFalse(MatchesEmpty.isWinner(robTeamA));
   }
   
   @Test
   public void IsWinnerInitRoundWhereNoMatchesWherePlayedAndInputIsNull(){
       assertFalse(MatchesEmpty.isWinner(null));
   }

   // Tests for finalWinnerIsValid()

   InitRound InitRoundForTournament = new InitRound(listOfMatchesVersionTwo);
   AdvancedRound AdvancedRound1ForTournament = new AdvancedRound(listOfMatchesVersionThree,Tournament1);
   Tournament ValidWinnerWhenWinsAreAboveHalf = new Tournament(TournamentRounds1);

   @Test
   public void finalWinnerIsValidWithAnExpectedWinner(){
       assertTrue(ValidWinnerWhenWinsAreAboveHalf.finalWinnerIsValid(robTeamA));
   }
   
   @Test
   public void finalWinnerIsValidWithAnUnexpectedWinner(){
       assertFalse(ValidWinnerWhenWinsAreAboveHalf.finalWinnerIsValid(robTeamB));
   }

   InitRound InitRoundEmpty = new InitRound(emptyListOfMatches);
   AdvancedRound AdvancedRoundEmpty = new AdvancedRound(emptyListOfMatches,emptyListOfContestants);
   Tournament EmptyTournament = new Tournament(TournamentRounds2);

   @Test
   public void finalWinnerIsValidWithAnEmptyTournament(){
       assertFalse(EmptyTournament.finalWinnerIsValid(robTeamA));
   }
   
   @Test
   public void finalWinnerIsValidWithAnEmptyTournamentAndInputIsNull(){
       assertFalse(EmptyTournament.finalWinnerIsValid(null));
   }

   Tournament HalfTournament = new Tournament(TournamentRounds3);

   @Test
   public void finalWinnerIsValidWithTheWinnerHavingExactlyHalfTheWins(){
       assertTrue(HalfTournament.finalWinnerIsValid(robTeamA));
   }
}


