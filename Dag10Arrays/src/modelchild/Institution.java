package modelchild;

public class Institution {
    private String name;
    private String adress;
    private Child[] children;
    private int numberOfChildren;

    private static final int MAX_NUMBER_OF_KIDS = 36;

    public Institution(String name, String adress) {
        this.name = name;
        this.adress = adress;
        numberOfChildren = 0;
        children = new Child[MAX_NUMBER_OF_KIDS];
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    public void addChild(Child child) {
        if (numberOfChildren < MAX_NUMBER_OF_KIDS){
            children[numberOfChildren] = child;
            numberOfChildren++;
        } else {
            System.out.println("Der er ikke plads til flere børn i denne institution.");
        }
    }

    public double averageAge(){
        double totalAge = 0;
        for (int i = 0; i < numberOfChildren; i++){
            totalAge = totalAge + children[i].getAge();
        }
        return totalAge / numberOfChildren;
    }

    public int numberOfGirls(){
        int numberOfGirls = 0;
        for (int i = 0; i < numberOfChildren; i++){
            if (!children[i].isBoy()){
                numberOfGirls++;
            }
        }
        return numberOfGirls;
    }

    public int numberOfBoys(){
        int numberOfBoys = 0;
        for (int i = 0; i < numberOfChildren; i++){
            if (children[i].isBoy()){
                numberOfBoys++;
            }
        }
        return numberOfBoys;
    }

}