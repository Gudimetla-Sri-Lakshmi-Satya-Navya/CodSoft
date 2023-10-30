import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

interface ATMInterface {
    void checkBalance();
    void deposit();
    void withdraw();
    void exit();
}

class ATM implements ATMInterface {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void checkBalance() {
        System.out.println("Account Holder: " + bankAccount.getAccountHolderName());
        System.out.println("Account Number: " + bankAccount.getAccountNumber());
        System.out.println("Current Balance: $" + bankAccount.getBalance());
    }

    @Override
    public void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter deposit amount: $");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            bankAccount.deposit(amount);
            System.out.println("Deposited: $" + amount);
            checkBalance();
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    @Override
    public void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter withdrawal amount: $");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            if (bankAccount.withdraw(amount)) {
                System.out.println("Withdrawn: $" + amount);
            } else {
                System.out.println("Insufficient balance.");
            }
            checkBalance();
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    @Override
    public void exit() {
        System.out.println("Exiting the ATM. Thank you for using our services!");
        System.exit(0);
    }
}

public class ATMProgram {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("123456", "John Doe", 1000.0);
        ATMInterface atm = new ATM(account);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;
                case 2:
                    atm.deposit();
                    break;
                case 3:
                    atm.withdraw();
                    break;
                case 4:
                    atm.exit();
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
