package PersonGift;

public class Gift {
    private String description;
    private double price;
    private Person giver;

    public Gift(String description, Person giver){
        this.description = description;
        this.giver = giver;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public double getPrice(){
        return price;
    }

    public Person getGiver(){
        return giver;
    }

}
