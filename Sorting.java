/**
 * 
 */

/**
 * @author win 10
 *
 */

import java.util.Scanner;
public class Sorting
{
    private static Scanner s;
	private static Scanner s1;

	public static void main(String[] args) 
    {
        int n;//declaration n
        String temp;//declaring a variable of datatype string
        try{ //To enclose the code that may throw exception
        s = new Scanner(System.in);//user input
        System.out.print("Enter number of names you want to enter:");//specify the number of names to enter
        n = s.nextInt();//to store the entered value in n
        String names[] = new String[n];//Creation of Arrays with size n
       s1 = new Scanner(System.in);//user input
        System.out.println("Enter all the names:");//enters the names to be sorted
        for(int i = 0; i < n; i++)
        {
            names[i] = s1.nextLine();//to place all the entered names in array of names[i]
        }
        for (int i = 0; i <n; i++) //i points to string i.e in location [i]
        {
            for (int j = i + 1; j <n; j++) //j points next string  in location [j]
            {
                if (names[i].compareTo(names[j])>0) //compareTo function compares i name with j name if its true returns 1 or -1  
               {
                    temp = names[i];
              
                    names[i] = names[j];
                    names[j] = temp;
                }
            }
        }
        System.out.print("Names in Sorted Order:");
        System.out.print(names[0]);
        for (int i = 1; i < n; i++) 
        {
            System.out.print(","+names[i]);
        }
        }
        catch(Exception e)//use to handle the exception
        {
        	System.out.println("enter only digits");
        	System.exit(0);
        }
    }
}
