package hrms.controller.framecontrollers;

import hrms.controller.entitycontrollers.SalaryController;
import hrms.model.entity.Salary;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class SalaryFrameController implements Initializable {

    @FXML
    DatePicker salaryDatePick;
    @FXML
    Button editBtn,addBtn,removeBtn;
    @FXML
    TableView salaryTbl;
    @FXML
    TextField employeeIdTxt,amountTxt,idTxt;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        showData();

        salaryTbl.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Salary salary = (Salary) salaryTbl.getSelectionModel().getSelectedItem();
                employeeIdTxt.setText(String.valueOf(salary.getEmployeeId()));
                amountTxt.setText(String.valueOf(salary.getAmount()));
            }
        });


        addBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String msg = SalaryController.add(Integer.parseInt(employeeIdTxt.getText()),
                        salaryDatePick.getValue().atStartOfDay().toLocalDate(),Integer.parseInt(amountTxt.getText()));
                Alert alert = new Alert(Alert.AlertType.INFORMATION, msg);
                alert.show();
                clearText();
                showData();
            }
        });

        editBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String msg = SalaryController.edit(Integer.parseInt(idTxt.getText()),Integer.parseInt(employeeIdTxt.getText()),
                        salaryDatePick.getValue().atStartOfDay().toLocalDate(),Integer.parseInt(amountTxt.getText()));
                Alert alert = new Alert(Alert.AlertType.INFORMATION, msg);
                alert.show();
                clearText();
                showData();
            }
        });

        removeBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
//                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you Sure?");
//                Optional optional = alert.showAndWait();
                SalaryController.remove(Integer.parseInt(employeeIdTxt.getText()));
                clearText();
                showData();
            }
        });


    }
    private void showData() {
        ObservableList observableList = FXCollections.observableList(SalaryController.findAll());

        salaryTbl.getColumns().clear();

        TableColumn<Salary, Integer> idCol = new TableColumn<>("شماره");
        idCol.setCellValueFactory(new PropertyValueFactory<Salary, Integer>("id"));

        TableColumn<Salary, Integer> employeeIdCol = new TableColumn<>("کد پرسنلی");
        employeeIdCol.setCellValueFactory(new PropertyValueFactory<Salary, Integer>("employeeId"));

        TableColumn<Salary, LocalDate> salaryLocalDateTableColumn = new TableColumn<>("تاریخ");
        salaryLocalDateTableColumn.setCellValueFactory(new PropertyValueFactory<Salary, LocalDate>("date"));

        TableColumn<Salary, Long> amountCol = new TableColumn<>("میزان");
        amountCol.setCellValueFactory(new PropertyValueFactory<Salary, Long>("amount"));

        salaryTbl.getColumns().addAll(idCol, employeeIdCol, salaryLocalDateTableColumn,amountCol);
        salaryTbl.setItems(observableList);
    }

    private void clearText() {
        employeeIdTxt.clear();
        amountTxt.clear();
    }
}
