package øvelse;

public class Person {
    private String navn;
    private int fødselsår;

    public Person(String navn, int fødselsår){
        this.navn = navn;
        this.fødselsår = fødselsår;
    }

    public String toString(){
        return navn + ", " + fødselsår;
    }
}
