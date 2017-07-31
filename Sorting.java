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
        int n;
        String temp;
        try{
        s = new Scanner(System.in);
        System.out.print("Enter number of names you want to enter:");
        n = s.nextInt();
        String names[] = new String[n];
       s1 = new Scanner(System.in);
        System.out.println("Enter all the names:");
        for(int i = 0; i < n; i++)
        {
            names[i] = s1.nextLine();
        }
        for (int i = 0; i <n; i++) 
        {
            for (int j = i + 1; j <n; j++) 
            {
                if (names[i].compareTo(names[j])>0) 
                {
                    temp = names[i];
              
                    names[i] = names[j];
                    names[j] = temp;
                }
            }
        }
        System.out.print("Names in Sorted Order:");
        for (int i = 0; i < n; i++) 
        {
            System.out.print(""+names[i]+"." );
        }
        }
        catch(Exception e)
        {
        	System.out.println("enter only digits");
        	System.exit(0);
        }
    }
}
