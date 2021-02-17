import cs102.Hangman;

public class HangmanLetterButtonControls extends LetterButtonControls implements IHangmanView {
    //Fields

    //Constructor
    public HangmanLetterButtonControls(String letters){
        super(letters,13,2);
    }

    public HangmanLetterButtonControls(String letters, int rows, int columns){
        super(letters,rows,columns);
    }

    public void updateView(Hangman hangman){
        if(!hangman.isGameOver())
            super.setDisabled(hangman.getUsedLetters());
    }
}
