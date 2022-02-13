/*
CO225 - PROJECT 1
E/17/058
DEVINDI G.A.I 
*/

/*
______________________________________________________________________
Julia extention of the  Model in the MVC structure (Inheritance)
______________________________________________________________________
*/

//Declaration of the Julia class
public class Julia extends Model{
    //declare the default real and imaginary values for the constant C value
    final static double  CONSTR = -0.4;
    final static double CONSTI = 0.6;
    
    /*
    Declaration of 2 constructors depending on the number of arguments given by user.(0,3)
    Each constructor calls the same constructor in the super class but the values passed are different 
    depending on whether the user has given a constant for c or not
    (Constructor overloading)
    */

    //Constructor 1 : User hasn't given a constant value
    public Julia(String name) throws Exception {
        super(name,CONSTR,CONSTI,1000);
        
    }

    //Constructor 2 : User has given a constant value
    public Julia(String name,double cr,double ci,int iter) throws Exception {
        super(name,cr,ci,iter);
    }
   
    public static int checkC(double c_r, double c_i){
        /*
            c= constr + i consti
            z = c_r + i c_i
            zn = z*z + c =  (z_r + i z_i)(z_r + i z_i) + c
            zn_r  = z_r*z_r - z_i * z_i + c_r
            zn_i = z_r*z_i*2 + c_i

            if sqrt(zn_r*zn_r + zn_i*zn_i)>2 --> c is not in Julia set
            --> zn_r*zn_r + zn_i*zn_i > 4 --> c is not in Julia set
        */
        
        double z_r = c_r;
        double z_i = c_i;
        int n = 0;
      
        while(z_r*z_r + z_i*z_i <=4.0){
            double z_rold = z_r;
            z_r =  z_r*z_r - z_i * z_i + constr;
            z_i =  z_rold*z_i*2 + consti;

            //point in Julia set
            if(n >= iter){
                return iter;
            }
           
            n++;
        }
        //z0 is not in Julia set
        return n;
    }
    
} 