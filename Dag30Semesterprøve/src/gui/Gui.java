package gui;

import application.controller.Controller;
import application.model.Festival;
import application.model.Frivillig;
import application.model.Job;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import storage.Storage;

public class Gui extends Application {

    public void init() {
        Controller.initStorage();
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("FAS");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextArea txaTildelteJobs = new TextArea();
    private final TextField txfTildelTimer = new TextField();
    private final ListView<Festival> lvwFestivaller = new ListView<>();
    private final ListView<Job> lvwJobs = new ListView<>();
    private final ListView<Frivillig> lvwFrivillige = new ListView<>();

    private void initContent(GridPane pane) {

        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblFestivaller = new Label("Festivaller");
        pane.add(lblFestivaller, 0, 0);

        Label lblJobs = new Label("Jobs");
        pane.add(lblJobs, 1, 0);

        Label lblFrivillige = new Label("Frivillige");
        pane.add(lblFrivillige, 2, 0);

        Label lblTildelteJobs = new Label("Tildelte jobs");
        pane.add(lblTildelteJobs, 3, 0);

        Label lblTimer = new Label("Timer");
        pane.add(lblTimer, 0, 2);

        pane.add(txfTildelTimer, 1, 2);

        Button btnTagVagt = new Button("Tag vagt");
        pane.add(btnTagVagt, 2, 2);
        btnTagVagt.setOnAction(event -> this.tagVagtAction());

        pane.add(lvwFestivaller, 0, 1);
        lvwFestivaller.setPrefWidth(200);
        lvwFestivaller.setPrefHeight(150);
        lvwFestivaller.getItems().setAll(Storage.getFestivaller());

        ChangeListener<Festival> festivalListener = (ov, oldFestival, newFestival) -> this.selectedFestivalChanged();
        lvwFestivaller.getSelectionModel().selectedItemProperty().addListener(festivalListener);

        pane.add(lvwJobs, 1, 1);
        lvwJobs.setPrefWidth(200);
        lvwJobs.setPrefHeight(150);

        pane.add(lvwFrivillige, 2, 1);
        lvwFrivillige.setPrefWidth(200);
        lvwFrivillige.setPrefHeight(150);
        lvwFrivillige.getItems().setAll(Storage.getFrivillige());

        ChangeListener<Frivillig> frivilligListener = (ov, oldFrivillig, newFrivillig) -> this.selectedFrivilligChanged();
        lvwFrivillige.getSelectionModel().selectedItemProperty().addListener(frivilligListener);

        pane.add(txaTildelteJobs, 3, 1);
        txaTildelteJobs.setPrefWidth(200);
        txaTildelteJobs.setPrefHeight(150);
        txaTildelteJobs.setEditable(false);

    }


    // -------------------------------------------------------------------------


    private void selectedFestivalChanged() {
        Festival selected = lvwFestivaller.getSelectionModel().getSelectedItem();
        if (selected != null) {
            lvwJobs.getItems().setAll(selected.getJobs());
        }
    }

    private void selectedFrivilligChanged() {
        Frivillig selected = lvwFrivillige.getSelectionModel().getSelectedItem();
        if (selected != null) {
            txaTildelteJobs.setText(selected.jobsOutput().toString());
        }
    }


    //-------------------------------------------------------------------------

    private void tagVagtAction() {
        try {
            Job job = lvwJobs.getSelectionModel().getSelectedItem();
            Frivillig frivillig = lvwFrivillige.getSelectionModel().getSelectedItem();
            int timer = Integer.parseInt(txfTildelTimer.getText().trim());
            Controller.tagVagt(job, frivillig, timer);
            txfTildelTimer.clear();
            txaTildelteJobs.setText(frivillig.jobsOutput().toString());
        } catch (RuntimeException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("For lidt timer");
            alert.setHeaderText("For lidt timer");
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }
}
