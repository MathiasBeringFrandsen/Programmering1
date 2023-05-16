package application.model;

public class Vagt {
    private int timer;
    private Frivillig frivillig;
    private Job job;

    Vagt(int timer, Frivillig Frivillig, Job job){
        this.timer = timer;
        this.frivillig = Frivillig;
        this.job = job;
        frivillig.addVagt(this);
    }

    public int getTimer() {
        return timer;
    }

    public Frivillig getFrivillig() {
        return frivillig;
    }

    public String toString(){
        return timer + " på " + job.getBeskrivelse();
    }

}
