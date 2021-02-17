import cs102.Hangman;

import javax.swing.*;
import java.awt.*;

public class GallowsHangmanView extends JPanel implements IHangmanView {
    //Fields
    private HangmanModel hangmanModel;
    boolean[] incorrectTries;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 600;

    //Constructor
    public GallowsHangmanView(HangmanModel hangmanModel){
        this.hangmanModel = hangmanModel;
        this.setPreferredSize(new Dimension(400,600));
        this.setBackground(Color.CYAN);
        this.incorrectTries = new boolean[6];
    }

    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);

        //Gallows
        graphics.setColor(Color.BLACK);
        graphics.fillRect((int)(HEIGHT/20),(int)(HEIGHT / 1.5),(int)(WIDTH/2),(int)(HEIGHT/20));
        graphics.fillRect((int)(HEIGHT/10),(int)(HEIGHT / 3),(int)(HEIGHT / 40),(int)(HEIGHT/3));
        graphics.fillRect((int)(HEIGHT/10 + HEIGHT/40),(int)(HEIGHT/3),(int)(WIDTH/4),(int)(HEIGHT/40));
        graphics.drawLine((int)(HEIGHT/10 + HEIGHT/40 + WIDTH/4 - 2),(int)(HEIGHT/3 + HEIGHT/40),(int)(HEIGHT/10 + HEIGHT/40 + WIDTH/4 - 2),(int)(HEIGHT/3 + HEIGHT/40 + HEIGHT/20));

        for(int i = 0; i < hangmanModel.getNumOfIncorrectTries(); i++){
            incorrectTries[i] = true;
        }
        //Head
        if(incorrectTries[0]){
            int radius = (int) (HEIGHT/27);
            int x = (int)(HEIGHT/10 + HEIGHT/40 + WIDTH/4 - 2) - radius;
            int y = (int)(HEIGHT/3 + HEIGHT/40 + HEIGHT/20);
            graphics.drawOval(x,y,radius*2,radius*2);
        }

        //Body
        if(incorrectTries[1]) {
            graphics.drawLine((int) (HEIGHT / 10 + HEIGHT / 40 + WIDTH / 4 - 2), (int) (HEIGHT / 3 + HEIGHT / 40 + HEIGHT / 20) + 2 * (int) (HEIGHT / 27), (int) (HEIGHT / 10 + HEIGHT / 40 + WIDTH / 4 - 2), (int) (HEIGHT / 3 + HEIGHT / 40 + HEIGHT / 20) + 2 * (int) (HEIGHT / 27) + (int) (HEIGHT / 10));
        }
        //Leg1
        if(incorrectTries[2]){
            int x1 = (int)(HEIGHT/10 + HEIGHT/40 + WIDTH/4 - 2);
            int y1 = (int)(HEIGHT/3 + HEIGHT/40 + HEIGHT/20) + 2*(int) (HEIGHT/27) + (int)(HEIGHT/10);
            graphics.drawLine(x1,y1,x1 - (int) (HEIGHT/27 * 1.5), y1 + (int) (HEIGHT/27 * 1.5));
        }

        //Leg2
        if(incorrectTries[3]){
            int x1 = (int)(HEIGHT/10 + HEIGHT/40 + WIDTH/4 - 2);
            int y1 = (int)(HEIGHT/3 + HEIGHT/40 + HEIGHT/20) + 2*(int) (HEIGHT/27) + (int)(HEIGHT/10);
            graphics.drawLine(x1,y1,x1 + (int) (HEIGHT/27 * 1.5), y1 + (int) (HEIGHT/27 * 1.5));
        }

        //Arm1
        if(incorrectTries[4]){
            int x1 = (int)(HEIGHT/10 + HEIGHT/40 + WIDTH/4 - 2);
            int y1 =  (int)(HEIGHT/3 + HEIGHT/40 + HEIGHT/20) + 2*(int) (HEIGHT/27) + 5;
            graphics.drawLine(x1,y1,x1-(int) (HEIGHT/27), y1 + (int) (HEIGHT/27) );
        }

        //Arm2
        if(incorrectTries[5]){
            int x1 = (int)(HEIGHT/10 + HEIGHT/40 + WIDTH/4 - 2);
            int y1 =  (int)(HEIGHT/3 + HEIGHT/40 + HEIGHT/20) + 2*(int) (HEIGHT/27) + 5;
            graphics.drawLine(x1,y1,x1 + (int) (HEIGHT/27), y1 + (int) (HEIGHT/27) );
        }

        repaint();

        for(int i = 0; i < incorrectTries.length; i++){
            incorrectTries[i] = false;
        }
    }
    public void updateView(Hangman hangman){
        this.repaint();
    }
}
