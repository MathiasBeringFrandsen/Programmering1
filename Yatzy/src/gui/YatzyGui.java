package gui;

import javafx.application.Application;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import application.model.Yatzy;

public class YatzyGui extends Application {


    @Override
    public void start(Stage stage) {
        stage.setTitle("Yatzy");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    // -------------------------------------------------------------------------

    // Shows the face values of the 5 dice.
    private TextField[] txfValues;
    // Shows the hold status of the 5 dice.
    private CheckBox[] chbHolds;
    // Shows the results previously selected .
    // For free results (results not set yet), the results
    // corresponding to the actual face values of the 5 dice are shown.
    private TextField[] txfResults;
    // Shows points in sums, bonus and total.
    private TextField txfSumSame, txfBonus, txfSumOther, txfTotal;
    // Shows the number of times the dice has been rolled.
    private Label lblRolled;
    private boolean[] lockedResults = new boolean[15];
    private Button btnRoll;
    private int numberOfDisabledFields = 0;

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        // ---------------------------------------------------------------------

        GridPane dicePane = new GridPane();
        pane.add(dicePane, 0, 0);
        dicePane.setGridLinesVisible(false);
        dicePane.setPadding(new Insets(10));
        dicePane.setHgap(10);
        dicePane.setVgap(10);
        dicePane.setStyle("-fx-border-color: black");

        // initialize txfValues, chbHolds, btnRoll and lblRolled
        txfValues = new TextField[5];
        for (int i = 0; i < txfValues.length; i++) {
            txfValues[i] = new TextField();
            dicePane.add(txfValues[i], i, 0);
            txfValues[i].setPrefWidth(60);
            txfValues[i].setPrefHeight(60);
            txfValues[i].setFont(Font.font("Arial", FontWeight.MEDIUM, 36));
        }

        chbHolds = new CheckBox[5];
        for (int i = 0; i < chbHolds.length; i++) {
            chbHolds[i] = new CheckBox("Hold");
            dicePane.add(chbHolds[i], i, 1);
            GridPane.setMargin(chbHolds[i], new Insets(0, 10, 10, 10));
            chbHolds[i].setDisable(true);
        }

        btnRoll = new Button("Roll");
        dicePane.add(btnRoll, 3, 2);
        btnRoll.setPrefHeight(40);
        btnRoll.setPrefWidth(60);
        btnRoll.setOnAction(event -> this.rollAction());

        lblRolled = new Label("Rolled: 0");
        dicePane.add(lblRolled, 4, 2);

        // ---------------------------------------------------------------------

        GridPane scorePane = new GridPane();
        pane.add(scorePane, 0, 1);
        scorePane.setGridLinesVisible(false);
        scorePane.setPadding(new Insets(10));
        scorePane.setVgap(5);
        scorePane.setHgap(10);
        scorePane.setStyle("-fx-border-color: black");
        int w = 50; // width of the text fields

        // Initialize labels for results, txfResults,
        // labels and text fields for sums, bonus and total.
        txfResults = new TextField[15];
        for (int i = 0; i < txfResults.length; i++) {
            txfResults[i] = new TextField();
            scorePane.add(txfResults[i], 1, i);
            txfResults[i].setPrefWidth(w);
            txfResults[i].setDisable(true);
            txfResults[i].setOnMouseClicked(event -> this.chooseFieldAction(event));
        }

        String[] labelArray = {"1's", "2's", "3's", "4's", "5's", "6's", "One Pair", "Two Pairs", "Three of a kind",
                "Four of a Kind", "Full House", "Small Straight", "Large Straight", "Chance", "Yatzy"};
        for (int i = 0; i < labelArray.length; i++) {
            Label lbl = new Label(labelArray[i]);
            scorePane.add(lbl, 0, i);
        }
//        , , ,
        txfSumSame = new TextField();
        scorePane.add(txfSumSame, 4, 5);
        txfSumSame.setPrefWidth(w);
        txfSumSame.setText("0");
        txfSumSame.setStyle("-fx-text-inner-color: blue");

        Label sumSame = new Label("Sum:");
        scorePane.add(sumSame, 3, 5);

        txfBonus = new TextField();
        scorePane.add(txfBonus, 6, 5);
        txfBonus.setPrefWidth(w);
        txfBonus.setText("0");
        txfBonus.setStyle("-fx-text-inner-color: blue");

        Label bonus = new Label("Bonus:");
        scorePane.add(bonus, 5, 5);

        txfSumOther = new TextField();
        scorePane.add(txfSumOther, 4, 14);
        txfSumOther.setPrefWidth(w);
        txfSumOther.setText("0");
        txfSumOther.setStyle("-fx-text-inner-color: blue");

        Label sumOther = new Label("Sum:");
        scorePane.add(sumOther, 3, 14);

        txfTotal = new TextField();
        scorePane.add(txfTotal, 6, 14);
        txfTotal.setPrefWidth(w);
        txfTotal.setText("0");
        txfTotal.setStyle("-fx-text-inner-color: blue");

        Label total = new Label("Total:");
        scorePane.add(total, 5, 14);

    }

    // -------------------------------------------------------------------------

    private Yatzy dice = new Yatzy();

    // Create a method for btnRoll's action.
    // Hint: Create small helper methods to be used in the action method.
    private void rollAction() {
        if (dice.getThrowCount() <= 2) {
            dice.throwDice(getHoldsList());
            lblRolled.setText("Rolled: " + dice.getThrowCount());
            updateValues();
        }
        if (dice.getThrowCount() == 3) {
            btnRoll.setDisable(true);
            updateResults();
            disableCheckBoxes();
            unlockResults();
            dice.resetThrowCount();
        }
    }

    private boolean[] getHoldsList() {
        boolean[] holds = new boolean[5];
        for (int i = 0; i < holds.length; i++) {
            holds[i] = chbHolds[i].isSelected();
            chbHolds[i].setDisable(false);
        }
        return holds;
    }

    private void updateValues() {
        for (int i = 0; i < txfValues.length; i++) {
            txfValues[i].setText("" + dice.getValues()[i]);
        }
    }

    private void updateResults() {
        for (int i = 0; i < txfResults.length; i++) {
            if (!lockedResults[i]) {
                txfResults[i].setText("" + dice.getResults()[i]);
            }
        }
    }

    private void disableCheckBoxes() {
        for (CheckBox chbHold : chbHolds) {
            chbHold.setDisable(true);
        }
    }

    private void unlockResults() {
        for (int i = 0; i < txfResults.length; i++) {
            if (!lockedResults[i]) {
                txfResults[i].setDisable(false);
            }
        }
    }

    // -------------------------------------------------------------------------

    // Create a method for mouse click on one of the text fields in txfResults.
    // Hint: Create small helper methods to be used in the mouse click method.
    public void chooseFieldAction(Event event) {
        TextField txt = (TextField) event.getSource();
        numberOfDisabledFields++;
        txt.setStyle("-fx-text-inner-color: blue");
        txt.setDisable(true);
        updateLocked();
        disableResults();
        setResultsToZero();
        calcSameValueSum();
        calcIfBonus();
        calcOtherSum();
        calcTotalSum();
        clearCheckBoxes();
        lblRolled.setText("Rolled: 0");
        btnRoll.setDisable(false);
        checkIsGameDone();
    }

    private void updateLocked() {
        for (int i = 0; i < lockedResults.length; i++) {
            lockedResults[i] = txfResults[i].isDisabled();
        }
    }

    private void disableResults() {
        for (TextField txfResult : txfResults) {
            txfResult.setDisable(true);
        }
    }

    private void setResultsToZero(){
        for (int i = 0; i < txfResults.length; i++){
            if (!lockedResults[i]){
                txfResults[i].setText("0");
            }
        }
    }

    private void calcSameValueSum() {
        int sum = 0;
        for (int i = 0; i < 6; i++) {
            if (lockedResults[i]) {
                sum = sum + Integer.parseInt(txfResults[i].getText());
            }
        }
        txfSumSame.setText("" + sum);
    }

    private void calcIfBonus() {
        if (Integer.parseInt(txfSumSame.getText()) >= 63) {
            txfBonus.setText("50");
        }
    }

    private void calcOtherSum() {
        int sum = 0;
        for (int i = 6; i < 15; i++) {
            if (lockedResults[i]) {
                sum = sum + Integer.parseInt(txfResults[i].getText());
            }
        }
        txfSumOther.setText("" + sum);
    }

    private void calcTotalSum() {
        int bonusSum = Integer.parseInt(txfBonus.getText());
        int sameSum = Integer.parseInt(txfSumSame.getText());
        int otherSum = Integer.parseInt(txfSumOther.getText());
        int sum = bonusSum + sameSum + otherSum;
        txfTotal.setText("" + sum);
    }

    private void clearCheckBoxes() {
        for (CheckBox chbHold : chbHolds) {
            chbHold.setSelected(false);
        }
    }

    private void checkIsGameDone() {
        if (numberOfDisabledFields >= 15) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Spillet er færdigt");
            alert.setContentText("Dine totale point er: " + txfTotal.getText().trim() + "\nTryk ok for at starte et nyt spil");
            alert.showAndWait();

            for (TextField txfValue : txfValues) {
                txfValue.setText("0");
            }

            for (TextField txfResult : txfResults) {
                txfResult.setText("0");
            }

            txfSumSame.setText("0");
            txfSumOther.setText("0");
            txfBonus.setText("0");
            txfTotal.setText("0");
            numberOfDisabledFields = 0;
        }
    }
}