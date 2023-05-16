package januar2018.gui;

import januar2018.application.controller.Controller;
import januar2018.storage.Storage;
import javafx.application.Application;

public class App {
    public static void main(String[] args) {
//        Controller.initStorage();
//
//        System.out.println(Controller.holdUdenTutorer());
//        System.out.println();
//        System.out.println(Storage.getUddannelser().get(0).tutorOversigt());
//        System.out.println();
//        System.out.println(Storage.getUddannelser().get(1).tutorOversigt());
//        System.out.println();
//        Controller.tutorOversigtTilFil("tutoroversigt.txt");

        Application.launch(Gui.class);
    }
}
