/**
 * Representation of a Deck of cards.  
 * Initialized to a standard 52 card deck. 
    *
 * @author Jackie Horton
   modified for Game of War by Jaired Stewart 
   Modifications:
   -cardsInDeck now a private int instead of a constant as in war a deck might have more than 52 Cards
   -new Contstant named STANDARD_DECK for freshDeck method
   -copy constructor that accepts a deck of any size 
   -conttructor that creates an empty deck of a given size
 */

import java.util.Random;
public class Deck 
{
   /** 
   *  Number of cards in deck {@value #CARDS_IN_DECK}
   **/
   private int cardsInDeck;
   //Standard number of cards in Deck
   public static final int STANDARD_DECK = 52;
   /** The collection of Cards */
   private Card [] deck;
   /** Current number of Cards in Deck */
   private int ct;
   
   /**
    * Constructs a regular 52-card deck.  Initially, the cards
    * are in a sorted order.  The shuffle() method can be called to
    * randomize the order.  
    */
   public Deck()
   {
      freshDeck();
   }
   /**
      Copy constructor that creates a copy of another deck input as an argument
      It is possible to have multiple of the same card and have more or less
      than 52 cards
      @param Deck otherDeck
   */
   public Deck(Deck otherDeck)
   {
      cardsInDeck = otherDeck.cardsRemaining();
      deck = new Card [cardsInDeck];
      for(int i = 0; i<cardsInDeck; i++)
      {
         deck[ct] = new Card(otherDeck.dealCard());
         ct++;
      }   
   }
   /**
      Constructor that creates an empty deck of a given size
      @param int deckSize
   */
   public Deck(int deckSize)
   {
      cardsInDeck = deckSize;
      deck = new Card[cardsInDeck];
   }
   /**
    * Create a new collection of 52 cards, in sorted order
    */
   public void freshDeck()
   {
      deck = new Card[STANDARD_DECK];
      for (int r = Card.ACE; r<=Card.KING;r++)
      {
         for (int s=Card.SPADES;s<=Card.CLUBS;s++)
         {
            deck[ct]=new Card(r,s);
            ct = ct + 1;
         }
      }
     
   
   }
   /** 
     * Remove and return the top Card on the Deck
     * @return A reference to a Card that was top on the Deck
     */
   public Card dealCard()
   {
      ct--;
      return deck[ct];
   }
   /** 
     * Return current number of Cards in Deck
     * @return number of Cards in Deck
     */
   public int cardsRemaining()
   {  
      return ct;
   }
   /**
      Add a card to the deck
      @param Card addedCard
   */
   public void add(Card addedCard)
   {
      Card temp = new Card(addedCard);
      deck[ct] = temp;
      ct++;
   }
   /** 
     * Randomize the order of Cards in Deck
     */
   public void shuffle()
   {
      int randNum;
      Card temp;
      Random r = new Random();
      for (int i = 0; i < ct; i++)
      {
         randNum = r.nextInt(ct);
         temp = deck[i];
         deck[i]=deck[randNum];
         deck[randNum]=temp;
      }
   }
   /** 
     * Determine if Deck is empty
     * @return true if there are no more cards, false otherwise
     */
   public boolean isEmpty()
   {
      return (cardsRemaining() == 0);
   }

   public static void main(String [] args) 
   {
      Deck deck = new Deck();
      deck.shuffle();
      int i = 0;
      while (!(deck.isEmpty()))
         System.out.println(i++ + " : " + deck.dealCard().toString());
      deck.freshDeck();
      System.out.println("************");
      i = 0;
      while (!(deck.isEmpty()))
         System.out.println(i++ + " : " + deck.dealCard().toString());

   }
}
