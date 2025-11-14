package main;
import java.time.LocalDate;
import java.util.*;

import exceptions.ExceptionHandler;
import exceptions.InvalidAmountException;
import exceptions.InvalidCategoryException;
import helper.Helper;
import service.ExpenseManager;
import validator.Validator;
import model.Category;

public class main {


	public static void main(String[] args) {
	
		System.out.println("---------Expense Manager------------");
		ExpenseManager manager=new ExpenseManager();
		System.out.println("Loading previous data......");
		manager.loadFromFile();
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			Helper.showoption();
			int choice=Helper.takeValidInt(sc,"Enter your choice");
			sc.nextLine();
			switch(choice)
			{
			  
			case 1:
				try {
					int amount=Helper.takeValidInt(sc,"Enter expense amount: ");
					Validator.validateAmount(amount);                                 //for invalid Int value
					sc.nextLine();
					
					String description=Helper.takeString(sc, "Enter description");
					Validator.validateDescription(description);
					
					Helper.showCategory();//show all the category
					int cat=Helper.takeValidInt(sc,"Select category");
                    Validator.validateCategory(cat);                                  //for invalid int value
					Category category=Category.values()[cat-1];
					sc.nextLine();
					
					String date1=Helper.takeString(sc, "Enter date:YYYY-MM-DD format");
					LocalDate date=Validator.validateAndParseDate(date1);
					
					manager.addexpense(amount, category, description,date);
					
				}catch (Exception e){ 
				   ExceptionHandler.handle(e); 
				 }
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
				try {
					Helper.showCategory();
					int c=Helper.takeValidInt(sc,"Choose category from above list: ");
					Validator.validateCategory(c);
					manager.getExpenseFilterCategory(Category.values()[c-1]);
				} catch (Exception e) {
					ExceptionHandler.handle(e);
				}
				break;
				
			case 6:
				try {
					int year=Helper.takeValidInt(sc, "Enter year(yyyy): ");
					Validator.validateYear(year);
					int month=Helper.takeValidInt(sc, "Enter month(MM) :");
					Validator.validateMonth(month);
					manager.viewMonthlyExpense(year, month);
				} catch (Exception e) {
					ExceptionHandler.handle(e);
				}
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
