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
   private Card userCard;
   private Card oppCard;
   
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
   /**
      round simuates a round of war, in which both players play the top card and the values of those 
      cards are compared and the player with the highest card wins and puts both cards into his/her 
      discard. If the two cards are tied in rank, each player will draw three more cards and then compare 
      a fourth with the winner taking all cards involved. The method also returns the winner as a string
      @return String winner
   */
   public void round()
   {

      //draw cards 
      userCard = user.draw();
      oppCard = opponent.draw();
      
      //compare the cards
      
      //if they are equal, make a war
      if (userCard.equals(oppCard))
      {
         //war ensues, each player draws three more cards and compare a fourth
         war(userCard, oppCard);
      }   
      //if they are not equal, figure out which is higher ranked
      //if user is higher, user discards both cards
      else if(userCard.getRank() > oppCard.getRank())
      {
         user.discard(userCard, oppCard);
      }
      //else opponent's card is greater and opponent discards both cards
      else
      {
         opponent.discard(userCard, oppCard);
      }
   }
   /**
      The war method handles what happens when a war occurs, it should only be called from the round method
      and therefore is private. 
      @param Card userCard
      @param Card oppCard
   */
   private void war(Card userCard, Card oppCard)
   {
      //three cards for each player and a fourth to compare
      Card user1 = user.draw();
      Card user2 = user.draw();
      Card user3 = user.draw();
      Card userCompare = user.draw();
      Card opp1 = opponent.draw();
      Card opp2 = opponent.draw();
      Card opp3 = opponent.draw();
      Card oppCompare = opponent.draw();
      //if the cards are equal again, draw three more cards for each player and a fourth to compare
      if (userCompare.equals(oppCompare))
      {
         Card user4 = user.draw();
         Card user5 = user.draw();
         Card user6 = user.draw();
         Card userCompare2 = user.draw();
         Card opp4 = opponent.draw();
         Card opp5 = opponent.draw();
         Card opp6 = opponent.draw();
         Card oppCompare2 = opponent.draw();
         //compare the fourth cards
         if(userCompare2.getRank() > oppCompare2.getRank())
         {
            user.discard(user1,user2,user3,user4,user5,user6,userCompare,userCompare2,userCard);
            user.discard(opp1,opp2,opp3,opp4,opp5,opp6,oppCompare,oppCompare2,oppCard);
         }
         else
         {
            opponent.discard(user1,user2,user3,user4,user5,user6,userCompare,userCompare2,userCard);
            opponent.discard(opp1,opp2,opp3,opp4,opp5,opp6,oppCompare,oppCompare2,oppCard);
         }
      }
      //compare the fourth cards 
      else if(userCompare.getRank() > oppCompare.getRank())
      {
         user.discard(user1,user2,user3,userCompare,userCard,opp1,opp2,opp3,oppCompare,oppCard);
      }
      else
      {
         opponent.discard(user1,user2,user3,userCompare,userCard,opp1,opp2,opp3,oppCompare,oppCard);
      }
   }
   /**
      the getUserCard method returns the card drawn in the last round by the user
      @return Card userCard
   */
   public Card getUserCard()
   {
      return userCard;
   }
   /** 
       the getOpponentCard method returns the card drawn in the last round by the opponent
      @return Card oppCard
   */
   public Card getOppCard()
   {
      return oppCard;
   }

     
      
      
}
      
      
      
   
   
   