/** 
   Jaired Stewart 
   CS 110 
   4/28/2015
   
   WarGUI is the GUI implementation ofthe war Card Game, it is created when the user presses the play
   button on the MainMenu
*/
import javax.swing.*;//needed for Swing classes
import java.awt.*; //needed for BorderLayout class
import java.awt.event.*; // needed for ActionListener class
public class WarGUI extends JFrame
{
   private GameOfWar game; //the game itself
   //panels for each BorderLayout 
   private JPanel northPanel;
   private JPanel southPanel;
   private JPanel eastPanel;
   private JPanel westPanel;
   private JPanel centerPanel;
   
   //Heading Label for North Panel
   private JLabel headingLabel;
   
   //Player Label for East Panel
   private JLabel player1Label;
   //CardsInDeck Label for East Panel
   private JLabel cardsInDeckLabel;
   //CardsInDiscard Label for East Panel
   private JLabel cardsInDiscardLabel;
   //read-only text fields for East Panel
   private JTextField player1Deck;
   private JTextField player1Discard;
   
   //Player Label for West Panel
   private JLabel  player2Label;
   //CardsInDeck Label for West Panel
   private JLabel cardsInDeckWLabel;
   //CardsInDiscard Label for West Panel
   private JLabel cardsInDiscardWLabel;
   //read-only text fields for West Panel
   private JTextField player2Deck;
   private JTextField player2Discard;
   
   //labels for card images in center Panel
   private JLabel userCardImage;
   private JLabel oppCardImage;
   
   //next round and quit buttons for South panel
   private JButton nextRoundButton;
   private JButton mainMenuButton;
   /**
      Constructor
   */
   public WarGUI()
   {
      //setTitle
      setTitle("Game of War");
      game = new GameOfWar();
      
      //set default exit
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      //create panels
      northPanel = new JPanel();
      centerPanel = new JPanel();
      eastPanel = new JPanel();
      westPanel = new JPanel();
      southPanel = new JPanel();
      
      //add border layout manager
      setLayout(new BorderLayout());
      
      //North Panel 
      
      //create heading label for north Panel
      headingLabel = new JLabel("Game Of War");
      
      //add to north panel
      northPanel.add(headingLabel);
      
      //East Panel
      player1Label = new JLabel("OPPONENT");
      cardsInDeckLabel = new JLabel("Cards in Deck: ");
      cardsInDiscardLabel = new JLabel("Cards in Discard: ");
      player1Deck = new JTextField(3);
      player1Deck.setEditable(false);
      player1Deck.setText(Integer.toString(52)); //initialize deck size to 52
      player1Discard = new JTextField(3);
      player1Discard.setEditable(false);
      player1Discard.setText(Integer.toString(0)); //initialize discard size to 0 
      
      //add labels and fields
      eastPanel.add(player1Label);
      eastPanel.add(cardsInDeckLabel);
      eastPanel.add(player1Deck);
      eastPanel.add(cardsInDiscardLabel);
      eastPanel.add(player1Discard);
      pack();
      
      //West Panel
      player2Label = new JLabel("YOU");
      cardsInDeckWLabel = new JLabel("Cards in Deck: ");
      cardsInDiscardWLabel = new JLabel("Cards in Discard: ");
      player2Deck = new JTextField(3);
      player2Deck.setEditable(false);
      player2Deck.setText(Integer.toString(52)); //initialize deck size to 52
      player2Discard = new JTextField(3);
      player2Discard.setEditable(false); 
      player2Discard.setText(Integer.toString(0)); //initialize discard to 0
      //add labels and fields
      westPanel.add(player2Label);
      westPanel.add(cardsInDeckWLabel);
      westPanel.add(player2Deck);
      westPanel.add(cardsInDiscardWLabel);
      westPanel.add(player2Discard);
      pack();
      
      //Center panel
      
      //create labels
      ImageIcon cardBackImage = new ImageIcon ("back.jpg");
      userCardImage = new JLabel(cardBackImage);
      oppCardImage = new JLabel(cardBackImage);
      //add to center Panel
      centerPanel.add(userCardImage);
      centerPanel.add(oppCardImage);
      pack();
      //South panel
      
      //create next round and quit buttons 
      nextRoundButton = new JButton("Next Round");
      //create action listener for next round button
      nextRoundButton.addActionListener(new NextRoundButtonListener());
      mainMenuButton = new JButton("Main Menu");
      //create action listener for mainMenuButton
      mainMenuButton.addActionListener(new MainMenuButtonListener());
      //add next round and main menu buttons to southPanel
      southPanel.add(nextRoundButton);
      southPanel.add(mainMenuButton);
      
      //add panels 
      add(northPanel, BorderLayout.NORTH);
      add(eastPanel, BorderLayout.EAST);
      add(westPanel, BorderLayout.WEST);
      add(southPanel, BorderLayout.SOUTH);
      add(centerPanel, BorderLayout.CENTER);
      
      
      //display window
      pack();
      setVisible(true);
   }   
      
   /**
      NextRoundButtonListener is an action listener for the next round button
   */
   private class NextRoundButtonListener implements ActionListener
   {
      /**
         actionPerformed executes when the user clicks the Next Round Button and performs a round of 
         a game of war
         @param ActionEvent e
      */
      public void actionPerformed(ActionEvent e)
      {
         Card user; 
         Card opp;
         //play a round
         game.round();
         user = game.getUserCard();
         //update card images
         switch (user.toString())
         {
            case "Ace of Hearts":
               ImageIcon aceh = new ImageIcon("aceh.jpg");
               userCardImage.setIcon(aceh);
               break;
            case "Ace of Spades":
               ImageIcon aces = new ImageIcon("aces.jpg");
               userCardImage.setIcon(aces);
               break;
            case "Ace of Clubs":
               ImageIcon acec = new ImageIcon("acec.jpg");
               userCardImage.setIcon(acec);
               break;
            case "Ace of Diamonds":
               ImageIcon aced = new ImageIcon("aced.jpg");
               userCardImage.setIcon(aced);
               break;
            case "2 of Hearts":
               ImageIcon h2 = new ImageIcon("2h.jpg");
               userCardImage.setIcon(h2);
            case "2 of Spades":
               ImageIcon s2 = new ImageIcon("2s.jpg");
               userCardImage.setIcon(s2);
               break;
            case "2 of Clubs":
               ImageIcon c2 = new ImageIcon("2c.jpg");
               userCardImage.setIcon(c2);
               break;
            case "2 of Diamonds":
               ImageIcon d2 = new ImageIcon("2d.jpg");
               userCardImage.setIcon(d2);
               break;
            case "3 of Hearts":
               ImageIcon h3 = new ImageIcon("3h.jpg");
               userCardImage.setIcon(h3);
               break;
            case "3 of Spades":
               ImageIcon s3 = new ImageIcon("3s.jpg");
               userCardImage.setIcon(s3);
               break;               
            case "3 of Clubs":
               ImageIcon c3 = new ImageIcon("3c.jpg");
               userCardImage.setIcon(c3);
               break;               
            case "3 of Diamonds":
               ImageIcon d3 = new ImageIcon("3d.jpg");
               userCardImage.setIcon(d3);
               break; 
            case "4 of Hearts":
               ImageIcon h4 = new ImageIcon("4h.jpg");
               userCardImage.setIcon(h4);
               break;
            case "4 of Spades":
               ImageIcon s4 = new ImageIcon("4s.jpg");
               userCardImage.setIcon(s4);
               break;               
            case "4 of Clubs":
               ImageIcon c4 = new ImageIcon("4c.jpg");
               userCardImage.setIcon(c4);
               break;
            case "4 of Diamonds":
               ImageIcon d4 = new ImageIcon("4d.jpg");
               userCardImage.setIcon(d4);
               break;
            case "5 of Hearts":
               ImageIcon h5 = new ImageIcon("5h.jpg");
               userCardImage.setIcon(h5);
               break;
            case "5 of Spades":
               ImageIcon s5 = new ImageIcon("5s.jpg");
               userCardImage.setIcon(s5);
               break;
            case "5 of Clubs":
               ImageIcon c5 = new ImageIcon("5c.jpg");
               userCardImage.setIcon(c5);
               break;
            case "5 of Diamonds":
               ImageIcon d5 = new ImageIcon("5d.jpg");
               userCardImage.setIcon(d5);
               break;
            case "6 of Hearts":
               ImageIcon h6 = new ImageIcon("6h.jpg");
               userCardImage.setIcon(h6);
               break;
            case "6 of Clubs":
               ImageIcon c6 = new ImageIcon("6c.jpg");
               userCardImage.setIcon(c6);
               break; 
            case "6 of Spades":
               ImageIcon s6 = new ImageIcon("6s.jpg");
               userCardImage.setIcon(s6);
               break;
            case "6 of Diamonds":
               ImageIcon d6 = new ImageIcon("6d.jpg");
               userCardImage.setIcon(d6);
               break;
            case "7 of Hearts":
               ImageIcon h7 = new ImageIcon("7h.jpg");
               userCardImage.setIcon(h7);
               break;
            case "7 of Clubs":
               ImageIcon c7 = new ImageIcon("7c.jpg");
               userCardImage.setIcon(c7);
               break; 
            case "7 of Spades":
               ImageIcon s7 = new ImageIcon("7s.jpg");
               userCardImage.setIcon(s7);
               break;
            case "7 of Diamonds":
               ImageIcon d7 = new ImageIcon("7d.jpg");
               userCardImage.setIcon(d7);
               break;
            case "8 of Hearts":
               ImageIcon h8 = new ImageIcon("8h.jpg");
               userCardImage.setIcon(h8);
               break;
            case "8 of Clubs":
               ImageIcon c8 = new ImageIcon("8c.jpg");
               userCardImage.setIcon(c8);
               break; 
            case "8 of Spades":
               ImageIcon s8 = new ImageIcon("8s.jpg");
               userCardImage.setIcon(s8);
               break;
            case "8 of Diamonds":
               ImageIcon d8 = new ImageIcon("8d.jpg");
               userCardImage.setIcon(d8);
               break;               
            case "9 of Hearts":
               ImageIcon h9 = new ImageIcon("9h.jpg");
               userCardImage.setIcon(h9);
               break;
            case "9 of Clubs":
               ImageIcon c9 = new ImageIcon("9c.jpg");
               userCardImage.setIcon(c9);
               break; 
            case "9 of Spades":
               ImageIcon s9 = new ImageIcon("9s.jpg");
               userCardImage.setIcon(s9);
               break;
            case "9 of Diamonds":
               ImageIcon d9 = new ImageIcon("9d.jpg");
               userCardImage.setIcon(d9);
               break;            
            case "10 of Hearts":
               ImageIcon h10 = new ImageIcon("10h.jpg");
               userCardImage.setIcon(h10);
               break;
            case "10 of Clubs":
               ImageIcon c10 = new ImageIcon("10c.jpg");
               userCardImage.setIcon(c10);
               break; 
            case "10 of Spades":
               ImageIcon s10 = new ImageIcon("10s.jpg");
               userCardImage.setIcon(s10);
               break;
            case "10 of Diamonds":
               ImageIcon d10 = new ImageIcon("10d.jpg");
               userCardImage.setIcon(d10);
               break;  
            case "Jack of Hearts":
               ImageIcon jackh = new ImageIcon("jackh.jpg");
               userCardImage.setIcon(jackh);
               break;
            case "Jack of Clubs":
               ImageIcon jackc = new ImageIcon("jackc.jpg");
               userCardImage.setIcon(jackc);
               break; 
            case "Jack of Spades":
               ImageIcon jacks = new ImageIcon("jacks.jpg");
               userCardImage.setIcon(jacks);
               break;
            case "Jack of Diamonds":
               ImageIcon jackd = new ImageIcon("jackd.jpg");
               userCardImage.setIcon(jackd);
               break; 
            case "Queen of Hearts":
               ImageIcon queenh = new ImageIcon("queenh.jpg");
               userCardImage.setIcon(queenh);
               break;   
            case "Queen of Spades":
               ImageIcon queens = new ImageIcon("queens.jpg");
               userCardImage.setIcon(queens);
               break;        
            case "Queen of Clubs":
               ImageIcon queenc = new ImageIcon("queenc.jpg");
               userCardImage.setIcon(queenc);
               break;        
            case "Queen of Diamonds":
               ImageIcon queend = new ImageIcon("queend.jpg");
               userCardImage.setIcon(queend);
               break; 
            case "King of Hearts":
               ImageIcon kingh = new ImageIcon("kingh.jpg");
               userCardImage.setIcon(kingh);
               break; 
            case "King of Spades":
               ImageIcon kings = new ImageIcon("kings.jpg");
               userCardImage.setIcon(kings);
               break;  
            case "King of Clubs":
               ImageIcon kingc = new ImageIcon("kingc.jpg");
               userCardImage.setIcon(kingc);
               break;  
            case "King of Diamonds":
               ImageIcon kingd = new ImageIcon("kingd.jpg");
               userCardImage.setIcon(kingd);
               break;      
         }
         opp = game.getOppCard();      
         switch (opp.toString())
         {
            case "Ace of Hearts":
               ImageIcon aceh = new ImageIcon("aceh.jpg");
               userCardImage.setIcon(aceh);
               break;
            case "Ace of Spades":
               ImageIcon aces = new ImageIcon("aces.jpg");
               userCardImage.setIcon(aces);
               break;
            case "Ace of Clubs":
               ImageIcon acec = new ImageIcon("acec.jpg");
               userCardImage.setIcon(acec);
               break;
            case "Ace of Diamonds":
               ImageIcon aced = new ImageIcon("aced.jpg");
               userCardImage.setIcon(aced);
               break;
            case "2 of Hearts":
               ImageIcon h2 = new ImageIcon("2h.jpg");
               userCardImage.setIcon(h2);
            case "2 of Spades":
               ImageIcon s2 = new ImageIcon("2s.jpg");
               userCardImage.setIcon(s2);
               break;
            case "2 of Clubs":
               ImageIcon c2 = new ImageIcon("2c.jpg");
               userCardImage.setIcon(c2);
               break;
            case "2 of Diamonds":
               ImageIcon d2 = new ImageIcon("2d.jpg");
               userCardImage.setIcon(d2);
               break;
            case "3 of Hearts":
               ImageIcon h3 = new ImageIcon("3h.jpg");
               userCardImage.setIcon(h3);
               break;
            case "3 of Spades":
               ImageIcon s3 = new ImageIcon("3s.jpg");
               userCardImage.setIcon(s3);
               break;               
            case "3 of Clubs":
               ImageIcon c3 = new ImageIcon("3c.jpg");
               userCardImage.setIcon(c3);
               break;               
            case "3 of Diamonds":
               ImageIcon d3 = new ImageIcon("3d.jpg");
               userCardImage.setIcon(d3);
               break; 
            case "4 of Hearts":
               ImageIcon h4 = new ImageIcon("4h.jpg");
               userCardImage.setIcon(h4);
               break;
            case "4 of Spades":
               ImageIcon s4 = new ImageIcon("4s.jpg");
               userCardImage.setIcon(s4);
               break;               
            case "4 of Clubs":
               ImageIcon c4 = new ImageIcon("4c.jpg");
               userCardImage.setIcon(c4);
               break;
            case "4 of Diamonds":
               ImageIcon d4 = new ImageIcon("4d.jpg");
               userCardImage.setIcon(d4);
               break;
            case "5 of Hearts":
               ImageIcon h5 = new ImageIcon("5h.jpg");
               userCardImage.setIcon(h5);
               break;
            case "5 of Spades":
               ImageIcon s5 = new ImageIcon("5s.jpg");
               userCardImage.setIcon(s5);
               break;
            case "5 of Clubs":
               ImageIcon c5 = new ImageIcon("5c.jpg");
               userCardImage.setIcon(c5);
               break;
            case "5 of Diamonds":
               ImageIcon d5 = new ImageIcon("5d.jpg");
               userCardImage.setIcon(d5);
               break;
            case "6 of Hearts":
               ImageIcon h6 = new ImageIcon("6h.jpg");
               userCardImage.setIcon(h6);
               break;
            case "6 of Clubs":
               ImageIcon c6 = new ImageIcon("6c.jpg");
               userCardImage.setIcon(c6);
               break; 
            case "6 of Spades":
               ImageIcon s6 = new ImageIcon("6s.jpg");
               userCardImage.setIcon(s6);
               break;
            case "6 of Diamonds":
               ImageIcon d6 = new ImageIcon("6d.jpg");
               userCardImage.setIcon(d6);
               break;
            case "7 of Hearts":
               ImageIcon h7 = new ImageIcon("7h.jpg");
               userCardImage.setIcon(h7);
               break;
            case "7 of Clubs":
               ImageIcon c7 = new ImageIcon("7c.jpg");
               userCardImage.setIcon(c7);
               break; 
            case "7 of Spades":
               ImageIcon s7 = new ImageIcon("7s.jpg");
               userCardImage.setIcon(s7);
               break;
            case "7 of Diamonds":
               ImageIcon d7 = new ImageIcon("7d.jpg");
               userCardImage.setIcon(d7);
               break;
            case "8 of Hearts":
               ImageIcon h8 = new ImageIcon("8h.jpg");
               userCardImage.setIcon(h8);
               break;
            case "8 of Clubs":
               ImageIcon c8 = new ImageIcon("8c.jpg");
               userCardImage.setIcon(c8);
               break; 
            case "8 of Spades":
               ImageIcon s8 = new ImageIcon("8s.jpg");
               userCardImage.setIcon(s8);
               break;
            case "8 of Diamonds":
               ImageIcon d8 = new ImageIcon("8d.jpg");
               userCardImage.setIcon(d8);
               break;               
            case "9 of Hearts":
               ImageIcon h9 = new ImageIcon("9h.jpg");
               userCardImage.setIcon(h9);
               break;
            case "9 of Clubs":
               ImageIcon c9 = new ImageIcon("9c.jpg");
               userCardImage.setIcon(c9);
               break; 
            case "9 of Spades":
               ImageIcon s9 = new ImageIcon("9s.jpg");
               userCardImage.setIcon(s9);
               break;
            case "9 of Diamonds":
               ImageIcon d9 = new ImageIcon("9d.jpg");
               userCardImage.setIcon(d9);
               break;            
            case "10 of Hearts":
               ImageIcon h10 = new ImageIcon("10h.jpg");
               userCardImage.setIcon(h10);
               break;
            case "10 of Clubs":
               ImageIcon c10 = new ImageIcon("10c.jpg");
               userCardImage.setIcon(c10);
               break; 
            case "10 of Spades":
               ImageIcon s10 = new ImageIcon("10s.jpg");
               userCardImage.setIcon(s10);
               break;
            case "10 of Diamonds":
               ImageIcon d10 = new ImageIcon("10d.jpg");
               userCardImage.setIcon(d10);
               break;  
            case "Jack of Hearts":
               ImageIcon jackh = new ImageIcon("jackh.jpg");
               userCardImage.setIcon(jackh);
               break;
            case "Jack of Clubs":
               ImageIcon jackc = new ImageIcon("jackc.jpg");
               userCardImage.setIcon(jackc);
               break; 
            case "Jack of Spades":
               ImageIcon jacks = new ImageIcon("jacks.jpg");
               userCardImage.setIcon(jacks);
               break;
            case "Jack of Diamonds":
               ImageIcon jackd = new ImageIcon("jackd.jpg");
               userCardImage.setIcon(jackd);
               break; 
            case "Queen of Hearts":
               ImageIcon queenh = new ImageIcon("queenh.jpg");
               userCardImage.setIcon(queenh);
               break;   
            case "Queen of Spades":
               ImageIcon queens = new ImageIcon("queens.jpg");
               userCardImage.setIcon(queens);
               break;        
            case "Queen of Clubs":
               ImageIcon queenc = new ImageIcon("queenc.jpg");
               userCardImage.setIcon(queenc);
               break;        
            case "Queen of Diamonds":
               ImageIcon queend = new ImageIcon("queend.jpg");
               userCardImage.setIcon(queend);
               break; 
            case "King of Hearts":
               ImageIcon kingh = new ImageIcon("kingh.jpg");
               userCardImage.setIcon(kingh);
               break; 
            case "King of Spades":
               ImageIcon kings = new ImageIcon("kings.jpg");
               userCardImage.setIcon(kings);
               break;  
            case "King of Clubs":
               ImageIcon kingc = new ImageIcon("kingc.jpg");
               userCardImage.setIcon(kingc);
               break;  
            case "King of Diamonds":
               ImageIcon kingd = new ImageIcon("kingd.jpg");
               userCardImage.setIcon(kingd);
               break;      
         }
         //update deck totals
         player2Deck.setText(Integer.toString(game.getUserCards())); 
         player2Discard.setText(Integer.toString(game.getUserDiscard()));
         player1Deck.setText(Integer.toString(game.getOpponentCards()));
         player1Discard.setText(Integer.toString(game.getOpponentDiscard()));
 
      }
   }
   /**
      MainMenuButtonListener is an action listener for the Main Menu Button
   */
   private class MainMenuButtonListener implements ActionListener
   {
      /**
         actionPerformed executes when the user clicks the MainMenu button and returns the user to the 
         main menu
         @param ActionEvent e
      */
      public void actionPerformed(ActionEvent e)
      {
         new MainMenu();
      }
   }
}