import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseTrackerProject {

    // --- DATA MODEL ---
    static class Expense {
        String date;
        String category;
        double amount;

        public Expense(String date, String category, double amount) {
            this.date = date;
            this.category = category;
            this.amount = amount;
        }

        public String toFileString() {
            return date + "," + category + "," + amount;
        }

        @Override
        public String toString() {
            // Using String.format for cleaner alignment in the console
            return String.format("Date: %-12s | Cat: %-10s | Amt: ₹%.2f", date, category, amount);
        }
    }

    // --- GLOBAL VARIABLES ---
    static ArrayList<Expense> myExpenses = new ArrayList<>(); // Renamed list
    static final String FILE_NAME = "expense_data.txt";
    static Scanner sc = new Scanner(System.in);

    // --- MAIN CONTROLLER ---
    public static void main(String[] args) {
        loadData();

        System.out.println("******************************************");
        System.out.println("    SMART EXPENSE TRACKER SYSTEM v2.0");
        System.out.println("******************************************");

        while (true) {
            System.out.println("\n--- MAIN DASHBOARD ---");
            System.out.println("1. Add New Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. Search by Category (Filter)"); // NEW
            System.out.println("4. Delete an Expense"); // NEW
            System.out.println("5. View Budget Analysis");
            System.out.println("6. Save & Exit");
            System.out.print(">> Enter Choice: ");

            if (sc.hasNextInt()) {
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1: addExpense(); break;
                    case 2: viewExpenses(); break;
                    case 3: searchByCategory(); break; // NEW
                    case 4: deleteExpense(); break; // NEW
                    case 5: analyzeBudget(); break;
                    case 6:
                        saveData();
                        System.out.println("Data Saved. System Shutting Down...");
                        return;
                    default: System.out.println("Invalid option.");
                }
            } else {
                System.out.println("Please enter a valid number.");
                sc.nextLine();
            }
        }
    }

    // --- 1. ADD EXPENSE ---
    public static void addExpense() {
        System.out.print("Enter Date (DD-MM-YYYY): ");
        String date = sc.nextLine();

        System.out.print("Enter Category (Food, Travel, Bills, etc): ");
        String category = sc.nextLine();

        double amount = 0;
        while (true) {
            System.out.print("Enter Amount: ");
            if (sc.hasNextDouble()) {
                amount = sc.nextDouble();
                sc.nextLine();
                if (amount > 0) break;
                System.out.println("Amount must be positive.");
            } else {
                System.out.println("Invalid input. Numbers only.");
                sc.next();
            }
        }

        myExpenses.add(new Expense(date, category, amount));
        System.out.println(">> Record Added Successfully.");
    }

    // --- 2. VIEW ALL ---
    public static void viewExpenses() {
        System.out.println("\n--- All Records ---");
        if (myExpenses.isEmpty()) {
            System.out.println("No Data Available.");
        } else {
            // Display with Index Numbers so user knows what to delete
            for (int i = 0; i < myExpenses.size(); i++) {
                System.out.println("[" + (i + 1) + "] " + myExpenses.get(i).toString());
            }
        }
    }

    // --- 3. SEARCH (NEW FEATURE) ---
    public static void searchByCategory() {
        System.out.print("Enter Category to search (e.g., Food): ");
        String searchKey = sc.nextLine();
        boolean found = false;

        System.out.println("\n--- Search Results for '" + searchKey + "' ---");
        for (Expense e : myExpenses) {
            // equalsIgnoreCase allows "food" to match "Food"
            if (e.category.equalsIgnoreCase(searchKey)) {
                System.out.println(e.toString());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No records found for this category.");
        }
    }

    // --- 4. DELETE (NEW FEATURE) ---
    public static void deleteExpense() {
        viewExpenses(); // Show list first
        if (myExpenses.isEmpty()) return;

        System.out.print("\nEnter the ID number to delete: ");
        if (sc.hasNextInt()) {
            int id = sc.nextInt();
            sc.nextLine();

            if (id > 0 && id <= myExpenses.size()) {
                Expense removed = myExpenses.remove(id - 1);
                System.out.println(">> Deleted: " + removed.category + " (₹" + removed.amount + ")");
            } else {
                System.out.println("Error: Invalid ID Number.");
            }
        } else {
            System.out.println("Invalid input.");
            sc.nextLine();
        }
    }

    // --- 5. ANALYSIS ---
    public static void analyzeBudget() {
        double total = 0;
        for (Expense e : myExpenses) {
            total += e.amount;
        }
        System.out.println("\n>> Total Expenses: $" + total);

        // Simple logic for budget status
        if (total > 10000) {
            System.out.println("STATUS: CRITICAL - You are over budget!");
        } else if (total > 5000) {
            System.out.println("STATUS: WARNING - Spending is high.");
        } else {
            System.out.println("STATUS: HEALTHY - Within limits.");
        }
    }

    // --- FILE HANDLING ---
    public static void saveData() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Expense e : myExpenses) {
                writer.write(e.toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Save Error: " + e.getMessage());
        }
    }

    public static void loadData() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (Scanner fSc = new Scanner(file)) {
            while (fSc.hasNextLine()) {
                String line = fSc.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    myExpenses.add(new Expense(parts[0], parts[1], Double.parseDouble(parts[2])));
                }
            }
        } catch (Exception e) {
            System.out.println("Load Error.");
        }
    }
}