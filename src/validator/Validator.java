package validator;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import exceptions.InvalidAmountException;
import exceptions.InvalidCategoryException;
import exceptions.InvalidDateException;

/*
Your main class will only call:

Validator.validateAmount(amount);
Validator.validateCategory(cat);
Validator.validateDate(dateStr);
⭐ Quick Summary (one-line each)

Moves validation logic out of main

Makes code clean and readable

Throws custom exceptions

Reusable validation for entire project

Follows proper OOP (SRP)

Easy to change or expand validation rules
*/


public class Validator {
	 // ✅ Validate Amount
    public static void validateAmount(int amount) {
        if (amount < 0) {
            throw new InvalidAmountException("Amount cannot be negative.");
        }
    }

    // ✅ Validate Category
    public static void validateCategory(int cat) {
        if (cat < 1 || cat > 5) {
            throw new InvalidCategoryException("Invalid category selected.");
        }
    }

    // ✅ Validate Date Format and return LocalDate
    public static LocalDate validateAndParseDate(String dateStr) {
        try {
            return LocalDate.parse(dateStr);
        } catch (DateTimeParseException e) {
            throw new InvalidDateException("Invalid date! Use YYYY-MM-DD format.");
        }
    }
    
    public static void validateDescription(String desc) {
        if (desc == null || desc.trim().isEmpty()) {
            throw new InvalidAmountException("Description cannot be empty.");
        }
    }
    
    public static void validateYear(int year) {
        if (year < 1900 || year > 2025) {
            throw new InvalidDateException("Year must be in YYYY format (1900–2015).");
        }
    }

    public static void validateMonth(int month) {
        if (month < 1 || month > 12) {
            throw new InvalidDateException("Month must be between 1 and 12.");
        }
    }
	
}
