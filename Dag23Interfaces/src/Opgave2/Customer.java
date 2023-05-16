package Opgave2;

public class Customer implements Comparable<Customer> {
    private String fornavn;
    private String efternavn;
    private int alder;

    public Customer(String fornavn, String efternavn, int alder) {
        this.fornavn = fornavn;
        this.efternavn = efternavn;
        this.alder = alder;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEfternavn() {
        return efternavn;
    }

    public void setEfternavn(String efternavn) {
        this.efternavn = efternavn;
    }

    public int getAlder() {
        return alder;
    }

    public void setAlder(int alder) {
        this.alder = alder;
    }

    public int compareTo(Customer customer) {
        int comp = efternavn.compareTo(customer.getEfternavn());
        if (comp == 0) {
            comp = fornavn.compareTo(customer.getFornavn());
        }
        if (comp == 0) {
            comp = alder - customer.getAlder();
        }
        return comp;
    }

    public String toString(){
        return efternavn + ", " + fornavn + " (" + alder + ")";
    }

}
