import java.time.LocalDate;
import java.util.*;

public class main {
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

	public static void main(String[] args) {
		System.out.println("---------Expense Manager------------");
		ExpenseManager manager=new ExpenseManager();
		manager.loadFromFile();
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			showoption();
			System.out.println("Enter Choice: ");
			
			int choice=sc.nextInt();
			sc.nextLine();
			switch(choice)
			{
			  
			case 1:
				System.out.println("Enter expense amount: ");
				int amount=sc.nextInt();
				sc.nextLine();
				System.out.println("Enter description: ");
				String description=sc.nextLine();
				sc.nextLine();
				System.out.println("Select category");
				System.out.println("1.Food");
				System.out.println("2.Travel");
				System.out.println("3.Shopping");
				System.out.println("4.Bills");
				System.out.println("5.Others");
				int cat=sc.nextInt();
				Category category=Category.values()[cat-1];
				sc.nextLine();
				System.out.println("Enter date:YYYY-MM-DD format");
				String date1=sc.nextLine();
				LocalDate date=LocalDate.parse(date1);
				manager.addexpense(amount, category, description,date);
				break;
				
			case 2:
				manager.viewAllExpense();
				break;
				
			case 3:
				manager.getTotalExpense();
				break;
				
			case 4:
				manager.getExpenseByCategory();
				break;
				
			case 5:
				System.out.println("Choose category");
				System.out.println("1. FOOD  2. TRAVEL  3. SHOPPING  4. BILLS  5. OTHER");
				int c=sc.nextInt();
				manager.getExpenseFilterCategory(Category.values()[c-1]);
				break;
				
			case 6:
				System.out.println("Enter year(yyyy): ");
				int year=sc.nextInt();
				System.out.println("Enter month(MM) :");
				int month=sc.nextInt();
				manager.viewMonthlyExpense(year, month);
				break;
			case 7:
				manager.loadToFile();
				System.out.println("👋 Exiting... Have a good day!");
                System.exit(0);
                
				
                
            default:
            	 System.out.println("❌ Invalid choice! Try again.");
			}
		}
		
	}

}
