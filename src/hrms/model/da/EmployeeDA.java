package hrms.model.da;

import hrms.model.entity.Employee;
import hrms.utils.JDBCProvider;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*CREATE TABLE EMPLOYEE (ID NUMBER PRIMARY KEY,NAME NVARCHAR2(15),LAST_NAME NVARCHAR2(20),FATHERS_NAME NVARCHAR2(20)
                      ,PHONE_NUMBER NVARCHAR2(11),NATIONAL_CODE NVARCHAR2(10),PASS_WORD NVARCHAR2(20)
                      ,DOB DATE, DOE DATE);*/


public class EmployeeDA implements AutoCloseable {

    private Connection connection;
    private PreparedStatement preparedStatement;

    public EmployeeDA() throws SQLException {
        connection= JDBCProvider.getJdbcProvider().getConnection();
    }

    public Employee add(Employee employee) throws SQLException {
        preparedStatement=connection.prepareStatement("SELECT EMP_SEQ.NEXTVAL FROM DUAL");
        ResultSet resultSet=preparedStatement.executeQuery();
        employee.setId(resultSet.getInt("EMP_SEQ.NEXTVAL"));
        preparedStatement=connection.prepareStatement("INSERT INTO EMPLOYEE VALUES (EMP_SEQ.NEXTVAL,?,?,?,?,?,?,?,?)");
        preparedStatement.setString(1,employee.getName());
        preparedStatement.setString(2,employee.getLastName());
        preparedStatement.setString(3,employee.getFathersName());
        preparedStatement.setString(4,employee.getPhoneNumber());
        preparedStatement.setString(5,employee.getNationalCode());
        preparedStatement.setString(6,employee.getPassword());
        preparedStatement.setDate(7,Date.valueOf(employee.getDob()));
        preparedStatement.setDate(8, Date.valueOf(employee.getEmploymentDate()));
        preparedStatement.execute();
        return employee;
    }
    public Employee edit(Employee employee) throws SQLException {
        preparedStatement=connection.prepareStatement("UPDATE EMPLOYEE SET NAME=?,LAST_NAME=?,FATHERS_NAME=?," +
                "PHONE_NUMBER=?,NATIONAL_CODE=?,PASS_WORD=?,DOB=?,DOE=? WHERE ID=?");
        preparedStatement.setString(1,employee.getName());
        preparedStatement.setString(2,employee.getLastName());
        preparedStatement.setString(3,employee.getFathersName());
        preparedStatement.setString(4,employee.getPhoneNumber());
        preparedStatement.setString(5,employee.getNationalCode());
        preparedStatement.setString(6,employee.getPassword());
        preparedStatement.setDate(7,Date.valueOf(employee.getDob()));
        preparedStatement.setDate(8, Date.valueOf(employee.getEmploymentDate()));
        preparedStatement.setInt(9,employee.getId());
        preparedStatement.execute();
        return employee;
    }
    public Employee remove(String name) throws SQLException {
        preparedStatement=connection.prepareStatement("DELETE FROM EMPLOYEE WHERE NAME=?");
        preparedStatement.setString(1,name);
        preparedStatement.execute();
            return null;
    }
    public List<Employee> findAll() throws SQLException {
        List<Employee> employeeList=new ArrayList<>();
        preparedStatement=connection.prepareStatement("SELECT * FROM EMPLOYEE");
        ResultSet resultSet=preparedStatement.executeQuery();
        while(resultSet.next()){
            Employee employee=new Employee(resultSet.getInt("ID"),resultSet.getString("NAME")
                    ,resultSet.getString("LAST_NAME"),resultSet.getString("FATHERS_NAME")
                    ,resultSet.getString("PHONE_NUMBER"),resultSet.getString("NATIONAL_CODE")
                    ,resultSet.getString("PASS_WORD"),resultSet.getDate("DOB").toLocalDate()
                    ,resultSet.getDate("DOE").toLocalDate());
            employeeList.add(employee);
        }
        return employeeList;
    }
    public Employee findById(int id) throws SQLException {
        preparedStatement=connection.prepareStatement("SELECT * FROM EMPLOYEE WHERE ID=?");
        preparedStatement.setInt(1,id);
        ResultSet resultSet=preparedStatement.executeQuery();
            Employee employee=new Employee(resultSet.getInt("ID"),resultSet.getString("NAME")
                    ,resultSet.getString("LAST_NAME"),resultSet.getString("FATHERS_NAME")
                    ,resultSet.getString("PHONE_NUMBER"),resultSet.getString("NATIONAL_CODE")
                    ,resultSet.getString("PASS_WORD"),resultSet.getDate("DOB").toLocalDate()
                    ,resultSet.getDate("DOE").toLocalDate());
        return employee;
    }
    @Override
    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }

}
