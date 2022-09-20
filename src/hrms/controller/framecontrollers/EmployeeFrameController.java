package hrms.controller.framecontrollers;

import hrms.controller.entitycontrollers.EmployeeController;
import hrms.controller.entitycontrollers.SalaryController;
import hrms.model.entity.Employee;
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
import java.util.Optional;
import java.util.ResourceBundle;

public class EmployeeFrameController implements Initializable {
    @FXML
    private TableView employeeTbl;
    @FXML
    private TextField nameTxt,lastNameTxt,nationalCodeTxt,fathersNameTxt,idTxt,phoneNumberTxt,passwordTxt;
    @FXML
    DatePicker dobDatePick,employmentDatePick;
    @FXML
    Button addBtn,editBtn,removeBtn;
    @Override
    public void initialize(URL location, ResourceBundle resources) {showData();

        employeeTbl.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Employee employee = (Employee) employeeTbl.getSelectionModel().getSelectedItem();
                idTxt.setText(String.valueOf(employee.getId()));
                nameTxt.setText(String.valueOf(employee.getName()));
                lastNameTxt.setText(String.valueOf(employee.getLastName()));
                nationalCodeTxt.setText(String.valueOf(employee.getNationalCode()));
                fathersNameTxt.setText(String.valueOf(employee.getFathersName()));
                phoneNumberTxt.setText(String.valueOf(employee.getPhoneNumber()));
                passwordTxt.setText(String.valueOf(employee.getPassword()));
            }
        });


        addBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String msg = EmployeeController.add(nameTxt.getText(),
                        lastNameTxt.getText(),fathersNameTxt.getText(),phoneNumberTxt.getText(),nationalCodeTxt.getText(),passwordTxt.getText()
                ,dobDatePick.getValue().atStartOfDay().toLocalDate(),employmentDatePick.getValue().atStartOfDay().toLocalDate());
                Alert alert = new Alert(Alert.AlertType.INFORMATION, msg);
                alert.show();
                clearText();
                showData();
            }
        });

        editBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String msg = EmployeeController.edit(Integer.parseInt(idTxt.getText()),nameTxt.getText(),
                        lastNameTxt.getText(),fathersNameTxt.getText(),phoneNumberTxt.getText(),
                        nationalCodeTxt.getText(),passwordTxt.getText()
                        ,dobDatePick.getValue().atStartOfDay().toLocalDate(),
                        employmentDatePick.getValue().atStartOfDay().toLocalDate());
                Alert alert = new Alert(Alert.AlertType.INFORMATION, msg);
                alert.show();
                clearText();
                showData();
            }
        });

        removeBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you Sure?");
                Optional optional = alert.showAndWait();
                EmployeeController.remove((nameTxt.getText()));
                clearText();
                showData();
            }
        });


    }
    private void showData() {

        //    int id;
        //    String name,lastName,fathersName,phoneNumber,nationalCode,password;
        //    LocalDate dob,employmentDate;
        ObservableList observableList = FXCollections.observableList(EmployeeController.findAll());
        employeeTbl.getColumns().clear();

        TableColumn<Employee, Integer> idCol = new TableColumn<>("کد پرسنلی");
        idCol.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("id"));

        TableColumn<Employee, String> nameCol = new TableColumn<>("نام");
        nameCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));

        TableColumn<Employee, String> lastNameCol = new TableColumn<>("نام خانوادگی");
        lastNameCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("lastName"));

        TableColumn<Employee, String> fathersNameCol = new TableColumn<>("نام پدر");
        fathersNameCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("fathersName"));

        TableColumn<Employee, String> nationalCodeCol = new TableColumn<>("کد ملی");
        nationalCodeCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("nationalCode"));

        TableColumn<Employee, String> phoneNumberCol = new TableColumn<>("شماره همراه");
        phoneNumberCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("phoneNumber"));

        TableColumn<Employee, LocalDate> dobCol = new TableColumn<>("تاریخ تولد");
        dobCol.setCellValueFactory(new PropertyValueFactory<Employee, LocalDate>("dob"));

        TableColumn<Employee, LocalDate> employmentDateCol = new TableColumn<>("تاریخ استخدام");
        employmentDateCol.setCellValueFactory(new PropertyValueFactory<Employee, LocalDate>("employmentDate"));


        TableColumn<Employee, String> passwordCol = new TableColumn<>("رمز عبور");
        passwordCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("password"));


        employeeTbl.getColumns().addAll(idCol,nameCol,lastNameCol,fathersNameCol,nationalCodeCol,phoneNumberCol
        ,dobCol,employmentDateCol,passwordCol);
        employeeTbl.setItems(observableList);
    }

    private void clearText() {
        idTxt.clear();
        nameTxt.clear();
        lastNameTxt.clear();
        passwordTxt.clear();
        phoneNumberTxt.clear();
        fathersNameTxt.clear();
        nationalCodeTxt.clear();
    }
}
