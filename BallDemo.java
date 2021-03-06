import java.awt.Color;
import java.util.*;
/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce(int n)
    {

        Random radioAleatorio = new Random();
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        // crate and show the balls
        ArrayList<BouncingBall> balls = new ArrayList <>();
        for(int i= 0; i < n; i++){
            int diametro = radioAleatorio.nextInt(50) + radioAleatorio.nextInt(50); 
            int posicionX = radioAleatorio.nextInt(200);
            int posicionY = radioAleatorio.nextInt(200);
            Color colorRandom = new Color(radioAleatorio.nextInt(255), radioAleatorio.nextInt(255), radioAleatorio.nextInt(255));
            balls.add( new BouncingBall(posicionX, posicionY, diametro, colorRandom, ground, myCanvas));
            balls.get(i).draw();
        }

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            for(int i= 0; i < n; i++){
                balls.get(i).move();
                // stop once ball has travelled a certain distance on x axis
           
                 if(balls.get(i).getXPosition() >= 550 ) {
                    finished = true;
                }
            }
            }

        }
    }

