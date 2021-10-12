package modelchild;

public class ChildApp {

    public static void main(String[] args) {
        Child c1 = new Child(0, true);// boy 4 years old
        Child c2 = new Child(2, false);// girl 2 years old
        Child c3 = new Child(4, true);
        Child c4 = new Child(1, true);
        Child c5 = new Child(2, false);
        Institution børnehuset = new Institution("Holme Børnehus", "Molbovej 23");
        børnehuset.addChild(c1);
        børnehuset.addChild(c2);
        børnehuset.addChild(c3);
        børnehuset.addChild(c4);
        børnehuset.addChild(c5);

        System.out.println("Et barn på " + c1.getAge());
        System.out.println("Barnet vejede " + c1.getWeight(4) + " da det var fire år");
        System.out.println("Barnets største vægtforøgelse var på " + c1.getIncrease() + " kg");
        System.out.println("Den gennemsnitlige alder i " + børnehuset.getName() + " er " + børnehuset.averageAge() + " år");
        System.out.println("Der er " + børnehuset.numberOfBoys() + " drenge i " + børnehuset.getName());
        System.out.println("Der er " + børnehuset.numberOfGirls() + " piger i " + børnehuset.getName());

    }

}
