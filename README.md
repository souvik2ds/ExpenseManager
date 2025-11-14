🌟 Expense Manager (Java • Console App)

A clean, modular, file-based expense tracking system built using
Java, OOP, Exception Handling, Validation Layer, Helper Layer, and Git Versioning.

📌 Overview

This is a fully refactored, production-style Expense Manager project
designed with a multi-layer architecture and strong emphasis on:

✔ Input Validation
✔ Custom Exceptions
✔ Clean User Input Handling
✔ File I/O Operations
✔ Monthly & Category-wise Reports
✔ Professional Package Structure

🚀 Features

➕ Add new expense (amount + category + description + date)

📄 View all expenses

🗂 Category-wise expense filter

📆 Monthly expense summary

💰 Total expense calculation

🔒 Input validation (range, format, datatype)

⚠ Custom exception handling (InvalidAmountException, InvalidCategoryException, etc.)

📁 Persistent file storage using Entry.txt

🔧 Clean separation of logic using packages

🧱 Project Architecture
src/
 ├── main/                  --> main() entry point
 ├── model/                 --> Expense, Category
 ├── service/               --> ExpenseManager (core business logic)
 ├── helper/                --> Helper (safe input handling)
 ├── validator/             --> Validator (business rule validation)
 ├── exceptions/            --> Custom exceptions + central ExceptionHandler

🖼 Architecture Flow Diagram
User Input 
   ↓
Helper (safe input reader)
   ↓
Validator (business rule checks)
   ↓
ExceptionHandler (prints clean error messages)
   ↓
ExpenseManager (application logic)
   ↓
File I/O (saving & loading)


This makes the app clean, maintainable, and scalable.

🧩 Exception Handling

The project uses a full exception strategy:

Runtime exceptions for invalid data

Checked exceptions for file operations

Custom exceptions:

InvalidAmountException

InvalidCategoryException

InvalidDateException

Central handler:
ExceptionHandler.handle(e) to show clean error messages

🛡 Validation Layer (Key Rules)

Validator ensures:

Amount must be positive

Category index must be valid

Date must follow YYYY-MM-DD format

Year must be ≥ 1900

Month must be between 1–12

Helper ensures:

Safe parsing of integers

Safe reading of Strings

Safe date input

Together they provide a robust input pipeline.

📁 File Format (Entry.txt)

Each line stores one expense:

amount|CATEGORY|description|2024-01-15


This enables easy saving/loading using simple parsing.

▶️ How to Run

Clone the repository:

git clone https://github.com/<your-username>/<repo-name>.git


Open the project in Eclipse/IntelliJ/VS Code

Run the main class

🛠 Tech Stack

Java 8+

File I/O Streams

Custom Exceptions

OOP Principles

Git & GitHub Version Control

🔮 Future Enhancements

 User authentication

 Export expenses to CSV/JSON

 Migrate to MySQL database

 Build REST APIs using Spring Boot

 Add sorting & searching filters

 Add expense editing & deletion

👨‍💻 Author

Souvik Das
Java Backend Developer | Spring Boot | DSA | MySQL
“Code. Learn. Build. Improve.”

⭐ Support

If this project helped you, please ⭐ star the repo — it motivates me to build more!