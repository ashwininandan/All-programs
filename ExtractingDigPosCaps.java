import java.io.*;
 
public class ExtractingDigPosCaps {
     
    public static void main(String[] args){
        try {
            FileInputStream fin = new FileInputStream("input.txt");//declaration and initialisation to null  
            DataInputStream din = new DataInputStream(fin);  //declaration and initialisation to null 
            BufferedReader br = new BufferedReader(new InputStreamReader(din));//BufferReader is used to read a text from character based input stream decl and intilzn  
            String line;
            char c;
            int i=0;
            while ((line = br.readLine()) != null) {//put the read data in string line
                    while (i<line.length()){//if variable i is less than the length of the string
                        c=line.charAt(i);//returns the index of a character at i
                        if (Character.isUpperCase(c)==true){//returns string that contains uppercase character  
                            while (c != ' '){
                                System.out.print(c+"-");
                                i++;
                                c=line.charAt(i);
                                System.out.print(i +" ");
                            }
                          System.out.println();
                            i++;
                            
                        }
                        if (Character.isDigit(c)==true) {//returns the digits in present in the file
                            while (c != ' '){
                                System.out.print(c+"-");
                                i++;
                                c=line.charAt(i);//returns the index of a character at i
                                System.out.print(i+" ");
                            }
                            System.out.println();
                            i++;
                            
                        }
                        else {
                            while (c != ' '){
                                i++;
                                c=line.charAt(i);//returns the index of a character at i
                            }
                            i++;
                        }
                    }
            }
            din.close();//file close
            } catch (Exception e) {//use to handle the exception
            	
            }  
    }
}
            
