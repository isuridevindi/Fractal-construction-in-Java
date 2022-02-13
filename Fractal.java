/*
CO225 - PROJECT 1
E/17/058
DEVINDI G.A.I 
*/

/*
________________________________________________________________________
Control of the MVC structure.
Invoke the relevant method depending on the control inputs given by user
and display the view
________________________________________________________________________
*/

//Declaration of class Fractal
public class Fractal{
    //declaration of variables to store the name of the set, to instatiate the Mandelbrot or julia objects
    public static String setname;
    static Mandelbrot mandelbrotset;
    static Julia juliaset;

    //
    private static void printError(){
            System.out.println("---------------------------");
            System.out.println("INVALID USAGE OF ARGUEMNTS");
            System.out.println("---------------------------");
            System.out.println ("USAGE:\n");
            System.out.println ("To plot the Mandelbrot Set\n");
            System.out.println ("    $java Fractal Mandelbrot <real axis minimum> <real axis maximum> <imaginary axis minimum> <imaginary axis maximum> <number of iterations per point> \n");
            System.out.println("   **Number of arguments accepted for Mandelbrot set are either 0,4 or 5");
            System.out.println ("To plot the Julia Set\n");
            System.out.println ("    $java Fractal Julia <real part of C> <complex part of C> <number of iterations per point>\n");
            System.out.println("   **Number of arguments accepted for Julia set are either 0 or 3");

    }

    //Main method
    public static void main(String[] args) throws Exception {
       
        //If no args are given print error
    if(args.length == 0 ){
        printError();
    }
    else{
        /*if arguments are given,
            Check whether it's Mandelbrot or Julia and call the relevant constructor in the relevant class
            If the inputs doesn't satisfy conditions print errors
        */
        setname = args[0].toUpperCase();
        if(setname.equals("MANDELBROT")||setname.equals("JULIA")){
            if(setname.equals("MANDELBROT")){
                if(args.length>6 ||( args.length != 1 && args.length !=5 && args.length !=6)){
                    System.out.println("Number of arguments for Mandelbrot set must be either 0,4 or 5");
                    printError();
                }
                else if (args.length ==6){
                    try{
                    mandelbrotset =new Mandelbrot(("CO225 PROJECT :"+setname),Double.parseDouble(args[1]),Double.parseDouble(args[2]),Double.parseDouble(args[3]),Double.parseDouble(args[4]),Integer.parseInt(args[5]) );
                    }
                    catch(NumberFormatException e) {
                        System.out.println("Invalid values given for real or imaginary axis limits");
                    } 
                }
                else if(args.length ==5){
                    try{
                        mandelbrotset = new Mandelbrot(("CO225 PROJECT :"+setname),Double.parseDouble(args[1]),Double.parseDouble(args[2]),Double.parseDouble(args[3]),Double.parseDouble(args[4]));
                    }
                    catch(NumberFormatException e) {
                        System.out.println("Invalid values given for real or imaginary axis limits");
                    }
                }
                else if (args.length ==1){
                    mandelbrotset = new Mandelbrot("CO225 PROJECT :"+setname);
                }
            }
            if(setname.equals("JULIA")){
                if(args.length >4 ||(args.length !=1 && args.length !=4)){
                    System.out.println("Number of arguments for Julia set must be either 0 or 3");
                    printError();
                }
                if (args.length ==1){
                    juliaset= new Julia("CO225 PROJECT :"+setname);
                }
                else if(args.length==4){
                    try{
                    juliaset =  new Julia(("CO225 PROJECT :"+setname),Double.parseDouble(args[1]),Double.parseDouble(args[2]),Integer.parseInt(args[3]));
                    }
                    catch(NumberFormatException e) {
                        System.out.println("Invalid values given for real or imaginary axis limits");
                    }
                }

            }

        }
        else{ 
            System.out.println("Invalid name given for the set name");
            printError();
        }
        
        
    }
   
}

}