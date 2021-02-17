import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HangmanLetterButtonController implements ActionListener {
    //Fields
    HangmanModel hangmanModel;
    LetterButtonControls buttonControls;

    //Constructor
    public HangmanLetterButtonController(HangmanModel hangmanModel,LetterButtonControls buttonControls){
        this.hangmanModel = hangmanModel;
        this.buttonControls = buttonControls;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        char letter = ((JButton) e.getSource()).getText().charAt(0);
        hangmanModel.tryThis(letter);
        if(!hangmanModel.isGameOver())
            ((JButton) e.getSource()).setEnabled(false);
    }
}
