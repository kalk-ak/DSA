/*
public class BankAccount {
    String name;
    String password;
    double balance;

    public void withdraw(String enteredPassword, double amount){
        // Only people with the right password and sufficient funds can withdraw

        if (password.equals(enteredPassword) && balance >= amount){
            balance = balance - amount;
        }
    }

    public void deposit(String enteredPassword, double amount){
        if (password.equals(enteredPassword)){
            balance = balance + amount
        }
    }
}
*/
import java.util.Scanner;
public class BankAccount {
    String name;
    private String password;
    double balance;

    public void withdraw(String enteredPassword, double amount) {
        // Only people with the right password and sufficient funds can withdraw

        if (password.equals(enteredPassword) && balance >= amount) {
            balance = balance - amount;
        }
    }

    public void deposit(String enteredPassword, double amount) {
        if (password.equals(enteredPassword)) {
            balance = balance + amount;
        }
    }

    public BankAccount(String initName, String initPass, double initBalance) {
        this.name = initName;
        this.password = initPass;
        this.balance = initBalance;
    }

    public double getBalance(String enteredPassword) {
        if (password.equals(enteredPassword)) {
            return balance;
        } else {
            return -1;
        }
    }


    public boolean setPassword(String oldPassword, String newPassword) {
        if (password.equals(oldPassword)) {
            password = newPassword;
            return true;
        } else {
            return false;
        }
    }

    // Transfers the given amount from this account into the other account
    // if enteredPassword matches password and the password entered in this
    // function matches the other account’s password.
    // Note: You’ll have to use the Scanner class again to intake a password
    // to deposit into other.
    public void transfer(BankAccount other, String enteredPassword, double
            amount){
        System.out.println("running");
        if (password.equals(enteredPassword)){
            balance = balance - amount;

            System.out.println("Type your other accounts password");
            Scanner myScanner = new Scanner(System.in);
            String input = myScanner.nextLine();

            if (other.password.equals(input)){
                other.balance += amount;
                System.out.println("you've transfered " + amount + "from" + this.name + "to" + other.name);
            } else {
                balance += amount;
                System.out.println("Nope");
            }
        }
    }

}










