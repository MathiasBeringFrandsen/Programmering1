package øvelse;

public class App {
    public static void main(String[] args) {
        Person p1 = new Person("Alin", 2000);
        Student s1 = new Student("Mads", 1996, "Dansk");
        Instructor i1 = new Instructor("Mathias", 1986, 4032);

        System.out.println(p1.toString());
        System.out.println();
        System.out.println(s1.toString());
        System.out.println();
        System.out.println(i1.toString());
    }
}