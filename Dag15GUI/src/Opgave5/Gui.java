package Opgave5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {


    @Override
    public void start(Stage stage) {
        stage.setTitle("Celsius to fahrenheit");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField celsius = new TextField();
    private final TextField fahrenheit = new TextField();

    private void initContent(GridPane pane) {
        // show or hide grid lines
        pane.setGridLinesVisible(false);

        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        // add a label to the pane (at col=0, row=0)
        Label lblCelsius = new Label("Celsius:");
        pane.add(lblCelsius, 0, 0);

        Label lblFahrenheit = new Label("Fahrenheit:");
        pane.add(lblFahrenheit, 2, 0);

        // add a text field to the pane (at col=1, row=0, extending 2 columns and 1 row)
        // Deleted here is:
        // TextField txfName = new TextField();
        pane.add(celsius, 1, 0);
        pane.add(fahrenheit, 3, 0);


        // add a button to the pane (at col=1, row=1)
        Button btnCelsius = new Button("Celsius to fahrenheit");
        pane.add(btnCelsius, 1, 1);
        GridPane.setMargin(btnCelsius, new Insets(10, 10, 0, 10));

        // connect a method to the button
        btnCelsius.setOnAction(event -> this.celsiusToFahrenheit());

        // add a button to the pane (at col=2, row=1)
        Button btnFahrenheit = new Button("Fahrenheit to celsius");
        pane.add(btnFahrenheit, 3, 1);
        GridPane.setMargin(btnFahrenheit, new Insets(10, 10, 0, 10));

        // connect a method to the button
        btnFahrenheit.setOnAction(event -> this.FahrenheitToCelsius());
    }

    // -------------------------------------------------------------------------

    private void celsiusToFahrenheit() {
        int degrees = Integer.parseInt(celsius.getText().trim());
        fahrenheit.setText(degrees * (9/5.0) + 32 + "");
    }

    private void FahrenheitToCelsius() {
        int degrees = Integer.parseInt(fahrenheit.getText().trim());
        celsius.setText((int)((degrees - 32) * 5.0 / 9) + "");
    }
}
