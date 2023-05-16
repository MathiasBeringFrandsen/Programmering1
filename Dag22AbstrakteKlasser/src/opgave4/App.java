package opgave4;

public class App {
    public static void main(String[] args) {
        Cirkel cirkel = new Cirkel(1, 1, 3);
        Ellipse ellipse = new Ellipse(3, 3, 4, 2);
        Kvadrat kvadrat = new Kvadrat(5, 4, 6);
        Rektangel rektangel = new Rektangel(7, 6, 4, 5);

        System.out.println("Cirkel areal: " + cirkel.beregnAreal());
        System.out.println("Cirkel lokation: " + cirkel.getLocation());
        cirkel.forskyd(10, 20);
        System.out.println("Cirkel nye lokation: " + cirkel.getLocation());
        System.out.println();
        System.out.println("Ellipse areal: " + ellipse.beregnAreal());
        System.out.println();
        System.out.println("Kvadrat areal: " + kvadrat.beregnAreal());
        System.out.println();
        System.out.println("Rektangel areal: " + rektangel.beregnAreal());
    }
}
