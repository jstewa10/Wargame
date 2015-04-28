/**
   Jaired Stewart
   CS 110 
   2/27/2015
   
   Card Class simulates a card, rank and suit. 
*/ 
public class Card
{
   //private final variables for rank and suit so that they can't be changed after creation
   private final int rank;
   private final int suit; 
   //public class constants for suits
   public final static int SPADES = 0;
   public final static int CLUBS = 1;
   public final static int HEARTS = 2; 
   public final static int DIAMONDS = 3;
   //public class constants for face cards 
   public final static int ACE = 1;
   public final static int JACK = 11;
   public final static int QUEEN = 12;
   public final static int KING = 13; 
   
   /**
      Card class constructor with suit and rank specified. Suit will bespecified in the form
      Card.SPADES, and rank eithr the number so just 10 or something like Card.JACK for a face 
      card. 
      @param int rank: the number rank
      @param int suit: the suit using the class constants 
   */
   public Card(int rank, int suit)
   {
      this.rank = rank;
      this.suit = suit; 
   }
   /**
      The getSuit method returns the suit associated with the Card object as an int such that:
      0 = Spade 
      1 = Club
      2 = Heart
      3 = Diamond 
      @return int suit
   */
   public int getSuit()
   {
      return suit; 
   }
   /**
      The get rank method returns the rank associated with the card object at an int,
      for face cards:
      1 = Ace
      11 = Jack
      12 = Queen 
      13 = King
      @return int rank
   */
   public int getRank()
   {
      return rank;
   }
   /**
      The toString class returns the name of the card object in the form of a string like:
      rankString + " of" + suitString
      @return String returnString: the above string
   */
   public String toString()
   {
      String suitString; //String to hold the suit converted to a string
      String rankString; //String to hold the rank converted to a string if a face card
      String returnString;
      //if else if statements to convert the suit to a string 
      if (suit == Card.SPADES)
         suitString = "Spades";
      else if (suit == Card.CLUBS)
         suitString = "Clubs";
      else if (suit == Card.HEARTS)
         suitString = "Hearts";
      else 
         suitString = "Diamonds";
     
      //if else if statements to convert the rank to a string
      if (rank == Card.ACE)
      {
         rankString = "Ace";
         returnString = rankString + " of " +suitString;
      }
      else if (rank == Card.JACK)
      { 
         rankString = "Jack";
         returnString = rankString + " of " +suitString;
      }
      else if (rank == Card.QUEEN)
      { 
         rankString = "Queen";
         returnString = rankString + " of " +suitString;
      }   
      else if (rank == Card.KING)
      { 
         rankString = "King";
         returnString = rankString + " of " +suitString;
      }   
      else //if not a facecard returnString uses numerical rank
         returnString = rank + " of " +suitString;
      //return the card in a string 
      return returnString;
   }
   
   /**
      The equals method compares two cards and if their ranks are equal returns true
      @param a reference to a card object
      @return boolean status: returns true if the cards are equal and false if they are not
   */
   public boolean equals(Card card2)
   {
      boolean status; //create a boolean variable for a status
      if (this.rank == card2.rank)
         status = true;
      else 
         status = false;
      return status;
   }
}