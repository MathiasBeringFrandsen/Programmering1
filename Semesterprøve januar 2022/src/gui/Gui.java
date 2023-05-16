package gui;

import application.controller.Controller;
import application.model.Løb;
import application.model.Note;
import application.model.Tilmelding;
import javafx.scene.control.*;
import storage.Storage;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.time.LocalDate;

public class Gui extends Application {

    public void init() {
        Controller.initStorage();
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("OCR Administrationssystem");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField txfVinder = new TextField();
    private final TextField txfForhindring = new TextField();
    private final TextField txfSekunder = new TextField();
    private final ListView<Løb> lvwLøb = new ListView<>();
    private final ListView<Tilmelding> lvwTilmeldinger = new ListView<>();
    private final ListView<Note> lvwNoter = new ListView<>();

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblLøb = new Label("Løb");
        pane.add(lblLøb, 0, 0);

        Label lblTilmeldinger = new Label("Tilmeldinger");
        pane.add(lblTilmeldinger, 2, 0);

        Label lblNoter = new Label("Noter");
        pane.add(lblNoter, 4, 0);

        Label lblForhindring = new Label("Navn forhindring");
        pane.add(lblForhindring, 2, 2);
        GridPane.setValignment(lblForhindring, VPos.TOP);

        Label lblStrafSekunder = new Label("Straf Sekunder");
        pane.add(lblStrafSekunder, 2, 3);

        Button btnVinder = new Button("Vinder");
        pane.add(btnVinder, 0, 2);
        btnVinder.setOnAction(event -> this.vinderAction());

        pane.add(txfVinder, 1, 2);
        txfVinder.setEditable(false);

        pane.add(txfForhindring, 3, 2);

        pane.add(txfSekunder, 3, 3);

        Button btnNote = new Button("Registrer note");
        pane.add(btnNote, 4, 3);
        btnNote.setOnAction(event -> this.noteAction());

        pane.add(lvwLøb, 0, 1, 2, 1);
        lvwLøb.setPrefWidth(250);
        lvwLøb.setPrefHeight(150);
        lvwLøb.getItems().setAll(Storage.getLøb());

        ChangeListener<Løb> løbListener = (ov, oldLøb, newLøb) -> this.selectedLøbChanged();
        lvwLøb.getSelectionModel().selectedItemProperty().addListener(løbListener);

        pane.add(lvwTilmeldinger, 2, 1, 2, 1);
        lvwTilmeldinger.setPrefWidth(200);
        lvwTilmeldinger.setPrefHeight(150);

        ChangeListener<Tilmelding> tilmeldingListener = (ov, oldTilmelding, newTilmelding) -> this.selectedTilmeldingChanged();
        lvwTilmeldinger.getSelectionModel().selectedItemProperty().addListener(tilmeldingListener);

        pane.add(lvwNoter, 4, 1);
        lvwNoter.setPrefWidth(200);
        lvwNoter.setPrefHeight(150);
    }


    // -------------------------------------------------------------------------


    private void selectedLøbChanged() {
        Løb løb = lvwLøb.getSelectionModel().getSelectedItem();
        if (løb != null) {
            lvwTilmeldinger.getItems().setAll(løb.getTilmeldinger());
        }
    }

    private void selectedTilmeldingChanged(){
        Tilmelding tilmelding = lvwTilmeldinger.getSelectionModel().getSelectedItem();
        if (tilmelding != null) {
            lvwNoter.getItems().setAll(tilmelding.getNoter());
        }
    }


    //-------------------------------------------------------------------------

    private void vinderAction(){
        Løb løb = lvwLøb.getSelectionModel().getSelectedItem();
        if (løb != null){
            txfVinder.setText(Controller.Vinder(løb));
        }
    }

    private void noteAction() {
        Tilmelding tilmelding = lvwTilmeldinger.getSelectionModel().getSelectedItem();
        if (tilmelding != null){
            Controller.createNote(txfForhindring.getText().trim(), Integer.parseInt(txfSekunder.getText()), tilmelding);
            lvwNoter.getItems().setAll(tilmelding.getNoter());
            txfSekunder.clear();
            txfForhindring.clear();
        }
    }
}
