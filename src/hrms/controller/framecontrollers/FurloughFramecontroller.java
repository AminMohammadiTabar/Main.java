package hrms.controller.framecontrollers;

import hrms.controller.entitycontrollers.FurloughController;
import hrms.controller.entitycontrollers.SalaryController;
import hrms.model.entity.Furlough;
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

public class FurloughFramecontroller implements Initializable {

    @FXML
    DatePicker startDatePick,endDatePick;
    @FXML
    Button editBtn,addBtn,removeBtn;
    @FXML
    TableView furloughTbl;
    @FXML
    TextField employeeIdTxt;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        showData();

        furloughTbl.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Furlough furlough = (Furlough) furloughTbl.getSelectionModel().getSelectedItem();
                employeeIdTxt.setText(String.valueOf(furlough.getEmployeeId()));
            }
        });


        addBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String msg = FurloughController.add(Integer.parseInt(employeeIdTxt.getText()),
                        startDatePick.getValue().atStartOfDay().toLocalDate(),endDatePick.getValue().atStartOfDay().toLocalDate());
                Alert alert = new Alert(Alert.AlertType.INFORMATION, msg);
                alert.show();
                clearText();
                showData();
            }
        });

        editBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String msg = FurloughController.edit(Integer.parseInt(employeeIdTxt.getText()),Integer.parseInt(employeeIdTxt.getText()),
                        startDatePick.getValue().atStartOfDay().toLocalDate(),endDatePick.getValue().atStartOfDay().toLocalDate());
                Alert alert = new Alert(Alert.AlertType.INFORMATION, msg);
                alert.show();
                clearText();
                showData();
            }
        });

        removeBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FurloughController.remove(Integer.parseInt(employeeIdTxt.getText()));
                clearText();
                showData();
            }
        });


    }
    private void showData() {
        ObservableList observableList = FXCollections.observableList(FurloughController.findAll());

        furloughTbl.getColumns().clear();

        TableColumn<Furlough, Integer> idCol = new TableColumn<>("شماره");
        idCol.setCellValueFactory(new PropertyValueFactory<Furlough, Integer>("id"));

        TableColumn<Furlough, Integer> employeeIdCol = new TableColumn<>("کد پرسنلی");
        employeeIdCol.setCellValueFactory(new PropertyValueFactory<Furlough, Integer>("employeeId"));

        TableColumn<Furlough, LocalDate> startCol = new TableColumn<>("تاریخ شروع");
        startCol.setCellValueFactory(new PropertyValueFactory<Furlough, LocalDate>("start"));

        TableColumn<Furlough, Long> endCol = new TableColumn<>("تاریخ پایان");
        endCol.setCellValueFactory(new PropertyValueFactory<Furlough, Long>("end"));

        furloughTbl.getColumns().addAll(idCol, employeeIdCol,startCol,endCol);
        furloughTbl.setItems(observableList);
    }

    private void clearText() {
        employeeIdTxt.clear();
    }
}
