package Kollegie;

public class TestApp {
    public static void main(String[] args) {
        Kollegie k1 = new Kollegie("Skjoldhøj", "Spobjergvej 6");
        Bolig b1 = new Bolig(20, "Spobjergvej 6", 2459, k1);
        Bolig b2 = k1.createBolig(45, 4504);
        Bolig b3 = k1.createBolig(23, 2576);

        LejeAftale l1 = b1.createLejeaftale();
        LejeAftale l2 = b2.createLejeaftale();
        LejeAftale l3 = b3.createLejeaftale();

        Lejer lejer1 = new Lejer("Mathias", "Datamatiker");

        l1.addLejer(lejer1);

    }
}
