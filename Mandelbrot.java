/*
CO225 - PROJECT 1
E/17/058
DEVINDI G.A.I 
*/

/*
______________________________________________________________________
Mandelbrot extention of the  Model in the MVC structure (Inheritance)
______________________________________________________________________
*/

//Mandelbrot class declaration
public class Mandelbrot extends Model {

    /*
    Declaration of 3 constructors depending on the number of arguments given by user.(0,4,5)
    Each constructor calls a relevant constructor in the super class
    (Constructor overloading)
    */

    //Constructor 1
    public Mandelbrot(String name) throws Exception {
        super(name);
    }

    //Constructor 2
    public Mandelbrot(String name, double real1, double real2, double im1, double im2, int iter)
            throws Exception {
        super(name,real1,real2,im1,im2,iter);
    }

    //Constructor 3
    public Mandelbrot(String name,double real1,double real2,double im1,double im2) throws Exception {
        super(name,real1,real2,im1,im2);
      
    }


    //Override the checkC method in the Model to get the n value for each C point in canvas  
    public static int checkC(double c_r, double c_i) {

        /* CALCULATION
            c= c_r + i c_i
            z = z_r + i z_i
            zn = z*z + c =  (z_r + i z_i)(z_r + i z_i) + c
            zn_r  = z_r*z_r - z_i * z_i + c_r
            zn_i = z_r*z_i*2 + c_i

            if sqrt(zn_r*zn_r + zn_i*zn_i)>2 --> c is not Mandelbrot
            --> zn_r*zn_r + zn_i*zn_i > 4 --> c is not Mandelbrot
        */
                
        double z_r = 0.0;
        double z_i = 0.0;
        int n = 0;

        while(z_r*z_r + z_i*z_i <=4.0){
            double z_rold = z_r;
            z_r =  z_r*z_r - z_i * z_i + c_r;
            z_i =  z_rold*z_i*2 + c_i;

            //point in mandelbrot
            if(n >= iter){
                return iter;
            }
            n++;
        }
        //c is not in mandelbrot
        return n;
    }
    

}