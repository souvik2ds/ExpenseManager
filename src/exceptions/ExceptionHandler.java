package exceptions;

/*⭐ What this class does

👉 Checks which type of ccustom exception occurred
👉 Prints clean user-friendly messages
👉 Handles ALL exceptions printing in ONE place
👉 Makes your code maintainable and professional*/
public class ExceptionHandler {

	public static void handle(Exception e) {

        // Custom exceptions
        if (e instanceof InvalidAmountException ||
            e instanceof InvalidCategoryException ||
            e instanceof InvalidDateException) {

            System.out.println("❌ " + e.getMessage());
            return;
        }

        // Any unexpected exception
        System.out.println("❌ Unexpected error: " + e.getMessage());
    }
}
