package januar2018.gui;

import januar2018.application.controller.Controller;
import januar2018.application.model.Arrangement;
import januar2018.application.model.Tutor;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import januar2018.storage.Storage;

public class Gui extends Application {

    public void init() {
        Controller.initStorage();
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("TAS");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField txfNavn = new TextField();
    private final TextField txfEmail = new TextField();
    private final ListView<Tutor> lvwTutorer = new ListView<>();
    private final ListView<Arrangement> lvwAlleArrangementer = new ListView<>();
    private final ListView<Arrangement> lvwTutorensArrangementer = new ListView<>();

    private void initContent(GridPane pane) {

        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblTutorer = new Label("Tutorer");
        pane.add(lblTutorer, 0, 0);

        Label lblNavn = new Label("Navn");
        pane.add(lblNavn, 1, 0);

        Label lblEmail = new Label("Email");
        pane.add(lblEmail, 1, 1);

        Label lblArrangementer = new Label("Arrangementer");
        pane.add(lblArrangementer, 1, 2);
        GridPane.setValignment(lblArrangementer, VPos.TOP);

        Label lblAlleArrangementer = new Label("Alle mulige arrangementer");
        pane.add(lblAlleArrangementer, 3, 1);

        pane.add(txfNavn, 2, 0);

        pane.add(txfEmail, 2, 1);

        Button btnFjern = new Button("Fjern");
        pane.add(btnFjern, 2, 3);
        btnFjern.setOnAction(event -> this.fjernAction());

        Button btnTilføj = new Button("Tilføj");
        pane.add(btnTilføj, 3, 3);
        btnTilføj.setOnAction(event -> this.tagVagtAction());

        pane.add(lvwTutorer, 0, 1 ,1, 3);
        lvwTutorer.setPrefWidth(250);
        lvwTutorer.setPrefHeight(150);
        lvwTutorer.getItems().setAll(Storage.getTutorer());

        ChangeListener<Tutor> tutorListener = (ov, oldTutor, newTutor) -> this.selectedTutorChanged();
        lvwTutorer.getSelectionModel().selectedItemProperty().addListener(tutorListener);

        pane.add(lvwTutorensArrangementer, 2, 2);
        lvwTutorensArrangementer.setPrefWidth(200);
        lvwTutorensArrangementer.setPrefHeight(150);

        pane.add(lvwAlleArrangementer, 3, 2);
        lvwAlleArrangementer.setPrefWidth(200);
        lvwAlleArrangementer.setPrefHeight(150);
        lvwAlleArrangementer.getItems().setAll(Storage.getArrangementer());
    }


    // -------------------------------------------------------------------------


    private void selectedTutorChanged() {
        Tutor selected = lvwTutorer.getSelectionModel().getSelectedItem();
        if (selected != null) {
            lvwTutorensArrangementer.getItems().setAll(selected.getArrangementer());
            txfNavn.setText(selected.getNavn());
            txfEmail.setText(selected.getEmail());
        }
    }


    //-------------------------------------------------------------------------

    private void tagVagtAction() {
        try {
            Arrangement arrangement = lvwAlleArrangementer.getSelectionModel().getSelectedItem();
            Tutor tutor = lvwTutorer.getSelectionModel().getSelectedItem();
            Controller.addArrangementToTutor(tutor, arrangement);
            lvwTutorensArrangementer.getItems().setAll(tutor.getArrangementer());
        } catch (RuntimeException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Overlap");
            alert.setHeaderText("Overlap");
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }

    private void fjernAction(){
        Arrangement arrangement = lvwTutorensArrangementer.getSelectionModel().getSelectedItem();
        Tutor tutor = lvwTutorer.getSelectionModel().getSelectedItem();
        Controller.fjernArrangementFraTutor(tutor, arrangement);
        lvwTutorensArrangementer.getItems().setAll(tutor.getArrangementer());
    }
}
