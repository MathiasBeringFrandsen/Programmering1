package Opgave3;

import java.time.LocalDate;

public class TestApp {
    public static void main(String[] args) {
        Customer c1 = new Customer("Alin", LocalDate.of(2000, 11, 10));
        Customer c2 = new Customer("Mathias", LocalDate.of(1986, 04, 07));

        Product p1 = new Product(1, "Headset", 200);
        Product p2 = new Product(2, "FlatScreen", 2000);
        Product p3 = new Product(3, "Keyboard", 800);
        Product p4 = new Product(4, "USB", 50);
        Product p5 = new Product(5, "Coca Cola", 17);

        Order o1 = new Order(1);
        Order o2 = new Order(2);
        Order o3 = new Order(3);
        Order o4 = new Order(4);
        Order o5 = new Order(5);
        Order o6 = new Order(6);

        o1.createOrderLine(2, p1);
        o1.createOrderLine(3, p2);

        o2.createOrderLine(1, p2);
        o2.createOrderLine(3, p5);

        o3.createOrderLine(5, p4);
        o3.createOrderLine(4, p3);

        o4.createOrderLine(39, p5);
        o4.createOrderLine(12, p2);

        o5.createOrderLine(12, p4);
        o5.createOrderLine(22, p1);

        o6.createOrderLine(132, p2);
        o6.createOrderLine(95, p3);

        c1.addOrder(o1);
        c1.addOrder(o2);

        c2.addOrder(o3);
        c2.addOrder(o4);
        c2.addOrder(o5);
        c2.addOrder(o6);

        Discount d1 = new PercentDiscount(15);
        c1.setDiscount(d1);

        Discount d2 = new FixedDiscount(250, 1000);
        c2.setDiscount(d2);

        System.out.println(c1.totalBuy());
        System.out.println(c1.totalBuyWithDiscount());
        System.out.println();
        System.out.println(c2.totalBuy());
        System.out.println(c2.totalBuyWithDiscount());


    }
}
