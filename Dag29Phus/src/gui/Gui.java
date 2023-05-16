package gui;

import application.controller.Controller;
import application.model.*;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import storage.Storage;

public class Gui extends Application {

    public void init() {
        Controller.createSomeObjects();
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("PAS");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField txfOpretBil = new TextField();
    private final ListView<Parkeringshus> lvwParkeringshuse = new ListView<>();
    private final ListView<String> lvwOptagnepladser = new ListView<>();

    private void initContent(GridPane pane) {

        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblParkeringshuse = new Label("Parkeringshuse");
        pane.add(lblParkeringshuse, 0, 0);

        Label lblBiler = new Label("Optagne pladser");
        pane.add(lblBiler, 1, 0);

        Label lblNames = new Label("Opret bil med nummer");
        pane.add(lblNames, 0, 2);

        pane.add(txfOpretBil, 1, 2);

        Button btnOpret = new Button("Opret");
        pane.add(btnOpret, 1, 3);
        btnOpret.setOnAction(event -> this.OpretAction());

        pane.add(lvwParkeringshuse, 0, 1);
        lvwParkeringshuse.setPrefWidth(200);
        lvwParkeringshuse.setPrefHeight(150);
        lvwParkeringshuse.getItems().setAll(Storage.getParkeringshuse());

        ChangeListener<Parkeringshus> listener = (ov, oldParkeringhus, newParkeringshus) -> this.selectionChanged();
        lvwParkeringshuse.getSelectionModel().selectedItemProperty().addListener(listener);

        lvwParkeringshuse.getSelectionModel().clearSelection();

        pane.add(lvwOptagnepladser, 1, 1);
        lvwOptagnepladser.setPrefWidth(200);
        lvwOptagnepladser.setPrefHeight(150);
    }


    // -------------------------------------------------------------------------


    private void selectionChanged() {
        Parkeringshus selected = lvwParkeringshuse.getSelectionModel().getSelectedItem();
        if (selected != null) {
            lvwOptagnepladser.getItems().setAll(selected.optagnePladser());
        }
    }


    //-------------------------------------------------------------------------

    private void OpretAction(){
        Controller.createBil(txfOpretBil.getText().trim());
        txfOpretBil.clear();
    }
}
