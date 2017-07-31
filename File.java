/**
 * 
 */

/**
 * @author win 10
 *
 */
import java.io.*;
public class File{

   public static void main(String args[]) throws IOException {  
      FileInputStream in = null;
      FileOutputStream out = null;

      try {
         in = new FileInputStream("input1.txt");
         out = new FileOutputStream("D:/output.txt");
         
         int c;
         while ((c = in.read()) != -1) {
            out.write(c);
            System.out.print((char) c);    
         }
      }
      catch(Exception e){
    	  System.out.println("input file not found first create a file");
      }
      finally {
         if (in != null) {
            in.close();
         }
         if (out != null) {
            out.close();
         }
      }
   
   }
}
