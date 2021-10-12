package Opgave4;

public class PersonApp {

    public static void main(String[] args) {
        Person john = new Person("John", "Lærkevej 233", 32940);
        john.printPerson();
        john.hiredByNewCompany();
        john.printPerson();
    }
}
