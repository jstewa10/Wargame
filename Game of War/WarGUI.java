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
   
   //next round and quit buttons for south panel
   private JButton nextRoundButton;
   private JButton mainMenuButton;
   /**
      Constructor
   */
   public WarGUI()
   {
      //setTitle
      setTitle("Game of War");
      
      //create panels
      northPanel = new JPanel();
      centerPanel = new JPanel();
      eastPanel = new JPanel();
      westPanel = new JPanel();
      southPanel = new JPanel();
      
      //add border layout manager
      setLayout(new BorderLayout());
      
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