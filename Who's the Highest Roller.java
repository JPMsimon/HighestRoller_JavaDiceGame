Juan Paolo Simon’s Version 1
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class JPOggIndice extends JFrame implements ActionListener, KeyListener {

    private JLabel titleLabel;
    private JLabel instructionsLabel;
    private JLabel userTotalLabel;
    private JLabel computerTotalLabel;
    private JLabel resultLabel; // New label to display the result
    private JButton rollButton;
    private int userTotal = 0;
    private int computerTotal = 0;
    private int round = 0;
    private final Random random = new Random();
    private JLabel roundLabel;
    private boolean firstRoll = true;


    public JPOggIndice() {
        setTitle("JP Simon's 'Highest Roller' Game");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.black);

//Title that appears on the topmost part of the GUI:
        titleLabel = new JLabel("~WELCOME TO JP SIMON's GAME: WHO'S THE HIGHEST ROLLER?~");
        titleLabel.setForeground(Color.yellow);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(titleLabel);

//Instructions and game mechanics with HTML tags “<>” for line breaks and basic text formats (italicized and bold) :

        instructionsLabel = new JLabel("<html><br>INSTRUCTIONS: You'll be playing against your conscience as represented by the computer<br>(--sssh! It's a scenario. Just play along).<br>Each player will 'roll' the dice five times, and the one with the highest accumulated sum wins.<br>You can watch the numbers add on in every roll.<br><i>[***Tip: Maximize the window to make sure the button and results are visible.]</i> <br><b>Shall we begin?</b><br><br></html>");
        instructionsLabel.setForeground(Color.orange);  // Change font color to yellow
        instructionsLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(instructionsLabel);

//Black-and-White GIF Image of meeee:
        JLabel imageIcon = new JLabel(new ImageIcon("JPIXELOPTIMIZED.GIF"));
        panel.add(imageIcon);


//Final set of instructions:
        instructionsLabel = new JLabel("<html> <br><i>Press the button below to roll in the dee-- I mean, the dice. <br> Yes, to roll the dice.<br></i><br></html>");
        instructionsLabel.setForeground(Color.orange);
        instructionsLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(instructionsLabel);

//Display for tracking rounds (1-5) :
        roundLabel = new JLabel("Round: " + round);
        roundLabel.setForeground(Color.yellow);
        roundLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(roundLabel);

//User and PC total displayed in the following code panels:
        JPanel userPanel = new JPanel();
        userPanel.setLayout(new BoxLayout(userPanel, BoxLayout.X_AXIS));
        JLabel userLabel = new JLabel("Your Total: ");
        userPanel.add(userLabel);
        userTotalLabel = new JLabel("0");
        userPanel.add(userTotalLabel);
        panel.add(userPanel);

        JPanel computerPanel = new JPanel();
        computerPanel.setLayout(new BoxLayout(computerPanel, BoxLayout.X_AXIS));
        JLabel computerLabel = new JLabel("Conscience's Total: ");
        computerPanel.add(computerLabel);
        computerTotalLabel = new JLabel("0");
        computerPanel.add(computerTotalLabel);
        panel.add(computerPanel);

//Button for “tossing the dice”:
        rollButton = new JButton("Roll the Dice");
        rollButton.addActionListener(this);
        rollButton.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(rollButton);

//resultLabel function for displaying the result:
        resultLabel = new JLabel("");
        resultLabel.setForeground(Color.yellow);
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(resultLabel);

        add(panel);
        addKeyListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        rollDice();
    }

//Setting the perimeters of the dice:
    private void rollDice() {
        if (round < 5) {
            if (firstRoll) {
                firstRoll = false;
            }

            int userRoll = rollDie();
            int computerRoll = rollDie();

            userTotal += userRoll;
            computerTotal += computerRoll;

            userTotalLabel.setText(Integer.toString(userTotal));
            computerTotalLabel.setText(Integer.toString(computerTotal));

            round++;
            roundLabel.setText("Round: " + round);

            if (round == 5) {
                rollButton.setEnabled(false);
                displayResult();
            }
        }

    }

//Result Options for win, loss, and tie:
    private void displayResult() {
        if (userTotal > computerTotal) {
            resultLabel.setText("<html>Congratulations! You win! <br>Get yourself an ice cream, change your socks or something.</html>");
            resultLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        } else if (userTotal < computerTotal) {
            resultLabel.setText("<html>Your Conscience wins. Better luck next time!<br> <i>Now go look in the mirror and contemplate about your progress in life.</i></html>");
            resultLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        } else {
            resultLabel.setText("<html>It's a tie!~ <br><i>(Now what?)</i> </html>");
            resultLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        }

//Window pop up for choice to play again or close the game:

        int option = JOptionPane.showConfirmDialog(this, "Play another set?", "Play Again", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            round = 0;
            userTotal = 0;
            computerTotal = 0;
            firstRoll = true;
            rollButton.setEnabled(true);
            roundLabel.setText("Round: " + round);
            userTotalLabel.setText("0");
            computerTotalLabel.setText("0");
            resultLabel.setText("");
            titleLabel.setText("WELCOME TO JP SIMON's DICE GAME~");
        } else {
            System.exit(0);
        }
    }

//More dice limit perimeters for randomized results
    private int rollDie() {
        return random.nextInt(6) + 1;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JPOggIndice diceGame = new JPOggIndice();
            diceGame.setVisible(true);
        });
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
//END OF CODE_ J.P. SIMON_2023

