import java.io.*;
 
public class Program {
     
    public static void main(String[] args){
        try {
            FileInputStream fin = new FileInputStream("input.txt");  
            DataInputStream din = new DataInputStream(fin);  
            BufferedReader br = new BufferedReader(new InputStreamReader(din));  
            String line;
            char c;
            int i=0;
             
            while ((line = br.readLine()) != null) {
                    while (i<line.length()){
                        c=line.charAt(i);
                        if (Character.isUpperCase(c)==true) {
                            while (c != ' '){
                                System.out.print(c+"-");
                                i++;
                                c=line.charAt(i);
                                System.out.print(i +" ");
                            }
                          System.out.println();
                            i++;
                            
                        }
                        if (Character.isDigit(c)==true) {
                            while (c != ' '){
                                System.out.print(c+"-");
                                i++;
                                c=line.charAt(i);
                                System.out.print(i+" ");
                            }
                            System.out.println();
                            i++;
                            
                        }
                        else {
                            while (c != ' '){
                                i++;
                                c=line.charAt(i);
                            }
                            i++;
                        }
                    }
            }
            din.close();
            } catch (Exception e) {
            	System.out.println("input file doesnot contain upper case and digits");
            	
            }  
    }
}
            
