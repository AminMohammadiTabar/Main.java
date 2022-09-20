package hrms.model.bl;

import hrms.model.da.EmployeeDA;
import hrms.model.da.FurloughDA;
import hrms.model.entity.Employee;
import hrms.model.entity.Furlough;

import java.util.List;

public class FurloughBL {
    public static Furlough add(Furlough furlough) throws Exception{
        try(FurloughDA furloughDA=new FurloughDA()){
            return furloughDA.add(furlough);
        }
    }
    public static Furlough edit(Furlough furlough) throws Exception{

        try(FurloughDA furloughDA=new FurloughDA()){
            return furloughDA.edit(furlough);
        }
    } public static Furlough remove(int id) throws Exception{
        try(FurloughDA furloughDA=new FurloughDA()){
            return furloughDA.remove(id);
        }
    }
    public static Furlough findById(int id) throws Exception {
        try (FurloughDA furloughDA= new FurloughDA()) {
            return furloughDA.findById(id);
        }
    }
    public static List<Furlough> findAll()throws Exception{
        try (FurloughDA furloughDA = new FurloughDA()) {
            return furloughDA.findAll();
        }
    }
}
