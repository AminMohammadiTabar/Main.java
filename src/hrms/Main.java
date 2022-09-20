package hrms;

import hrms.model.da.EmployeeDA;
import hrms.model.da.FurloughDA;
import hrms.model.entity.Employee;
import hrms.model.entity.Furlough;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.time.LocalDate;

import static javafx.application.Application.launch;

public class Main extends Application{
//    public static void main(String[] args) throws SQLException {
//        Employee employee=new Employee().setId(2).setName("Amin").setLastName("MT").setFathersName("davood")
//                .setNationalCode("0021134588").setDob(LocalDate.now()).setEmploymentDate(LocalDate.now())
//                .setPhoneNumber("09369368860").setPassword("09369368860");
////        Furlough furlough = new Furlough().setId(2).setEmployeeId(4).setStart(LocalDate.now()).setEnd(LocalDate.now());
//        EmployeeDA employeeDA=new EmployeeDA();
//        System.out.println(employeeDA.add(employee));
//    }
    public static void main(String[] args)  {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene=new Scene(FXMLLoader.load(getClass().getResource("employeeFrame.fxml")));
        primaryStage.setScene(scene);
        primaryStage.setTitle("salaryFrame");
        primaryStage.show();
    }
}
