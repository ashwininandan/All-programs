/**
 * 
 */

/**
 * @author win 10
 *
 */
import java.io.*;
public class FileHandling{

   public static void main(String args[]) throws IOException {  
      FileInputStream in = null;//declaration and initialisation to null 
      FileOutputStream out = null;

      try {// //To enclose the code that may throw exception
         in = new FileInputStream("input.txt");//to read the bytes of input file and place in in 
         out = new FileOutputStream("D:/output.txt");//to copy the input in output 
         
         int c;//intialize and declare
         while ((c = in.read()) != -1) {//while not equall to end of file
            out.write(c);//copy c to out file
            System.out.print((char) c);   //type conversion from int to char
         }
      }
      catch(Exception e){//use to handle the exception
    	  System.out.println("input file not found first create a file");
      }
      finally {//when there is no exception it will not execute catch block directly it executes finally block
         if (in != null) {
            in.close();
         }
         if (out != null) {
            out.close();
         }
      }
   
   }
}
