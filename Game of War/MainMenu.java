/**
   Jaired Stewart
   CS 110
   4/28/2015
   
   MainMenu class is the GUI main menu for Game of War
*/
import javax.swing.*; //needed for Swing Classes
import java.awt.*; //needed for BorderLayout Class
import java.awt.event.*; //needed for Event Listeners
public class MainMenu extends JFrame
{
   private JPanel titlePanel;
   private JPanel buttonPanel;
   //welcome label
   private JLabel welcomeLabel;
   //buttons for Play, Quit, and Instructions
   private JButton playButton;
   private JButton quitButton;
   private JButton instructionButton;
   //set dimensions of window
   private final int WINDOW_WIDTH = 400;
   private final int WINDOW_HEIGHT = 250;
   
   /**
      Constructor
   */
   public MainMenu()
   {
      //set title
      setTitle("Game of War");
      
      //set size 
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
      
      //set default close
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      //create the label
      welcomeLabel = new JLabel("Welcome to Game of War");
      
      //create the three buttons
      playButton = new JButton("Play");
      instructionButton = new JButton("Rules");
      quitButton = new JButton("Quit");
      
      //create panels 
      titlePanel = new JPanel();
      buttonPanel = new JPanel();
      
      // add label and buttons to panel
      titlePanel.add(welcomeLabel);
      buttonPanel.add(playButton);
      //add an action listener to the play button
      playButton.addActionListener(new PlayButtonListener());
      buttonPanel.add(instructionButton);
      //add an action listener to the instruction button
      instructionButton.addActionListener(new InstrButtonListener());
      buttonPanel.add(quitButton);
      //add an action listener to the quit button
      quitButton.addActionListener(new QuitButtonListener());
      
      //add borderlayout manager
      setLayout(new BorderLayout());
      
      //add panel
      add(titlePanel, BorderLayout.NORTH);      
      add(buttonPanel, BorderLayout.CENTER);
      
      //display window
      
      setVisible(true);
   }
   /**
      PlayButtonListener is an action listener for the Play Button
   */
   private class PlayButtonListener implements ActionListener
   {
      /**
         The actionPerformed method executes when the user clicks the play button,
         it will create an instance of WarGUI
         @param ActionEvent e
      */
      public void actionPerformed(ActionEvent e)
      {
         new WarGUI();
         //System.exit(0);
      }
   }   
   /**
      InstrButtonListener is an action listener for the Instruction Button
   */
   private class InstrButtonListener implements ActionListener
   {
      /**
         The actionPerformed method executes when the user clicks the instruction button,
         displays a message dialog box that shows the rules for Game of War
         @param ActionEvent e
      */ 
      public void actionPerformed(ActionEvent e)
      {
         JOptionPane.showMessageDialog(null, "Rules of War: \n -War is a simple card game with two players\n" 
                                       + " -Each player has a deck of cards and each round flips the top card" 
                                       + " of the deck.\n -The player with the highest card 'wins' that round" 
                                       + " and takes both cards into their discard pile.\n -In the event of" 
                                       + " a tie, a 'War' happens where each player draws the top three cards"
                                       + " of their deck face down and \n flip a fourth card to determine the"
                                       + " winner, who takes all of the cards involved in the war into"
                                       + " his/her discard pile.\n -Play continues until one player runs out"
                                       + " of cards, at which point the player with all of the cards is"
                                       + " declared the victor.\n -In the event that a player runs out of cards" 
                                       + " during a War, that player is immediately defeated.");
      }
  }
   /**
      QuitButtonListener is an action listener for the Quit button
   */
   private class QuitButtonListener implements ActionListener
   {
      /**
         The actionPerformed method excecutes when the user clicks on the quit button, terminates the 
         program
         @param e The event object
      */
      public void actionPerformed(ActionEvent e)
      {
         System.exit(0);
      }
   }         
}