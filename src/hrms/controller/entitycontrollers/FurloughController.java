package hrms.controller.entitycontrollers;

import hrms.controller.exceptionwrapper.ExceptionWrapper;
import hrms.model.bl.FurloughBL;
import hrms.model.entity.Furlough;

import java.time.LocalDate;
import java.util.List;

public class FurloughController {
    public static String add(int employeeId, LocalDate start, LocalDate end){
        Furlough furlough=new Furlough(employeeId,start,end);
        try {
            FurloughBL.add(furlough);
        } catch (Exception e) {
            System.out.println(ExceptionWrapper.getMessage(e));
        }
        return furlough.toString();
    }
    public static String edit(int id, int employeeId, LocalDate start, LocalDate end){
        Furlough furlough=new Furlough(id,employeeId,start,end);
        try {
            FurloughBL.edit(furlough);
        } catch (Exception e) {
            System.out.println(ExceptionWrapper.getMessage(e));
        }
        return furlough.toString();
    }
    public static void remove(int id){
        try {
            FurloughBL.remove(id);
        }
        catch (Exception e){
            System.out.println(ExceptionWrapper.getMessage(e));
        }
    }
    public static List<Furlough> findAll(){
        try {
            return FurloughBL.findAll();
        } catch (Exception e) {
            System.out.println(ExceptionWrapper.getMessage(e));
            return null;
        }
    }
    public static Furlough findById(int id) {
        try {
            return FurloughBL.findById(id);
        } catch (Exception e) {
            System.out.println(ExceptionWrapper.getMessage(e));
            return null;
        }
    }
}
