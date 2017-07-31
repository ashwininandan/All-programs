

import java.util.Scanner;


public class Fibonacci {
	private static Scanner sc;

	public static void main(String[] args){
		int i,n,FirstTerm=0,SecondTerm=1,NextTerm;
		try{
			
		
		sc = new Scanner(System.in);
		System.out.println("enter n:");
		n=sc.nextInt();
		System.out.print(FirstTerm+","+SecondTerm);
		
			for(i=2;i<n;i++)
			{
			
			NextTerm=FirstTerm+SecondTerm;
			System.out.print(","+NextTerm);
			FirstTerm=SecondTerm;
			SecondTerm=NextTerm;
			}	
		}
		catch(Exception e){
			System.out.println("Im programmed just to enter digits...");
			System.exit(0);
		}
		
		
		}
		
		
	}

