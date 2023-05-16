package Udlejning;

public class RentalApp {
    public static void main(String[] args) {
        Car c1 = new Car("CU 12 146", 2009);
        Car c2 = new Car("OF 42 394", 2016);
        Car c3 = new Car("KR 43 235", 2020);
        Car c4 = new Car("MF 00 938", 1999);
        Car c5 = new Car("WE 23 346", 2030);

        Rental r1 = new Rental(12, "05-11-2021", 8);
        Rental r2 = new Rental(15, "24-12-2021", 7);

        r1.addCar(c1);
        r1.addCar(c2);
        r1.addCar(c5);

        r2.addCar(c4);
        r2.addCar(c3);

        System.out.println(r1.getPrice());
    }
}
