import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ExpenseTracker {

    
    static class Expense {
        private String name;
        private double amount;
        private String category;
        private String date;

        public Expense(String name, double amount, String category, String date) {
            this.name = name;
            this.amount = amount;
            this.category = category;
            this.date = date;
        }

        public String getName() {
            return name;
        }

        public String getCategory() {
            return category;
        }

        public String getDate() {
            return date;
        }

        @Override
        public String toString() {
            return "Expense [Name=" + name + ", Amount=" + amount + ", Category=" + category + ", Date=" + date + "]";
        }
    }


    private List<Expense> expenses;

    public ExpenseTracker() {
        this.expenses = new ArrayList<>();
    }

    public void addExpense(String name, double amount, String category, String date) {
        Expense expense = new Expense(name, amount, category, date);
        expenses.add(expense);
    }

    public void displayExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
        } else {
            for (int i = 0; i < expenses.size(); i++) {
                System.out.println((i + 1) + ". " + expenses.get(i));
            }
        }
    }

    public double getTotalExpenses() {
        double total = 0.0;
        for (Expense expense : expenses) {
            total += expense.amount;
        }
        return total;
    }

    public void removeExpense(int index) {
        if (index >= 0 && index < expenses.size()) {
            expenses.remove(index);
            System.out.println("Expense removed successfully.");
        } else {
            System.out.println("Invalid index. No expense removed.");
        }
    }

    public void searchExpenses(String keyword) {
        boolean found = false;
        for (Expense expense : expenses) {
            if (expense.getName().equalsIgnoreCase(keyword) || expense.getCategory().equalsIgnoreCase(keyword)) {
                System.out.println(expense);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No expenses found with the keyword: " + keyword);
        }
    }


    public void filterExpensesByDate(String startDate, String endDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        boolean found = false;
        try {
            Date start = dateFormat.parse(startDate);
            Date end = dateFormat.parse(endDate);

            for (Expense expense : expenses) {
                Date expenseDate = dateFormat.parse(expense.getDate());
                if (expenseDate.compareTo(start) >= 0 && expenseDate.compareTo(end) <= 0) {
                    System.out.println(expense);
                    found = true;
                }
            }
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use yyyy-mm-dd.");
            return;
        }
        if (!found) {
            System.out.println("No expenses found within the specified date range.");
        }
    }

    
    public static boolean isValidDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    
    public static void main(String[] args) {
        ExpenseTracker expenseTracker = new ExpenseTracker();
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.println("\nExpense Tracker Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. View Total Expenses");
            System.out.println("4. Remove Expense");
            System.out.println("5. Search Expense by Name/Category");
            System.out.println("6. Filter Expenses by Date Range");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter expense name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter expense amount: ");
                    double amount;
                    try {
                        amount = Double.parseDouble(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid amount. Please enter a valid number.");
                        break;
                    }
                    System.out.print("Enter expense category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter expense date (yyyy-mm-dd): ");
                    String date = scanner.nextLine();

                    if (!isValidDate(date)) {
                        System.out.println("Invalid date format. Please use yyyy-mm-dd.");
                        break;
                    }

                    expenseTracker.addExpense(name, amount, category, date);
                    System.out.println("Expense added successfully.");
                    break;

                case "2":
                    System.out.println("\nRecorded Expenses:");
                    expenseTracker.displayExpenses();
                    break;

                case "3":
                    double totalExpenses = expenseTracker.getTotalExpenses();
                    System.out.println("\nTotal Expenses: $" + totalExpenses);
                    break;

                case "4":
                    System.out.println("\nRecorded Expenses:");
                    expenseTracker.displayExpenses();
                    System.out.print("Enter the index of the expense to remove: ");
                    int index;
                    try {
                        index = Integer.parseInt(scanner.nextLine()) - 1; 
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid index. Please enter a valid number.");
                        break;
                    }
                    expenseTracker.removeExpense(index);
                    break;

                case "5":
                    System.out.print("Enter name or category to search: ");
                    String keyword = scanner.nextLine();
                    System.out.println("\nSearch Results:");
                    expenseTracker.searchExpenses(keyword);
                    break;

                case "6":
                    System.out.print("Enter start date (yyyy-mm-dd): ");
                    String startDate = scanner.nextLine();
                    System.out.print("Enter end date (yyyy-mm-dd): ");
                    String endDate = scanner.nextLine();

                    if (!isValidDate(startDate) || !isValidDate(endDate)) {
                        System.out.println("Invalid date format. Please use yyyy-mm-dd.");
                        break;
                    }

                    System.out.println("\nFiltered Expenses:");
                    expenseTracker.filterExpensesByDate(startDate, endDate);
                    break;

                case "7":
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (!choice.equals("7"));

        scanner.close();
    }
}
