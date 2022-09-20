package hrms.model.bl;

import hrms.model.da.FurloughDA;
import hrms.model.da.SalaryDA;
import hrms.model.entity.Furlough;
import hrms.model.entity.Salary;

import java.util.List;

public class SalaryBl {

    public static Salary add(Salary salary) throws Exception{
        try(SalaryDA salaryDA=new SalaryDA()){
            return salaryDA.add(salary);
        }
    }
    public static Salary edit(Salary salary) throws Exception{
        try(SalaryDA salaryDA=new SalaryDA()){
            return salaryDA.edit(salary);
        }
    } public static Salary remove(int id) throws Exception{
        try(SalaryDA salaryDA=new SalaryDA()){
            return salaryDA.remove(id);
        }
    }
    public static Salary findById(int id) throws Exception {
        try (SalaryDA salaryDA= new SalaryDA()) {
            return salaryDA.findById(id);
        }
    }
    public static List<Salary> findAll()throws Exception{
        try (SalaryDA salaryDA = new SalaryDA()) {
            return salaryDA.findAll();
        }
    }

}
