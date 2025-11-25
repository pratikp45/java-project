📊 Expense Management System — Java CLI Application

A simple and efficient command-line based personal expense manager built using Java.
It helps users record their daily spending, organize them by categories, and analyze financial patterns using persistent text-file storage.

✅ Key Functionalities

📌 1. Add New Expense

Store each expense with:

Date

Category (Food, Travel, Shopping, etc.)

Amount


📌 2. Display All Expenses

Shows a neatly formatted list of every record stored.

📌 3. Search by Category

Filter and view all expenses under a specific category.

📌 4. Delete an Entry

Remove any expense using its index number.

📌 5. Storage Persistence

All data is saved in a file called expense_data.txt, and is automatically loaded when the program starts.

📌 6. Expense Summary

The system:

Calculates total spending

Displays a simple financial status (Healthy / Moderate / Critical)


📌 7. Input Safety

Includes checks for:

Positive numeric amounts

Valid menu options



---

🧰 Technologies & Concepts Used

Java (JDK 8 or above)

Object-Oriented Programming (Classes, Objects)

Collections Framework – ArrayList

File Handling (Reading & Writing to TXT file)

Exception Management (try-catch)



---

▶️ How to Run the Program

1. Check Java Installation

java -version

2. Compile the Program

javac ExpenseTrackerProject.java

3. Run the Application

java ExpenseTrackerProject


---

📁 Folder Layout

ExpenseTracker/
│
├── ExpenseTrackerProject.java   # Main code file
├── expense_data.txt             # Auto-generated storage file
└── README.md                    # Documentation


---