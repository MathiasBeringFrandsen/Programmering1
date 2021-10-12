package Opgave5;

public class Copier {
    private int paper;
    private boolean paperStuck;

    public Copier() {
        this.paper = 0;
        paperStuck = false;
    }

    public Copier(int paper) {
        this.paper = paper;
        paperStuck = false;
    }

    public void insertPaper(int paper) {
        if (this.paper + paper > 500) {
            System.out.println("Paper tray is full!");
        } else {
            this.paper = this.paper + paper;
        }
    }

    public int getPaper() {
        return paper;
    }

    public void makeCopy() {
        if (paperStuck) {
            System.out.println("Paper Stuck!");
        } else {
            if (paper > 0) {
                paper = paper - 1;
            } else {
                System.out.println("Not enough paper!");
            }
        }
    }

    public void makeCopy(int copies) {
        if (paperStuck) {
            System.out.println("Paper Stuck!");
        } else {
            if (paper >= copies) {
                paper = paper - copies;
            } else {
                System.out.println("Not enough paper!");
            }
        }
    }

    public void makePaperJam() {
        this.paperStuck = true;
    }

    public void fixJam() {
        paperStuck = false;
    }
}
