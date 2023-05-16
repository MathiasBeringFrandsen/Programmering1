package januar2018.application.model;

import java.util.ArrayList;

public class Hold {
    private String betegnelse;
    private String holdleder;
    private Uddannelse uddannelse;
    private final ArrayList<Tutor> tutors = new ArrayList<>();

    public Hold(String betegnelse, String holdleder, Uddannelse uddannelse) {
        this.betegnelse = betegnelse;
        this.holdleder = holdleder;
        this.uddannelse = uddannelse;
    }

    public String getBetegnelse() {
        return betegnelse;
    }

    public String getHoldleder() {
        return holdleder;
    }

    public Uddannelse getUddannelse() {
        return uddannelse;
    }

    public ArrayList<Tutor> getTutors() {
        return new ArrayList<>(tutors);
    }

    public void addTutor(Tutor tutor) {
        tutors.add(tutor);
    }

    public void removeTutor(Tutor tutor) {
        tutors.remove(tutor);
    }

    public double arrangementsPris() {
        double totalPris = 0;
        for (Tutor tutor : tutors) {
            totalPris += tutor.arrangementsPris();
        }
        return totalPris;
    }

    public boolean harTidsoverlap(Arrangement arrangement) {
        boolean harOverlap = false;
        int i = 0;
        while (!harOverlap && i < tutors.size()){
            harOverlap = tutors.get(i).overlap(arrangement);
        }
        return harOverlap;
    }

    public String toString(){
        return this.betegnelse;
    }


}
