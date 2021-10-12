package Opgave5;

public class CopierApp {
    public static void main(String[] args) {
        Copier min = new Copier(450);
        min.makePaperJam();
        min.makeCopy();
        System.out.println("Papir efter print: " + min.getPaper());
        min.fixJam();
        min.insertPaper(11);
        System.out.println("Papir efter ekstra papir: " + min.getPaper());
        min.makeCopy(47);
        System.out.println("Papir efter stort print: " + min.getPaper());
    }
}
