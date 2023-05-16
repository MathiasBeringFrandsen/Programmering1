package bankAccount;

/**
 * Modellerer en bankkonto
 */
public class BankAccount {
    private double balance;
    private int id;
    private static int lastAssignedNumber = 0;

    /**
     * Initaliserer en ny bankkonto og tildeler kontoen et kontonr
     * @param initialBalance kontoens start balance
     */
    public BankAccount(double initialBalance) {
        balance = initialBalance;
        id = lastAssignedNumber;
        lastAssignedNumber++;
    }

    /**
     * tilføjer penge til kontoen
     * @param amount mængden der bliver indsat på kontoen
     */
    public void deposit(double amount) {
        balance += amount;
    }

    /**
     * Hæver penge fra kontoen
     * @param amount mængden der bliver hævet
     * Pre: amount <= balance
     */
    public void withdraw(double amount) {
        balance -= amount;
    }

    /**
     * @return returnerer det indestående beløb
     */
    public double getBalance() {
        return balance;
    }

    /**
     * @return returnerer kontoens unikke id
     */
    public int getId(){
        return id;
    }

    /**
     * @return returner hvor mange kontoer man har åbnet
     */
    public static int numberOfAccountsOpened(){
        return lastAssignedNumber;
    }

}