package hrms.model.bl;

import hrms.model.da.EmployeeDA;
import hrms.model.entity.Employee;

import java.sql.SQLException;
import java.util.List;

public class EmployeeBL {
    public static Employee add(Employee employee) throws Exception {
        try(EmployeeDA employeeDA=new EmployeeDA()){
            return  employeeDA.add(employee);
        }
    }
    public static Employee edit(Employee employee) throws Exception {
        try(EmployeeDA employeeDA=new EmployeeDA()){
            return employeeDA.edit(employee);
        }
    }
    public static Employee remove(String name) throws Exception {
        try (EmployeeDA employeeDA = new EmployeeDA()) {
            return employeeDA.remove(name);
        }
    }
    public static Employee findById(int id) throws Exception {
        try (EmployeeDA employeeDA = new EmployeeDA()) {
            return employeeDA.findById(id);
        }
    }
    public static List<Employee> findAll()throws Exception{
        try (EmployeeDA employeeDA = new EmployeeDA()) {
            return employeeDA.findAll();
        }
    }
}
