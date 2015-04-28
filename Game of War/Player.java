/**
   Jaired Stewart
   CS 110
   4/28/2015
   
   The Player class represents a player in Game of War
*/
import java.util.ArrayList; //needed for ArrayList
public class Player
{
   //fields
   private ArrayList<Card> discardList;
   private Deck discard;
   private Deck active;
   private int discardSize;
   private int activeSize;
   public static final int LIST_SIZE = 104;
   
   /**
      No Arg Constructor creates a player with a standard shuffled 52 card active deck and initializes 
      discardSize to 0 and discardList is created with initial size 104 (since that is the max it could be
      if a player won every hand)
   */
   public Player()
   {
      active = new Deck();
      active.shuffle();
      discardSize = 0;
      discardList = new ArrayList<Card> (LIST_SIZE);
   }
   /**
      draw method returns the top card from the active deck
      @return Card topCard
   */
   public Card draw()
   {
      if(active.isEmpty())
      {
         shuffleDiscard();
         Card topCard = new Card(active.dealCard());
         return topCard;
      }
      else
      { 
         Card topCard = new Card(active.dealCard());
         return topCard;
      }
   }
   
   /**
      discard method- Variable argument method that adds a variable number of cards to the discardList 
      and increments discardSize each time 
      @param Card... cards
   */
   public void discard(Card... cards)
   {
      for (Card current : cards)
      {
         discardList.add(current);
         discardSize++;
      }
   }
   
   /**
      shuffleDiscard method shuffles the discard pile into the active deck
   */
   public void shuffleDiscard()
   {  
      //create discard deck the size of the discard list
      discard = new Deck(discardSize);
      Card temp;   
      //for loop that iterates over list and adds to empty deck 
      for(int i = 0; i < discardSize; i++)
      {
         temp = new Card(discardList.get(0));
         discard.add(temp);
         discardList.remove(0);
      }
      discardSize = 0;
      //set active deck to be a copy of the discard deck
      active = new Deck (discard);
      //shuffle new active deck 
      active.shuffle(); 
   }
   /**
      getDiscardSize returns the value of the discardSize field
      @return int discardSize
   */
   public int getDiscardSize()
   {
      return discardSize;
   }
   /**
      getActiveSize calculates and returns the value of the activeSize field
      @return int activeSize
   */
   public int getActiveSize()
   {
      activeSize = active.cardsRemaining();
      return activeSize;
   }
   public static void main(String[] args)
   {
      Player player1 = new Player();
      Player player2 = new Player();
      Card player1Card;
      for(int i = 0; i < 54; i++)
      {  
         player1Card = new Card(player1.draw());
         System.out.println(i + " " +player1Card);
         player1.discard(player1Card);
      }
         
   }
}

      