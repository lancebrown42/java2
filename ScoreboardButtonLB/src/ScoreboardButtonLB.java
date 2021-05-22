import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author Lance Brown
 * @since 5/14/21
 * Displays a gui that allows incrementing two teams scores and resetting the board.
 *
 */
public class ScoreboardButtonLB implements ActionListener{
    int redScoreAmount = 0;
    int blueScoreAmount = 0;
    // Define the JLabels
    JLabel redLabel, blueLabel, redScore, blueScore;
    // Define the JButtons
    JButton redButton, blueButton, resetButton;
    // Define the JPanels
    JPanel titlePanel, scorePanel, buttonPanel;


	/**
	 * method createContentPane
	 * Creates the interface panel with buttons and labels
	 * @return Scoreboard scoreboard content panel
	 * @throws NullPointerException
	 */
	public JPanel createContentPane () throws NullPointerException {
		// bottom panel
        JPanel ScoreBoard = new JPanel();
        ScoreBoard.setLayout(null);

        //title panel
        titlePanel = new JPanel();
        titlePanel.setLayout(null);
        titlePanel.setLocation(10, 0);
        titlePanel.setSize(250, 30);
        ScoreBoard.add(titlePanel);

        // Red Team
        redLabel = new JLabel("Red Team");
        redLabel.setLocation(0, 0);
        redLabel.setSize(120, 30);
        redLabel.setHorizontalAlignment(0);
        redLabel.setForeground(Color.red);
        titlePanel.add(redLabel);

        // blue team
        blueLabel = new JLabel("Blue Team");
        blueLabel.setLocation(130, 0);
        blueLabel.setSize(120, 30);
        blueLabel.setHorizontalAlignment(0);
        blueLabel.setForeground(Color.blue);
        titlePanel.add(blueLabel);

        // score panel
        scorePanel = new JPanel();
        scorePanel.setLayout(null);
        scorePanel.setLocation(10, 40);
        scorePanel.setSize(260, 30);
        ScoreBoard.add(scorePanel);

        // redScore
        redScore = new JLabel(""+redScoreAmount);
        redScore.setLocation(0, 0);
        redScore.setSize(120, 30);
        redScore.setHorizontalAlignment(0);
        scorePanel.add(redScore);

        // blueScore
        blueScore = new JLabel(""+blueScoreAmount);
        blueScore.setLocation(130, 0);
        blueScore.setSize(120, 30);
        blueScore.setHorizontalAlignment(0);
        scorePanel.add(blueScore);

        // panel for the buttons
        buttonPanel = new JPanel();
        buttonPanel.setLayout(null);
        buttonPanel.setLocation(10, 80);
        buttonPanel.setSize(260, 70);
        ScoreBoard.add(buttonPanel);

        // red score button
        redButton = new JButton("Red Score!");
        redButton.setLocation(0, 0);
        redButton.setSize(120, 30);
        redButton.addActionListener(this);
        buttonPanel.add(redButton);

        // blue score button
        blueButton = new JButton("Blue Score!");
        blueButton.setLocation(130, 0);
        blueButton.setSize(120, 30);
        blueButton.addActionListener(this);
        buttonPanel.add(blueButton);

        // reset
        resetButton = new JButton("Reset Score");
        resetButton.setLocation(0, 40);
        resetButton.setSize(250, 30);
        resetButton.addActionListener(this);
        buttonPanel.add(resetButton);

        
        ScoreBoard.setOpaque(true);
        return ScoreBoard;

	}
	/**
	 * method actionPerformed
	 * handles button clicks by incrementing a score or resetting
	 *
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == redButton)
        {
            redScoreAmount = redScoreAmount + 1;
            redScore.setText(""+redScoreAmount);
        }
        else if(e.getSource() == blueButton)
        {
            blueScoreAmount = blueScoreAmount + 1;
            blueScore.setText(""+blueScoreAmount);
        }
        else if(e.getSource() == resetButton)
        {
            redScoreAmount = 0;
            blueScoreAmount = 0;
            redScore.setText(""+redScoreAmount);
            blueScore.setText(""+blueScoreAmount);
        }

	
	
	}
	/**
	 * method createAndShowGUI
	 * gui factory creates panes and sets visibility
	 * 
	 */
	private static void createAndShowGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame(" Scoreboard ");
        ScoreboardButtonLB scoreboard = new ScoreboardButtonLB();
        frame.setContentPane(scoreboard.createContentPane());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(280, 190);
        frame.setVisible(true);
	
	
	}
	/**
	 * main method
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	createAndShowGUI();

            }
		});
	}
}
