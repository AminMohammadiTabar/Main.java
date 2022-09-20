package hrms.controller.entitycontrollers;

import hrms.controller.exceptionwrapper.ExceptionWrapper;
import hrms.model.bl.EmployeeBL;
import hrms.model.entity.Employee;

import java.time.LocalDate;
import java.util.List;

public class EmployeeController {
    public static String add(String name, String lastName, String fathersName, String phoneNumber, String nationalCode,
                      String password, LocalDate dob, LocalDate employmentDate ){
        Employee employee=new Employee(name,lastName,fathersName,phoneNumber,nationalCode,password,dob,employmentDate);
        try{
            EmployeeBL.add(employee);
        } catch (Exception e) {
            System.out.println(ExceptionWrapper.getMessage(e));
        }
        return employee.toString();
    }
    public static String edit(int id, String name, String lastName, String fathersName, String phoneNumber, String nationalCode,
                       String password, LocalDate dob, LocalDate employmentDate){
        Employee employee=new Employee(id,name,lastName,fathersName,phoneNumber,nationalCode,password,dob,employmentDate);
        try{
            EmployeeBL.edit(employee);
        } catch (Exception e) {
            System.out.println(ExceptionWrapper.getMessage(e));
        }
        return employee.toString();
    }
    public static void remove(String name){
        try {
            EmployeeBL.remove(name);
        }
        catch (Exception e){
            System.out.println(ExceptionWrapper.getMessage(e));
        }
    }
    public static List<Employee> findAll(){
        try {
        return EmployeeBL.findAll();
        } catch (Exception e) {
            System.out.println(ExceptionWrapper.getMessage(e));
            return null;
        }
    }
    public static Employee findById(int id) {
        try {
        return EmployeeBL.findById(id);
        } catch (Exception e) {
            System.out.println(ExceptionWrapper.getMessage(e));
            return null;
        }
    }
}
