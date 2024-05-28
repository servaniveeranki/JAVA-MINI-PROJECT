import java.util.Scanner;

public class BankApplication_S20220010240 {
    public static void main(String[] args) {
        Account acc1 = new Account(1234, "Amie", "a123", 10000.0);
        Account acc2 = new Account(1757, "Bubbly", "b122", 10500.0);
        Account acc3 = new Account(5583, "Catherine", "c233", 20000.0);
        Account acc4 = new Account(6847, "David", "d674", 8000.0);
        Account acc5 = new Account(2565, "elsa", "e785", 30000.0);

        Scanner input = new Scanner(System.in);

        System.out.print("Enter account number: ");
        int account_no = input.nextInt();

        System.out.print("Enter password: ");
        String password = input.next();

        Account selectedAccount = null;

        if (account_no == acc1.getAccountNumber() && acc1.validatePassword(password)) {
            selectedAccount = acc1;
        } else if (account_no == acc2.getAccountNumber() && acc2.validatePassword(password)) {
            selectedAccount = acc2;
        } else if (account_no == acc3.getAccountNumber() && acc3.validatePassword(password)) {
            selectedAccount = acc3;
        } else if (account_no == acc4.getAccountNumber() && acc4.validatePassword(password)) {
            selectedAccount = acc4;
        } else if (account_no == acc5.getAccountNumber() && acc5.validatePassword(password)) {
            selectedAccount = acc5;
        } else {
            System.out.println("Invalid account number or password.");
            input.close();
            return;
        }

        System.out.println("Logged in as: " + selectedAccount.getAccountName());
        int option;
        do {
            System.out.println("1. Check Balance");
            System.out.println("2. Credit Amount");
            System.out.println("3. Debit Amount");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            option = input.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Account Balance: " + selectedAccount.getBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to credit: ");
                    double creditAmount = input.nextDouble();
                    selectedAccount.credit(creditAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to debit: ");
                    double debitAmount = input.nextDouble();
                    selectedAccount.debit(debitAmount);
                    break;
                case 4:
                    System.out.println("Exiting the application.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (option != 4);

        input.close();
    }
}

class Account {
    private int account_no;
    private String account_name;
    private String password;
    private double balance;

    public Account(int account_no, String account_name, String password, double balance) {
        this.account_no = account_no;
        this.account_no = account_no;
        this.password = password;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return account_no;
    }

    public String getAccountName() {
        return account_name;
    }

    public boolean validatePassword(String Password) {
        return password.equals(Password);
    }

    public double getBalance() {
        return balance;

    }

    public void credit(double amount) {
        balance += amount;
    }

    public void debit(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}
