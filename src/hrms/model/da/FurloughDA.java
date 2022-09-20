package hrms.model.da;

/* CREATE TABLE FURLOUGH (ID NUMBER PRIMARY KEY ,EMPLOYEE_ID REFERENCES EMPLOYEE,START_DATE DATE,END_DATE DATE);*/

import hrms.model.entity.Furlough;
import hrms.utils.JDBCProvider;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FurloughDA implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public FurloughDA() throws SQLException {
        connection= JDBCProvider.getJdbcProvider().getConnection();
    }

    public Furlough add(Furlough furlough) throws SQLException {
        preparedStatement=connection.prepareStatement("INSERT INTO FURLOUGH VALUES (FUR_SEQ.NEXTVAL,?,?,?)");
        preparedStatement.setInt(1,furlough.getEmployeeId());
        preparedStatement.setDate(2, Date.valueOf(furlough.getStart()));
        preparedStatement.setDate(3, Date.valueOf(furlough.getEnd()));
        preparedStatement.execute();
        return furlough;
    }

    public Furlough edit(Furlough furlough) throws SQLException {
        preparedStatement=connection.prepareStatement("UPDATE FURLOUGH SET EMPLOYEE_ID=?,START_DATE=?,END_DATE=? " +
                "WHERE ID=?");
        preparedStatement.setInt(1,furlough.getEmployeeId());
        preparedStatement.setDate(2,Date.valueOf(furlough.getStart()));
        preparedStatement.setDate(3,Date.valueOf(furlough.getEnd()));
        preparedStatement.setInt(4,furlough.getId());
        preparedStatement.execute();
        return furlough;
    }

    public Furlough remove(int id) throws SQLException {
        preparedStatement=connection.prepareStatement("DELETE FROM FURLOUGH WHERE EMPLOYEE_ID=?");
        preparedStatement.setInt(1,id);
        preparedStatement.execute();
        return null;
    }

    public List<Furlough> findAll() throws SQLException {
        List<Furlough> furloughList=new ArrayList<>();
        preparedStatement= connection.prepareStatement("SELECT * FROM FURLOUGH");
        ResultSet resultSet=preparedStatement.executeQuery();
        while (resultSet.next()){
            Furlough furlough=new Furlough(resultSet.getInt(1),resultSet.getInt(2)
                    ,resultSet.getDate(3).toLocalDate(),resultSet.getDate(4).toLocalDate());
            furloughList.add(furlough);
        }
        return furloughList;
    }
    public Furlough findById(int id) throws SQLException {
        preparedStatement=connection.prepareStatement("SELECT * FROM FURLOUGH WHERE ID=?");
        preparedStatement.setInt(1,id);
        ResultSet resultSet=preparedStatement.executeQuery();
        Furlough furlough = new Furlough(resultSet.getInt(1),resultSet.getInt(2)
                ,resultSet.getDate(3).toLocalDate(),resultSet.getDate(4).toLocalDate());
        return furlough;
    }

    @Override
    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }
}
