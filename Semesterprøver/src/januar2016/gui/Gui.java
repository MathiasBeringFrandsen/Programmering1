package januar2016.gui;

import januar2016.application.controller.Controller;
import januar2016.application.model.*;
import januar2016.storage.Storage;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.LocalTime;

public class Gui extends Application {

    public void init() {
        Controller.initStorage();
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Booking af tennsibaner");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField txfDato = new TextField();
    private final ListView<Bane> lvwBaner = new ListView<>();
    private final ListView<LocalTime> lvwLedigeTider = new ListView<>();

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

        pane.add(txfDato, 2, 0);

        Button btnFjern = new Button("Fjern");
        pane.add(btnFjern, 2, 3);
        btnFjern.setOnAction(event -> this.fjernAction());

        Button btnTilføj = new Button("Tilføj");
        pane.add(btnTilføj, 3, 3);
        btnTilføj.setOnAction(event -> this.tagVagtAction());

        pane.add(lvwBaner, 0, 1 ,1, 3);
        lvwBaner.setPrefWidth(250);
        lvwBaner.setPrefHeight(150);
        lvwBaner.getItems().setAll(Storage.getBaner());

        ChangeListener<Bane> baneListener = (ov, oldBane, newBane) -> this.selectedBaneChanged();
        lvwBaner.getSelectionModel().selectedItemProperty().addListener(baneListener);

        pane.add(lvwLedigeTider, 3, 2);
        lvwLedigeTider.setPrefWidth(200);
        lvwLedigeTider.setPrefHeight(150);
    }


    // -------------------------------------------------------------------------


    private void selectedBaneChanged() {
        Bane bane = lvwBaner.getSelectionModel().getSelectedItem();
        LocalDate dato = LocalDate.(txfDato.getText().trim());
        if (bane != null) {
            lvwLedigeTider.getItems().setAll(bane.getLedigeTiderPaaDag());
            txfDato.setText(bane.getNavn());
            txfEmail.setText(bane.getEmail());
        }
    }


    //-------------------------------------------------------------------------

    private void tagVagtAction() {
        try {
            Arrangement arrangement = lvwLedigeTider.getSelectionModel().getSelectedItem();
            Tutor tutor = lvwBaner.getSelectionModel().getSelectedItem();
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
        Tutor tutor = lvwBaner.getSelectionModel().getSelectedItem();
        Controller.fjernArrangementFraTutor(tutor, arrangement);
        lvwTutorensArrangementer.getItems().setAll(tutor.getArrangementer());
    }
}
