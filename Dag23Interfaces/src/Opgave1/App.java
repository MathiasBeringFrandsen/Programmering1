package Opgave1;

public class App {

    public static Measurable max(Measurable[] objects) {
        Measurable max = objects[0];
        for (Measurable measurable : objects) {
            if (measurable.getMeasure() > max.getMeasure()) {
                max = measurable;
            }
        }
        return max;
    }

    public static double average(Measurable[] objects) {
        double average = 0;
        for (Measurable measurable : objects) {
            average += measurable.getMeasure();
        }
        return average / objects.length;
    }

    public static void main(String[] args) {
        Chilli c1 = new Chilli("Carolina Reaper", 2200000);
        Chilli c2 = new Chilli("Habanero", 577000);
        Chilli c3 = new Chilli("Jalapeno", 10000);
        Chilli c4 = new Chilli("Naga Jolokia", 1001304);

        Measurable[] measurables = {c1, c2, c3, c4};

        System.out.println(max(measurables));
        System.out.println();
        System.out.println(average(measurables));
    }
}
