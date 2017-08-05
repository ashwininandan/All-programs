import java.util.Scanner;


public class FibonacciSeries {
	private static Scanner sc;
	public static void main(String[] args){
		int i,n,FirstTerm=0,SecondTerm=1,NextTerm;//declaring and initialising the variables
		try{    //To enclose the code that may throw exception
		sc = new Scanner(System.in); //user input
		System.out.println("enter n:");//To enter no of terms
		n=sc.nextInt();//retrieves the user inputed value and stores in n
		System.out.print(FirstTerm+","+SecondTerm);//to print first and second term
			for(i=2;i<n;i++)
			{
			NextTerm=FirstTerm+SecondTerm;//ads the firstterm and secondterm and places in nextterm
			System.out.print(","+NextTerm);//prints the nextterm
			FirstTerm=SecondTerm;//puts the value of the secondterm in firstterm
			SecondTerm=NextTerm;//puts the value of nextterm in secondterm
			}	
		}
		catch(Exception e){//use to handle the exception
			System.out.println("Im programmed just to enter digits...");//error message for wrong user input
			System.exit(0);
		}
		}
	}

