package Opgave2;


import java.util.Arrays;

public class App {

    public static Customer lastCustomer(Customer[] customers) {
        Customer last = customers[0];
        for (Customer customer : customers) {
            if (customer.compareTo(last) > 0) {
                last = customer;
            }
        }
        return last;
    }

    public static Customer[] afterCustomer(Customer[] customers, Customer customer) {
        Customer[] afterCustomers = new Customer[customers.length];
        int customersplaced = 0;
        for (int i = 0; i < customers.length; i++) {
            if (customers[i].compareTo(customer) > 0) {
                afterCustomers[customersplaced] = customers[i];
                customersplaced++;
            }
        }
        return afterCustomers;
    }

    public static void main(String[] args) {
        Customer c1 = new Customer("Alin", "Constantin", 21);
        Customer c2 = new Customer("Mads", "Flækgaard", 23);
        Customer c3 = new Customer("Alin", "Constantin", 23);
        Customer c4 = new Customer("Abekat", "Flækgaard", 35);
        Customer c5 = new Customer("Mathias", "Frandsen", 35);

        Customer[] customers = {c1, c2, c3, c4, c5};

        System.out.println(lastCustomer(customers));
        System.out.println();
        System.out.println(Arrays.toString(afterCustomer(customers, c4)));

    }
}
