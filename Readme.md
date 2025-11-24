# Smart Expense Tracker System v2.0 💰

A robust, menu-driven Command Line Interface (CLI) application built in Java to help users manage their daily finances. This project allows users to add, view, search, delete, and analyze expenses with persistent data storage.

## 📋 Features

* **Add Expenses:** Record new expenses with Date, Category, and Amount.
* **View All Records:** Display a formatted list of all expenses.
* **Data Persistence:** Automatically saves data to `expense_data.txt` so records are not lost when the program closes.
* **Search Function:** Filter expenses by specific categories (e.g., Food, Travel).
* **Delete Function:** Remove specific entries using their Index ID.
* **Budget Analysis:** Calculates total spending and provides a health status (Healthy, Warning, or Critical).
* **Input Validation:** Ensures amounts are positive numbers and menu choices are valid.

## 🛠️ Tech Stack

* **Language:** Java (JDK 8+)
* **Concepts Used:** * Object-Oriented Programming (Classes, Objects)
    * Collections Framework (`ArrayList`)
    * File Handling (I/O Streams for `.txt` storage)
    * Exception Handling (`try-catch`)

## 🚀 How to Run

1.  **Prerequisites:** Ensure you have Java installed.
    ```bash
    java -version
    ```

2.  **Save the File:**
    Save the source code as `ExpenseTrackerProject.java`.

3.  **Compile:**
    Open your terminal or command prompt and navigate to the folder containing the file. Run:
    ```bash
    javac ExpenseTrackerProject.java
    ```

4.  **Run:**
    Execute the program:
    ```bash
    java ExpenseTrackerProject
    ```

## 📂 Project Structure

```text
ExpenseTrackerProject/
│
├── ExpenseTrackerProject.java  # Main source code
├── expense_data.txt            # Database file (Auto-generated)
└── README.md                   # Project Documentation