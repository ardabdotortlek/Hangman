import java.awt.*;
import cs102.*;

import javax.swing.*;

/**
 * GUIHangman - GUI based MVC test for cs102 Hangman & IHangmanSetup
 *
 * @author David
 * @version 1.00 2013/4/7
 */

public class GUIHangman
{
	public GUIHangman()
	{
    	System.out.println( "Start of GUIHangman\n");

		HangmanModel		hangman;
		IHangmanSetup		basicSetup;
		ConsoleHangmanView	consoleView;
		TextFieldControlPanel textFieldControlPanel;
		NewGameButtonControl buttonControl;
		LabelsHangmanView labelsHangmanView;
		GallowsHangmanView gallowsHangmanView;
		HangmanLetterButtonControls buttonControls;

		basicSetup = new BasicSetup();
		hangman = new HangmanModel( basicSetup);

		consoleView = new ConsoleHangmanView();
		hangman.addView( consoleView);

		textFieldControlPanel = new TextFieldControlPanel(hangman,new JTextField());
		buttonControls = new HangmanLetterButtonControls(hangman.getAllLetters(),13,2);
		buttonControl = new NewGameButtonControl(hangman,buttonControls);
		labelsHangmanView = new LabelsHangmanView(hangman);
		gallowsHangmanView = new GallowsHangmanView(hangman);
		buttonControls.addActionListener(new HangmanLetterButtonController(hangman,buttonControls));
		hangman.addView(labelsHangmanView);
		hangman.addView(gallowsHangmanView);
		hangman.addView(buttonControl);
		hangman.addView(buttonControls);

		new SimpleJFrame( "GUIHangman", 	// title
							new GallowsHangmanView(hangman),			// center
							textFieldControlPanel, buttonControl,		// north, south
							buttonControls, labelsHangmanView );	// east, west

		// this is an infinite loop reading from the console... not clever!
		ConsoleControl.controlFor( hangman);
	}

	public static void main( String[] args)
	{

		new GUIHangman();

//		// This is the approved way to initialise GUIs
//		// but won't work with the ConsoleControl as is!
//		// --------------------------------------------
//		SwingUtilities.invokeLater(
//			new Runnable() {
//			    public void run() {
//	        		new GUIHangman();
//	        		new GUIHangman();
//	    		}
//			});
	}

} // end of class GUIHangman
