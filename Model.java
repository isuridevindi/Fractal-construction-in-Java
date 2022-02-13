/*
CO225 - PROJECT 1
E/17/058
DEVINDI G.A.I 
*/

/*
______________________________________________________________________
The Model in the MVC structure
Impelements the basic structure to compute the Mandelbrot or Julia set
______________________________________________________________________
*/

//import libraries
import java.awt.image.*;
import java.io.File;
import javax.imageio.ImageIO;

//public class Model which extends Threads
public class Model extends Thread {

    //declare static final variables for default values
    static final int MAX_ITER = 1000; 
    static final double TOP_LEFT_X = -1.0;
    static final double TOP_RIGHT_X = 1.0;
    static final double TOP_LEFT_Y = 1.0;
    static final double BOTTOM_LEFT_Y = -1.0;

    //static variables 
    static BufferedImage fimage; //to store the image
    static SetGUI gui; //to store the GUI
    static Compute [] threads = new Compute[15]; //array of threads to calculations
    //variables to store the iteration count, axes limits and constant values of c(for Julia set)
    static int iter = MAX_ITER; 
    static double topLeftX = TOP_LEFT_X;
    static double topRightX = TOP_RIGHT_X;
    static double topLeftY = TOP_LEFT_Y;
    static double bottomY = BOTTOM_LEFT_Y;
    static double constr;
    static double consti;

    //variables to be used only inside the class
    private int WIDTH = SetGUI.WIDTH;
    private int HEIGHT = SetGUI.HEIGHT;
    private String name;

    /*Multiple contructors are called depending on the arguments user input (Method overloading Polymorphism is used)
        Setting the name of the required set (Mandelbrot or julia) and computing the set 
        are the main functions of every constructor.
        The variables in the class are assigned with the user inputs depending on the arguments given by the user
    */
    
    //Constructor 1
    //Invoke if only the set name is given (Used in Mandelbrot)
    public Model(String name) throws Exception {
        this.name=name;
        updateFractal();
     
    }

    //Constructor 2
    //Invoke if the set name,constant of Julia set and iterations are given (Used in Julia)

    public Model(String name, double cr, double ci, int iter) throws Exception {
        constr = cr;
        consti = ci;
        this.iter = iter;
        this.name=name;
        updateFractal();
    }

    //Constructor 3
    //Invoke if the set name,limits of real and imaginary axes and number of iterations are given (Used in Mandelbrot)
    public Model(String name, double real1, double real2, double im1, double im2, int iter) throws Exception {

        //assign the minimum and maximum of the given values to the relevant variable--> user can input the min and max in any order they want
        if (real1 < real2) {
            topLeftX = real1;
            topRightX = real2;
        } else {
            topLeftX = real2;
            topRightX = real1;
        }
        if (im1 < im2) {
            topLeftY = im2;
            bottomY = im1;
        } else {
            topLeftY = im1;
            bottomY = im2;
        }
        this.iter = iter;
        this.name=name;
        updateFractal();
       
    }

    //Constructor 4
    //Invoke if the set name,limits of real and imaginary axes  are given (Used in Mandelbrot)
    public Model(String name, double real1, double real2, double im1, double im2) throws Exception {
        if (real1 < real2) {
            topLeftX = real1;
            topRightX = real2;
        } else {
            topLeftX = real2;
            topRightX = real1;
        }
        if (im1 < im2) {
            topLeftY = im2;
            bottomY = im1;
        } else {
            topLeftY = im1;
            bottomY = im2;
        }
        this.name=name;
        updateFractal();
    }

    //Method used to colour the buffered image by checking the values and performing the relevant calculations

    public void updateFractal() throws Exception {
        //create a buffered image to draw the pattern
        fimage  =  new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
        //variable to count the time taken to complete task using threads
        long startTime = System.currentTimeMillis();

        //Invoke the run method in threads (the threads are in class Compute)
        for (int t=0; t<threads.length;t++){
            threads[t] = new Compute(t);
            threads[t].start();
        }
        //Synchronize the threads
        for(int t=0;t<threads.length;t++){
            threads[t].join();
        } 
        
        //print the time taken to complete the task using threads when the computations are completed.
        if(Thread.activeCount()==1){
            long endTime = System.currentTimeMillis();
            System.out.println("Calculation completed in " + (endTime - startTime) + " milliseconds");
        }
        
        //Store a copy of the image as Fractals.png in the current folder
        ImageIO.write(fimage,"PNG",new File("Fractals.png"));
       //Display the created image on screen
        gui = new SetGUI(name);
        
        
    }
       
    //Skeleton of the Method to check whether a value is in the Mandelbrot or Julia set
    //Overridden individually in the Mandelbrot and Julia classes
    public static int checkC(double c_r, double c_i){
        double z_r = 0.0;
        double z_i = 0.0;
        int n = 0;
        return n;
    }
}

