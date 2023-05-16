package Opgave1;

public class Chilli implements Measurable {
    private String name;
    private int strength;

    public Chilli(String name, int strength) {
        this.name = name;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public double getMeasure() {
        return strength;
    }

    public String toString() {
        return name;
    }
}