import java.util.Scanner;

// Class to represent the user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds.");
            return false;
        }
        balance -= amount;
        return true;
    }
}

// Class to represent the ATM machine
public class task3 {
    private BankAccount account;
    private Scanner scanner;

    public task3(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void displayOptions() {
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void withdraw() {
        System.out.println("Enter amount to withdraw:");
        double amount = scanner.nextDouble();
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful. Remaining balance: " + account.getBalance());
        }
    }

    public void deposit() {
        System.out.println("Enter amount to deposit:");
        double amount = scanner.nextDouble();
        account.deposit(amount);
        System.out.println("Deposit successful. New balance: " + account.getBalance());
    }

    public void checkBalance() {
        System.out.println("Your current balance is: " + account.getBalance());
    }

    public void run() {
        int choice = 0;
        while (choice != 4) {
            displayOptions();
            System.out.println("Enter your choice:");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    withdraw();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Exiting. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000); // Initial balance
        task3 atm = new task3(userAccount);
        atm.run();
    }
}
