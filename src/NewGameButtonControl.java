import cs102.Hangman;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGameButtonControl extends JButton implements IHangmanView {
    //Fields
    HangmanModel hangmanModel;
    HangmanLetterButtonControls buttonControls;

    //Constructor
    public NewGameButtonControl(HangmanModel hangmanModel, HangmanLetterButtonControls buttonControls){
        this.buttonControls = buttonControls;
        this.hangmanModel = hangmanModel;
        this.setText("New Game");
        this.addActionListener(new ButtonListener());
        this.setEnabled(false);
    }

    public void updateView(Hangman hangman){
        if(hangman.isGameOver())
            this.setEnabled(true);
    }

    //Inner Class
    private class ButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            hangmanModel.initNewGame();
            NewGameButtonControl.this.setEnabled(false);
            buttonControls.setEnabledAll(true);
        }
    }
}
