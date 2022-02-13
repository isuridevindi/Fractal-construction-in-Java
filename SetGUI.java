/*
CO225 - PROJECT 1
E/17/058
DEVINDI G.A.I 
*/

/*
________________________________________________________________
The GUI to display the image
**
SetGUI + Canvas implements the view in the MVC structure
_______________________________________________________________
*/

//import the libraries
import javax.swing.JFrame;
import java.awt.*;


//Declaration of SetGUI class as public
public class SetGUI extends JFrame {
    //Set the WIDTH and HEIGHT of the GUI
    //These vars cannot be changed(final) and can be used outside the class 
    static final int WIDTH = 800;
    static final int HEIGHT = 800;
    //create a canvas variable to implement the canvas on the frame
    public static Canvas canvas;

    //Constructor
    //Set the name and size of the GUI and implement the canvas on top of the frame
    public  SetGUI(String name){
        this.setTitle(name);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH,HEIGHT);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        addCanvas();
    }

    //method to add the canvas to the GUI
    private void addCanvas(){
        canvas =  new Canvas();
        canvas.setVisible(true);
        this.add(canvas,BorderLayout.CENTER);
        
        
    }

}
