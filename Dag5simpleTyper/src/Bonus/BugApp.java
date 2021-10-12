package Bonus;

public class BugApp {
    public static void main(String[] args) {
        Bug bugsy = new Bug(0);
        System.out.println(bugsy.getPosition());
        bugsy.move();
        System.out.println(bugsy.getPosition());
        bugsy.move();
        bugsy.move();
        bugsy.move();
        bugsy.move();
        bugsy.move();
        bugsy.move();
        System.out.println(bugsy.getPosition());
        bugsy.turn();
        bugsy.move();
        bugsy.move();
        bugsy.move();
        System.out.println(bugsy.getPosition());
        bugsy.turn();
        bugsy.move();
        bugsy.move();
        bugsy.move();
        bugsy.move();
        bugsy.move();
        System.out.println(bugsy.getPosition());
    }

}
