package helper;
import java.io.IOException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Helper {
	public static void showoption()
	{
		System.out.println();
		System.out.println("1.  Add Expense");
		System.out.println("2.  View All Expenses");
		System.out.println("3.  View Total Expense Amount");
		System.out.println("4.  Filter All Expenses By Ctegory");
		System.out.println("5.  Get Expenses for a Specific Category");
		System.out.println("6.  View monthly expense: ");
		System.out.println("7.  Exit");
		System.out.println();
	}
	
	public static void showCategory()
	{
		System.out.println("1.Food");
		System.out.println("2.Travel");
		System.out.println("3.Shopping");
		System.out.println("4.Bills");
		System.out.println("5.Others");
	}
	
	public static int takeValidInt(Scanner sc,String msg)
	{
		while(true)
		{
			try {
				System.out.println(msg);
				return sc.nextInt();
			}catch(InputMismatchException e)
			{
				System.out.println("❌ Invalid input! Please enter a number.");
				sc.nextLine();
			}
		}
	}
	public static String takeString(Scanner sc, String msg) {
        System.out.println(msg);
        return sc.nextLine();
    }

}
