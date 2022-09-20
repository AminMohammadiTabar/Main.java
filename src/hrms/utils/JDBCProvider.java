package hrms.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCProvider {
    //singleton
    private static JDBCProvider jdbcProvider = new JDBCProvider();

    public JDBCProvider() {
    }
    public static JDBCProvider getJdbcProvider(){
        return jdbcProvider;
    }
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","javase","java123");
    }
}
