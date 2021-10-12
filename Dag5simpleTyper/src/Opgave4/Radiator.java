package Opgave4;

public class Radiator {
    private int temperature;

    public Radiator(){
        temperature = 20;
    }

    public Radiator(int temperature){
        this.temperature = temperature;
    }

    public int getTemperature(){
        return temperature;
    }

    public void skruOp(int grader){
        temperature += grader;
    }

    public void skruNed(int grader){
        temperature -= grader;
    }
}