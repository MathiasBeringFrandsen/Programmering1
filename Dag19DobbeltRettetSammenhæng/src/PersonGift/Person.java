package PersonGift;

import java.util.ArrayList;

public class Person {
    private String name;
    private int age;
    private final ArrayList<Gift> gifts = new ArrayList<>();

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String toString(){
        return "" + name + ", " + age;
    }

    public ArrayList<Gift> getGifts() {
        return new ArrayList<>(gifts);
    }

    public void addGift(Gift gift){
        if (!gifts.contains(gift)){
            gifts.add(gift);
        }
    }

    public void removeGift(Gift gift){
        if (gifts.contains(gift)){
            gifts.remove(gift);
        }
    }

    public double valueOfGifts(){
        double totalValue = 0;
        for (Gift gift : gifts){
            totalValue += gift.getPrice();
        }
        return totalValue;
    }

    public ArrayList<Person> GotGiftsFrom(){
        ArrayList<Person> gotGiftsFrom = new ArrayList<>();
        for (Gift gift: gifts){
            gotGiftsFrom.add(gift.getGiver());
        }
        return gotGiftsFrom;
    }

}
