
import java.util.*;
public class ATM_Interface {
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.start();
    }
}
class UserBankAccount {
    private double currentBalance;
    public UserBankAccount(double initialBalance){
        currentBalance = initialBalance;
    }
    public double getBalance() {
        return currentBalance;
    }
    public void deposit(double amount) {
        currentBalance = currentBalance + amount;
    }
    public boolean withdraw(double amount) {
        if (amount <= currentBalance) {
            currentBalance = currentBalance - amount;
            return true;
        } else {
            return false;
        }
    }
}
class ATM {
    private UserBankAccount ATMAccount;
    private Scanner scanner;
    public ATM() {
        ATMAccount = new UserBankAccount(0.0);
        scanner = new Scanner(System.in);
    }
    public void start() {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    deposit();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    exit();
                    return;
                default:
                    System.out.println("!Invalid choice. Please try again!.");
            }
        }
    }
    private void displayMenu() {
        System.out.println("Welcome to Our ATM Machine");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }
    private void deposit() {
        System.out.print("Enter the deposit amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); 
        ATMAccount.deposit(amount);
        System.out.println("Deposit successful. New balance is: " + ATMAccount.getBalance());
    }
    private void withdraw() {
        System.out.print("Enter the withdrawal amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        if (ATMAccount.withdraw(amount)) {
            System.out.println("Withdrawal successful. New balance is:" + ATMAccount.getBalance());
        } else {
            System.out.println("Sorry!.Insufficient balance.");
        }
    }
    private void checkBalance() {
        System.out.println("Current balance is : " + ATMAccount.getBalance());
    }
    private void exit() {
        System.out.println("THANK YOU. to Use Our ATM PLEASE VISIT AGAIN");
    }
}