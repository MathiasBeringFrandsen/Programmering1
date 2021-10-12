package Opgave1;

public class PersonApp {

    public static void main(String[] args) {
        Person p1 = new Person("Bent", "Janus", "Christensen", 27, 12, 1995);
        p1.printPerson();
        System.out.println("Initialer: " + p1.getInit());
        System.out.println("Username: " + p1.getUserName());

        System.out.println("Age: " + p1.age(20, 9, 2021)); // p's age today
        int year1 = 2021;
        System.out.println("Er " + year1 + " skudår: " + p1.leapYear(year1));

        System.out.println("***********************************");

        Person p2 = new Person("Jens", "Bonde", "Hansen", 5, 8, 1967);
        p2.printPerson();
        System.out.println("Initialer: " + p2.getInit());
        System.out.println("Username: " + p2.getUserName());

        System.out.println("Age: " + p2.age(20, 9, 2021)); // p's age today
        int year2 = 2000;
        System.out.println("Er " + year2 + " skudår: " + p2.leapYear(year2));

        System.out.println("***********************************");

        Person p3 = new Person("Karl", "Åge", 21, 9, 2000);
        p3.printPerson();
        System.out.println("Initialer: " + p3.getInit());
        System.out.println("Username: " + p3.getUserName());

        System.out.println("Age: " + p3.age(20, 9, 2021)); // p's age today
        int year3 = 2020;
        System.out.println("Er " + year3 + " skudår: " + p3.leapYear(year3));
    }
}
