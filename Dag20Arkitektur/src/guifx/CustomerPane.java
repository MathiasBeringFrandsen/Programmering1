package guifx;

import application.controller.Controller;
import application.model.Customer;
import application.model.Employee;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import storage.Storage;

import java.util.Optional;

public class CustomerPane extends GridPane {
    private TextField txfName, txfMoneySpent, txfCompany;
    private ListView<Customer> lvwCustomers;

    public CustomerPane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        Label lblComp = new Label("Customers");
        this.add(lblComp, 0, 0);

        lvwCustomers = new ListView<>();
        this.add(lvwCustomers, 0, 1, 1, 6);
        lvwCustomers.setPrefWidth(200);
        lvwCustomers.setPrefHeight(200);
        lvwCustomers.getItems().setAll(Controller.getCustomers());
        ChangeListener<Customer> listener = (ov, oldCustomer, newCustomer) -> this.selectedCustomerChanged();
        lvwCustomers.getSelectionModel().selectedItemProperty().addListener(listener);

        Label lblName = new Label("Name:");
        this.add(lblName, 1, 1);

        txfName = new TextField();
        this.add(txfName, 2, 1);
        txfName.setPrefWidth(200);
        txfName.setEditable(false);

        Label lblMoneySpent = new Label("Money Spent:");
        this.add(lblMoneySpent, 1, 2);

        txfMoneySpent = new TextField();
        this.add(txfMoneySpent, 2, 2);
        txfMoneySpent.setEditable(false);

        Label lblCompany = new Label("Company:");
        this.add(lblCompany, 1, 3);

        txfCompany = new TextField();
        this.add(txfCompany, 2, 3);
        txfCompany.setEditable(false);

        HBox hbxButtons = new HBox(40);
        this.add(hbxButtons, 0, 7, 3, 1);
        hbxButtons.setPadding(new Insets(10, 0, 0, 0));
        hbxButtons.setAlignment(Pos.BASELINE_CENTER);

        Button btnCreate = new Button("Create");
        hbxButtons.getChildren().add(btnCreate);
        btnCreate.setOnAction(event -> this.createAction());

        Button btnUpdate = new Button("Update");
        hbxButtons.getChildren().add(btnUpdate);
        btnUpdate.setOnAction(event -> this.updateAction());

        Button btnDelete = new Button("Delete");
        hbxButtons.getChildren().add(btnDelete);
        btnDelete.setOnAction(event -> this.deleteAction());

        if (lvwCustomers.getItems().size() > 0) {
            lvwCustomers.getSelectionModel().select(0);
        }
    }

    // -------------------------------------------------------------------------

    private void createAction() {
        EmployeeWindow dia = new EmployeeWindow("Create Employee");
        dia.showAndWait();

        // Wait for the modal dialog to close

        lvwCustomers.getItems().setAll(Controller.getCustomers());
        this.updateControls();
    }

    private void updateAction() {
        Customer customer = lvwCustomers.getSelectionModel().getSelectedItem();
        if (customer != null) {

            CustomerWindow dia = new CustomerWindow("Update Employee", customer);
            dia.showAndWait();

            // Wait for the modal dialog to close

            int selectIndex = lvwCustomers.getSelectionModel().getSelectedIndex();
            lvwCustomers.getItems().setAll(Controller.getCustomers());
            lvwCustomers.getSelectionModel().select(selectIndex);
        }
    }

    private void deleteAction() {
        Customer customer = lvwCustomers.getSelectionModel().getSelectedItem();
        if (customer != null) {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete Employee");
            // alert.setContentText("Are you sure?");
            alert.setHeaderText("Are you sure?");
            Optional<ButtonType> result = alert.showAndWait();

            // Wait for the modal dialog to close

            if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
//                Controller.removeCustomerFromCompany(customer);
                lvwCustomers.getItems().setAll(Controller.getCustomers());
                this.updateControls();
            }
        }

    }

    // -------------------------------------------------------------------------

    private void selectedCustomerChanged() {
        this.updateControls();
    }

    public void updateControls() {
        Customer customer = lvwCustomers.getSelectionModel().getSelectedItem();
        if (customer != null) {
            txfName.setText(customer.getName());
            txfMoneySpent.setText("kr " + customer.getMoneySpent());
//            txfCompany.setText();
        } else {
            txfName.clear();
            txfMoneySpent.clear();
            txfCompany.clear();
        }
    }
}
