package Opgave1;

public class Person {
    private String name;
    private String title;
    private boolean senior;

    public Person(String name, String title, boolean senior) {
        this.name = name;
        this.title = title;
        this.senior = senior;
    }

    public String getFirstName() {
        return name;
    }

    public boolean getSenior() {
        return senior;
    }

    @Override
    public String toString() {
        String s = title + " " + name;
        if (senior){
            s = s + " (senior)";
        }
        return s;
    }

}
