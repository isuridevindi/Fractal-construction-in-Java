/*
CO225 - PROJECT 1
E/17/058
DEVINDI G.A.I 
*/

/*
_____________________________________________________________________________
Supporting class for the Model in the MVC structure
Impelements the calculation and assigning colours to the points on the image
_____________________________________________________________________________
*/

//import libraries

import java.awt.*;

//Declaration of class Compute which extends the class Thread
public class Compute extends Thread {
    //variables to be used inside the class
    private static int WIDTH = SetGUI.WIDTH;
    private static int HEIGHT = SetGUI.HEIGHT;
    private static int  iter = Model.iter;
    //Assign the values stored in the Model for calculation purposes
    double topLeftX =Model.topLeftX ;
    double topRightX=Model.topRightX;
    double topLeftY=Model.topLeftY ;
    double bottomY=Model.bottomY ;
    //variable to keep track of the threads
    int threadcount;

    //Constructor
    //When a compute thread object is initialized store the number of that thread (15 Threads are used)
    public Compute(int count){
        threadcount=count;
    }

    //Method which is invoked for Thread.start() call
    public void run(){
        //Depending on the thread number instantiated, assign a region of the 800 pixels  to the thread to perform the calculations 
        int begin = (WIDTH/15)*threadcount;
        int end = (WIDTH/15)*(threadcount+1);

        //For each thread iterate through the pixels in the given region and map the postion to complex plane using 
        //getXPos( ) and getYPos() methods 
        for(int x = begin; x<end ; x++){
            for(int y = 0 ; y<HEIGHT;y++){
                double c_r = getXPos(x);
                double c_i = getYPos(y);
                int n;
                
                /*If the user asks for the mandelbrot set invoke the checkC method in Mandelbrot set
                    else invoke the method in Julia set
                    to calculate the n value at which the given criteria is satisfied
                */
                if (Fractal.setname.equals("MANDELBROT")){
                n = Mandelbrot.checkC(c_r,c_i);
                }
                else{
                    n=Julia.checkC(c_r,c_i);
                }
            
                //Assign a color to the pixel using makeColor() method
                int pixelColor = makeColor(n);
                //Color the relevant pixel in the image
                Model.fimage.setRGB(x, y, pixelColor);

            }
        }
   
    }

    //get the real coordinate of the given pixel on complex plane
    private double getXPos(double x){
        
        return topLeftX + (x/WIDTH)*(topRightX - topLeftX);
    }

    //get the imaginary coordinate of the given pixel on the complex plane
    private double getYPos(double y){
       
        return topLeftY -(y/HEIGHT)*(topLeftY - bottomY);
    }

    //method to assign colours depending on the n value
    public static int makeColor(int n){
      
        //if maximum iterations are used colour point in black
        //get colour according to the n value otherwise
        if(n==iter){
            return Color.BLACK.getRGB();
        }
        return Color.HSBtoRGB((n+1200)/(255f),1,n/(n+6f));
           
    }

}
