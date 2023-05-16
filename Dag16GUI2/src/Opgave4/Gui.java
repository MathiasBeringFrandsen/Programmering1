package Opgave4;

import demo4listview.Person;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Boys");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField txfName = new TextField();
    private final ListView<String> lvwBoys = new ListView<>();
    private final ArrayList<String> boys = new ArrayList<>();

    private void initContent(GridPane pane) {
        this.initPersons();

        // pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblNames = new Label("Names:");
        pane.add(lblNames, 0, 0);
        GridPane.setValignment(lblNames, VPos.TOP);

        Label lblName = new Label("Name");
        pane.add(lblName, 0, 3);

        pane.add(txfName, 1, 3);

        Button btnAdd = new Button("Add");
        pane.add(btnAdd, 2, 3);
        btnAdd.setOnAction(event -> this.addAction());

        pane.add(lvwBoys, 1, 0);
        lvwBoys.setPrefWidth(200);
        lvwBoys.setPrefHeight(200);
        lvwBoys.getItems().setAll(boys);
    }

    // -------------------------------------------------------------------------

    private void initPersons() {
        boys.add("Jens");
        boys.add("Hans");
        boys.add("Per");
        boys.add("Søren");
        boys.add("Kim");
    }

    // -------------------------------------------------------------------------
    // Button actions

    private void addAction() {
        String name = txfName.getText().trim();
        if (name.length() > 0) {
            boys.add(name);
            lvwBoys.getItems().setAll(boys);
            txfName.clear();
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Add person");
            alert.setHeaderText("No named typed");
            alert.setContentText("Type the name of the person");
            alert.show();
        }
    }
}
