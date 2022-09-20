package hrms.model.da;

import hrms.model.entity.Salary;
import hrms.utils.JDBCProvider;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SalaryDA implements AutoCloseable{
    private Connection connection;
    private PreparedStatement preparedStatement;

    public SalaryDA() throws SQLException {
        connection= JDBCProvider.getJdbcProvider().getConnection();
    }

    public Salary add(Salary salary) throws SQLException {
        preparedStatement=connection.prepareStatement("INSERT INTO SALARY VALUES (SAL_SEQ.NEXTVAL,?,?,?)");
        preparedStatement.setInt(1,salary.getEmployeeId());
        preparedStatement.setDate(2, Date.valueOf(salary.getDate()));
        preparedStatement.setLong(3,salary.getAmount());
        preparedStatement.execute();
        return salary;
    }

    public Salary edit(Salary salary)throws SQLException{
        preparedStatement=connection.prepareStatement("UPDATE SALARY SET EMPLOYEE_ID=?,S_DATE=?,AMOUNT=? WHERE ID=?");
        preparedStatement.setInt(1,salary.getEmployeeId());
        preparedStatement.setDate(2,Date.valueOf(salary.getDate()));
        preparedStatement.setLong(3,salary.getAmount());
        preparedStatement.setInt(4,salary.getId());
        preparedStatement.execute();
        return salary;
    }

    public Salary remove(int id) throws SQLException {
        preparedStatement=connection.prepareStatement("DELETE FROM SALARY WHERE Employee_ID=?");
        preparedStatement.setInt(1,id);
        preparedStatement.execute();
        return null;
    }

    public List<Salary> findAll() throws SQLException {
        List<Salary> salaryList =new ArrayList<>();
        preparedStatement=connection.prepareStatement("SELECT * FROM SALARY");
        ResultSet resultSet=preparedStatement.executeQuery();
        while(resultSet.next()){
            Salary salary=new Salary(resultSet.getInt(1),resultSet.getInt(2),
                    resultSet.getDate(3).toLocalDate(),resultSet.getLong(4));
            salaryList.add(salary);
        }
        return salaryList;
    }

    public Salary findById(int id) throws SQLException {
        preparedStatement=connection.prepareStatement("SELECT * FROM SALARY WHERE ID=?");
        ResultSet resultSet=preparedStatement.executeQuery();
        Salary salary=new Salary(resultSet.getInt(1),resultSet.getInt(2),
                resultSet.getDate(3).toLocalDate(),resultSet.getLong(4));
        return salary;
    }
    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }
}
