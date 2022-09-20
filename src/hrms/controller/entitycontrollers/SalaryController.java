package hrms.controller.entitycontrollers;

import hrms.controller.exceptionwrapper.ExceptionWrapper;
import hrms.model.bl.SalaryBl;
import hrms.model.entity.Salary;

import java.time.LocalDate;
import java.util.List;

public class SalaryController {
    public static String add(int employeeId, LocalDate date, long amount){
        Salary salary=new Salary(employeeId,date,amount);
        try {
            SalaryBl.add(salary);
        } catch (Exception e) {
            System.out.println(ExceptionWrapper.getMessage(e));
        }
        return salary.toString();
    }
    public static String edit(int id, int employeeId, LocalDate date, long amount){
        Salary salary=new Salary(id,employeeId,date,amount);
        try {
            SalaryBl.edit(salary);
        } catch (Exception e) {
            System.out.println(ExceptionWrapper.getMessage(e));
        }
        return salary.toString();
    }
    public static void remove(int id){
        try {
            SalaryBl.remove(id);
        }
        catch (Exception e){
            System.out.println(ExceptionWrapper.getMessage(e));
        }
    }
    public static List<Salary> findAll(){
        try {
            return SalaryBl.findAll();
        } catch (Exception e) {
            System.out.println(ExceptionWrapper.getMessage(e));
            return null;
        }
    }
    public static Salary findById(int id) {
        try {
            return SalaryBl.findById(id);
        } catch (Exception e) {
            System.out.println(ExceptionWrapper.getMessage(e));
            return null;
        }
    }
}
