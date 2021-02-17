import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFieldControlPanel extends JPanel {
    //Fields
    private HangmanModel hangman;
    private JTextField textField;

    //Constructor
    public TextFieldControlPanel(HangmanModel hangman, JTextField textField){
        this.hangman = hangman;
        this.textField = textField;
        this.textField.setColumns(20);
        this.textField.addActionListener(new TextFieldListener());
        this.add(textField);
    }

    //Inner Class
    private class TextFieldListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == textField){
                String text = textField.getText();
                for(int i = 0; i < text.length(); i++){
                    hangman.tryThis(text.charAt(i));
                }
                textField.setText("");
            }
        }
    }
}
