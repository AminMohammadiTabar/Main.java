package hrms.controller.exceptionwrapper;

import java.io.IOException;
import java.sql.SQLException;

public class ExceptionWrapper {
    public static String getMessage(Exception exception){
        if(exception instanceof SQLException){
            return "خطای SQL: " + exception.getMessage();
        }
        else if(exception instanceof IOException){
            return "خطای ورودی و خروجی: " + exception.getMessage();
        }
        else if(exception instanceof ArithmeticException){
            return "خطای ریاضیاتی: " + exception.getMessage();
        }
        else if(exception instanceof ClassNotFoundException){
            return "خطای پیدا نشدن کلاس: " + exception.getMessage();
        }
        else {
            return "خطای ناشناخته: " + exception.getMessage();
        }
    }
}
