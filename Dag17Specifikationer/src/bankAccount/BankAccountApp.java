package bankAccount;

public class BankAccountApp {
    public static void main(String[] args) {
        BankAccount b1 = new BankAccount(0);
        BankAccount b2 = new BankAccount(10);
        BankAccount b3 = new BankAccount(100);

        System.out.println(b1.getBalance());
        b1.deposit(10000);
        System.out.println(b1.getBalance());
        b1.withdraw(2345);
        System.out.println(b1.getBalance());
        System.out.println(BankAccount.numberOfAccountsOpened());
    }
}
