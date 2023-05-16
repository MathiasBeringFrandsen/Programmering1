package Opgave2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {


    @Override
    public void start(Stage stage) {
        stage.setTitle("Ombyt tekst");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField txfNameOne = new TextField();
    private final TextField txfNameTwo = new TextField();

    private void initContent(GridPane pane) {
        // show or hide grid lines
        pane.setGridLinesVisible(false);

        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        // add a text field to the pane (at col=1, row=0, extending 2 columns and 1 row)
        // Deleted here is:
        // TextField txfName = new TextField();
        pane.add(txfNameOne, 0, 0);
        pane.add(txfNameTwo, 0, 1);

        // add a button to the pane (at col=1, row=1)
        Button btnUpperCase = new Button("Ombyt");
        pane.add(btnUpperCase, 0, 2);
        GridPane.setMargin(btnUpperCase, new Insets(10, 10, 0, 10));

        // connect a method to the button
        btnUpperCase.setOnAction(event -> this.bytTekst());

    }

    // -------------------------------------------------------------------------

    private void bytTekst() {
        String nameOne = txfNameOne.getText().trim();
        txfNameOne.setText(txfNameTwo.getText().trim());
        txfNameTwo.setText(nameOne);
    }

}
