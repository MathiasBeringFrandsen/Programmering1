package application.model;

public class Customer {
    private String name;
    private int moneySpent;

    public Customer(String name){
        this.name = name;
        this.moneySpent = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoneySpent() {
        return moneySpent;
    }

    public void setMoneySpent(int moneySpent) {
        this.moneySpent = moneySpent;
    }

    public String toString() {
        return name + " (penge brugt: " + moneySpent + ")";
    }
}
