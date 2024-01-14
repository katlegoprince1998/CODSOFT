import javax.swing.*;
import java.util.Random;

public class GuessGame extends JFrame{
    private JButton btn;
    private JTextField userInput;
    private JLabel inputInstruction;
    private JLabel attempts;
    private JLabel score;
    private JPanel myPanel;
    private JLabel attemptNumber;
    private JLabel scoreNumber;
    private JLabel instructionLabel;
    private int rounds;

    private static final int width = 400;
    private static final int height = 550;
    Random random = new Random();
    private int compNum = random.nextInt(10) + 1;


    public GuessGame(){
        this.setTitle("Guess Number Game");
        this.setContentPane(this.myPanel);
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.attemptNumber.setText("5");
        this.scoreNumber.setText("0");
        this.rounds = 1;

        btn.addActionListener(e -> {
            String userNum = this.userInput.getText();
            int convertedNum = Integer.parseInt(userNum);
            String attempt = attemptNumber.getText();
            int newAttempt = Integer.parseInt(attempt);
            String score = this.scoreNumber.getText();
             int convertedScore = Integer.parseInt(score);

            if (newAttempt > 1){
                if(convertedNum == compNum){
                    convertedScore += 10;
                    this.scoreNumber.setText(String.valueOf(convertedScore));
                    JOptionPane.showMessageDialog(
                            GuessGame.this,
                            "Congratulations! You WON ROUND " + this.rounds,
                            "You Won!",
                            JOptionPane.INFORMATION_MESSAGE);
                    int dialogResult = JOptionPane.showConfirmDialog(
                            GuessGame.this,
                            "Do you want to play again?",
                            "Congratulations",
                            JOptionPane.YES_NO_OPTION);

                    if (dialogResult == JOptionPane.YES_OPTION) {

                        this.userInput.setText("");
                        this.compNum = random.nextInt(10) + 1;
                        this.instructionLabel.setText("");
                        rounds++;

                    } else {

                        dispose();
                    }
                }else if(convertedNum < compNum){
                    convertedScore -= 5;
                    this.scoreNumber.setText(String.valueOf(convertedScore));
                    newAttempt -= 1;
                    this.instructionLabel.setText("TOO LOW!!");
                    this.attemptNumber.setText(String.valueOf(newAttempt));

                } else {
                    convertedScore -= 5;
                    this.scoreNumber.setText(String.valueOf(convertedScore));
                    newAttempt -= 1;
                    this.instructionLabel.setText("TOO HIGH!!");
                    this.attemptNumber.setText(String.valueOf(newAttempt));
                }
            }else{
                JOptionPane.showMessageDialog(GuessGame.this, "YOU LOST");
                int dialogResult = JOptionPane.showConfirmDialog(
                        GuessGame.this,
                        "You Lost! Do you want to play again?",
                        "Game Over",
                        JOptionPane.YES_NO_OPTION);

                if (dialogResult == JOptionPane.YES_OPTION) {
                    // Reset the game
                    this.userInput.setText("");
                    this.attemptNumber.setText("5");
                    this.scoreNumber.setText("0");
                    this.compNum = random.nextInt(10) + 1;
                    this.instructionLabel.setText("");
                    rounds++;

                } else {

                    dispose();
                }
            }


        });
    }
}
