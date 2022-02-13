/*
CO225 - PROJECT 1
E/17/058
DEVINDI G.A.I 
*/

/*
________________________________________________________________
A Canvas to plot the image on the GUI created using JFrame
_______________________________________________________________
*/

//import libraries
import javax.swing.JPanel;
import java.awt.*;

//declaration of the Canvas class as public.
public class Canvas extends JPanel {
        //declaration of the WIDTH and HEIGHT of the canvas. Obtain the values from the GUI.
        //the variables are used only within the class and they cannot be changed(final).
        private final int WIDTH = SetGUI.WIDTH;
        private final int HEIGHT = SetGUI.HEIGHT;
     
       
        //override the methods in the parent class JPanel to get the canvas and draw the buffered image on it
        @Override
        public Dimension getPreferredSize(){
            return new Dimension(WIDTH,HEIGHT);
        }
        @Override
        public void paintComponent(Graphics drawobj){
            super.paintComponent(drawobj);
            drawobj.drawImage(Model.fimage,0,0,null);
        }
}

