/**
   Jaired Stewart
   CS 110
   4/28/2015

   GameOfWar is the nonGUI implementation 
*/
public class GameOfWar
{
   //fields
   private Player user;
   private Player opponent;
   private int userCardsLeft;
   private int userDiscard;
   private int opponentCardsLeft;
   private int opponentDiscard;
   
   /**
      No Arg Constructor that creates two Player objects 
   */
   public GameOfWar()
   {
      user = new Player();
      opponent = new Player();
   }
   /**
      getUserCards calculates and returns the value of the userCardsLeft field
      @return int userCardsLeft
   */
   public int getUserCards()
   {
      userCardsLeft = user.getActiveSize();
      return userCardsLeft;
   }
   /**
      getUserDiscard calculates and returns the value of the userDiscard field
      @return int userDiscard
   */
   public int getUserDiscard()
   {
      userDiscard = user.getDiscardSize();
      return userDiscard;
   }
   /**
      getOpponentCards calculates and returns the value of the opponentCardsLeft field
      @return int opponentCardsLeft
   */
   public int getOpponentCards()
   {
      opponentCardsLeft = opponent.getActiveSize();
      return opponentCardsLeft;
   }
   /**
      getOpponentDiscard calculates and returns the value of the opponentDiscard field
      @return int opponentDiscard
   */
   public int getOpponentDiscard()
   {
      opponentDiscard = opponent.getDiscardSize();
      return opponentDiscard;
   }
}
      
      
      
   
   
   