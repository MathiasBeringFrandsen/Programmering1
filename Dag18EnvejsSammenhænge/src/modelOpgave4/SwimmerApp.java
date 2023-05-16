package modelOpgave4;

import java.util.ArrayList;

public class SwimmerApp {
    
    public static void main(String[] args) {

        ArrayList<Double> lapTimes = new ArrayList<>();
        lapTimes.add(1.02);
        lapTimes.add(1.01);
        lapTimes.add(0.99);
        lapTimes.add(0.98);
        lapTimes.add(1.02);
        lapTimes.add(1.04);
        lapTimes.add(0.99);

        lapTimes = new ArrayList<>();
        lapTimes.add(1.05);
        lapTimes.add(1.01);
        lapTimes.add(1.04);
        lapTimes.add(1.06);
        lapTimes.add(1.08);
        lapTimes.add(1.04);
        lapTimes.add(1.02);

        lapTimes = new ArrayList<>();
        lapTimes.add(1.03);
        lapTimes.add(1.01);
        lapTimes.add(1.02);
        lapTimes.add(1.05);
        lapTimes.add(1.03);
        lapTimes.add(1.06);
        lapTimes.add(1.03);


        System.out.println();

        TrainingPlan planA = new TrainingPlan('A', 16, 10);
        TrainingPlan planB = new TrainingPlan('B', 10, 6);

        Swimmer s1 = planA.createSwimmer("Jan", 1994, lapTimes, "AGF");
        Swimmer s2 = planA.createSwimmer("Bo", 1995, lapTimes, "Lyseng");
        Swimmer s3 = planB.createSwimmer("Mikkel", 1993, lapTimes, "AIA-Tranbjerg");

        for (int i = 0; i < planA.getSwimmers().size(); i++) {
            System.out.println("Svømmerens navn: " + planA.getSwimmers().get(i).getName());
            System.out.println("Svømmerens klub: " + planA.getSwimmers().get(i).getClub());
            System.out.println("Svømmerens fødselsår: " + planA.getSwimmers().get(i).getYearGroup());
            System.out.println("Svømmerens bedste tid: " + planA.getSwimmers().get(i).bestLapTime());
            System.out.println();
        }

        planA.removeSwimmer(s1);

        System.out.println(planA.getSwimmers().size());


    }
    
}
