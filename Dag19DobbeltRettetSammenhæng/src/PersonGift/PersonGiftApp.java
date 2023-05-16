package PersonGift;

public class PersonGiftApp {
    public static void main(String[] args) {
        Person p1 = new Person("Mathias", 36);
        Person p2 = new Person("Mads", 33);

        Gift g1 = new Gift("Banjo", p2);
        Gift g2 = new Gift("Trommer", p1);
        Gift g3 = new Gift("Xylofon", p2);
        Gift g4 = new Gift("Klaver", p1);
        Gift g5 = new Gift("Ukulele", p2);

        g1.setPrice(12.3);
        g2.setPrice(94.2);
        g3.setPrice(100.22);
        g4.setPrice(6.65);
        g5.setPrice(943.45);

        p1.addGift(g1);
        p1.addGift(g3);
        p1.addGift(g5);

        p2.addGift(g2);
        p2.addGift(g4);

        System.out.println(p1.valueOfGifts());
        System.out.println();
        System.out.println(p2.valueOfGifts());
        System.out.println();
        System.out.println(p1.GotGiftsFrom());
    }
}
