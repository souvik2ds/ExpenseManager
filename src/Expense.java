import java.time.LocalDate;

public class Expense {
 private double amount;
 private String description;
 private Category category;
 private LocalDate date;
 public Expense(double amount,Category category,String description,LocalDate date)
 {
	 this.amount=amount;
	 this.category=category;
	 this.description=description;
	 this.date=date;
 }
public double getAmount() {
	return amount;
}
public String getDescription() {
	return description;
}
public Category getCategory() {
	return category;
}

public LocalDate getDate() {
	return date;
}
public void setDate(LocalDate date) {
	this.date = date;
}
@Override
public String toString()
{
	return this.getAmount()+"|"+this.getCategory()+"|"+this.getDescription()+"|"+this.date;
}
}
