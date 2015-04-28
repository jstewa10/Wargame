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
      player1Discard = new JTextField(3);
      player1Discard.setEditable(false);
      
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
      player2Discard = new JTextField(3);
      player2Discard.setEditable(false); 
      //add labels and fields
      westPanel.add(player2Label);
      westPanel.add(cardsInDeckWLabel);
      westPanel.add(player2Deck);
      westPanel.add(cardsInDiscardWLabel);
      westPanel.add(player2Discard);
      pack();
      
      //center panel
      
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
      ///////////////////////needs to be figured out////////////////////
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
         //System.exit(0);
      }
   }
}