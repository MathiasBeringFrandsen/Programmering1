package Opgave5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Boys and Girls");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField txfName = new TextField();
    private final ListView<String> lvwBoysAndGirls = new ListView<>();
    private final ArrayList<String> boys = new ArrayList<>();
    private final ArrayList<String> girls = new ArrayList<>();
    private final ToggleGroup boysGirls = new ToggleGroup();
    private final RadioButton rbBoys = new RadioButton();
    private final RadioButton rbGirls = new RadioButton();
    private boolean showingBoys = true;


    private void initContent(GridPane pane) {
        this.initPersons();

        // pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblNames = new Label("Names:");
        pane.add(lblNames, 0, 1);
        GridPane.setValignment(lblNames, VPos.TOP);

        Label lblName = new Label("Name");
        pane.add(lblName, 0, 3);

        pane.add(txfName, 1, 3);

        Button btnAdd = new Button("Add");
        pane.add(btnAdd, 2, 3);
        btnAdd.setOnAction(event -> this.addAction());

        pane.add(lvwBoysAndGirls, 1, 1);
        lvwBoysAndGirls.setPrefWidth(200);
        lvwBoysAndGirls.setPrefHeight(200);
        lvwBoysAndGirls.getItems().setAll(boys);

        HBox box = new HBox(10);
        pane.add(box, 1, 0);
        box.getChildren().add(rbBoys);
        box.getChildren().add(rbGirls);

        rbBoys.setText("Boys");
        rbBoys.setToggleGroup(boysGirls);
        rbBoys.setOnAction(event -> this.showBoysAction());

        rbGirls.setText("Girls");
        rbGirls.setToggleGroup(boysGirls);
        rbGirls.setOnAction(event -> this.showGirlsAction());


    }

    // -------------------------------------------------------------------------

    private void initPersons() {
        boys.add("Jens");
        boys.add("Hans");
        boys.add("Per");
        boys.add("Søren");
        boys.add("Kim");

        girls.add("Lærke");
        girls.add("Camilla");
        girls.add("Nanna");
        girls.add("Ane");
        girls.add("Sara");
    }

    // -------------------------------------------------------------------------
    // Button actions

    private void addAction() {
        String name = txfName.getText().trim();
        if (name.length() > 0) {
            if (showingBoys) {
                boys.add(name);
                lvwBoysAndGirls.getItems().setAll(boys);
            } else {
                girls.add(name);
                lvwBoysAndGirls.getItems().setAll(girls);
            }
            txfName.clear();
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Add person");
            alert.setHeaderText("No named typed");
            alert.setContentText("Type the name of the person");
            alert.show();
        }
    }

    private void showBoysAction() {
        showingBoys = true;
        lvwBoysAndGirls.getItems().setAll(boys);
    }

    private void showGirlsAction() {
        showingBoys = false;
        lvwBoysAndGirls.getItems().setAll(girls);
    }
}