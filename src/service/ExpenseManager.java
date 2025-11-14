package service;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import model.Category;
import java.util.Map;

import model.Expense;

public class ExpenseManager {
	List<Expense> list;
	public ExpenseManager()
	{
		list=new ArrayList<>();
	}
	public void addexpense(double amount,Category category,String description,LocalDate date) //add new expense to the list
	{
		list.add(new Expense(amount,category,description,date));
	}
	public void viewAllExpense()  //view all the expenses details in list
	{
		if(list.isEmpty())
		{
			System.out.println("No expenses yet");
			return;
		}
		System.out.println("Category      |Amount      |Description");
		for(Expense e:list)
		{
			System.out.println(e.toString());
		}
	}
	public void getExpenseFilterCategory(Category category)   //get all the espenses based on user input category
	{
		boolean found=false;
		for(Expense e:list)
		{
			if(e.getCategory()==category)
			{
				System.out.println(e);
				found=true;
			}
		}
		if(found==false)
			System.out.println("No expenses on this "+category);
	}
	public void getTotalExpense()  //get total expense
	{
		double total=0;
		for(Expense e:list)
			total+=e.getAmount();
		System.out.println(total);
	}
	public void getExpenseByCategory() //get category wise total expense| Category name ----------Expense of that category
	{
		Map<Category,Double> map=new HashMap<>();
		for(Expense e:list)
		{
			Category cat=e.getCategory();
			double amt=e.getAmount();
			if(map.containsKey(cat))
			map.put(cat,map.get(cat)+amt );
			else
				map.put(cat,amt);
		}
		System.out.println("Category     |Amount");
		for(Map.Entry<Category,Double> entry:map.entrySet())
		{
			System.out.println(entry.getKey()+"     |"+entry.getValue());
		}
	}
	public void loadToFile()
	{
		try {
			FileOutputStream file=new FileOutputStream("Entry.txt");
			OutputStreamWriter bridge=new OutputStreamWriter(file);
			BufferedWriter bf=new BufferedWriter(bridge);
			for(Expense e:list)
			{
				String input=e.toString();
				bf.write(input);
				bf.newLine();
				
			}
			bf.close();
			bridge.close();
			file.close();
			
		}
		catch(Exception x)
		{
			System.out.println("Error saving data: " + x.getMessage());
		}
	}
	public void loadFromFile()                                             
	{
		try {
		FileInputStream file=new FileInputStream("Entry.txt");
		InputStreamReader bridge=new InputStreamReader(file);
		BufferedReader bf=new BufferedReader(bridge);
		String input=null;
		int i=0;
		while((input=bf.readLine())!=null)
		{
			i++;
			try {
				String a[]=input.split("\\|");
				Category cat=Category.valueOf(a[1]);
				LocalDate date=LocalDate.parse(a[3]);
				list.add(new Expense(Double.parseDouble(a[0]),cat,a[2],date));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("line number "+i+" is corrupt");
			}
		}
		bf.close();
		bridge.close();
		file.close();
		}catch(FileNotFoundException e)
		{
			System.out.println("No previous data found,start freash");
		}catch(IOException e)
		{
			System.out.println("error file reading"+e.getMessage());
		}
		
	}
	public void viewMonthlyExpense(int year,int month)
	{
		double sum=0;
		for(Expense e:list)
		{
			if(e.getDate().getYear()==year&&e.getDate().getMonthValue()==month)
			{
				sum=sum+e.getAmount();
			}
		}
		System.out.println("Total expenses of this month is "+sum);
	}

}
