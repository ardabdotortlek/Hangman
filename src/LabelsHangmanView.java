import cs102.Hangman;

import javax.swing.*;
import java.awt.*;

public class LabelsHangmanView extends JPanel implements IHangmanView {
    //Fields
    private JLabel numOfIncorrectTries;
    private JLabel knownSoFar;
    private JLabel usedLetters;
    private JLabel stateOfGame;
    private HangmanModel hangmanModel;
    private Font font;

    //Constructor
    public LabelsHangmanView(HangmanModel hangmanModel){
        this.font = new Font("default",Font.ITALIC,20);
        this.hangmanModel = hangmanModel;
        this.numOfIncorrectTries = new JLabel(hangmanModel.getNumOfIncorrectTries() + "");
        this.numOfIncorrectTries.setFont(font);
        this.knownSoFar = new JLabel(hangmanModel.getKnownSoFar() + "");
        this.knownSoFar.setFont(font);
        this.usedLetters = new JLabel(hangmanModel.getUsedLetters() + "");
        this.usedLetters.setFont(font);
        this.stateOfGame = new JLabel("Game goes on");
        this.stateOfGame.setFont(font);
        GridLayout layout = new GridLayout(4,1);
        layout.setVgap(5);
        this.setLayout(layout);
        this.setBackground(Color.RED);
        this.add(numOfIncorrectTries);
        this.add(knownSoFar);
        this.add(usedLetters);
        this.add(stateOfGame);
    }

    public void updateView(Hangman hangmanModel){
        this.numOfIncorrectTries.setText(hangmanModel.getNumOfIncorrectTries() + "");
        this.knownSoFar.setText(hangmanModel.getKnownSoFar() + "");
        this.usedLetters.setText(hangmanModel.getUsedLetters() + "");
        if(hangmanModel.isGameOver()){
            if(hangmanModel.hasLost())
                this.stateOfGame.setText("You have lost!");
            else
                this.stateOfGame.setText("You have won!");
        }
        else
            this.stateOfGame.setText("Game goes on");

    }
}
