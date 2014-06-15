/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package registrofia;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author anderson
 */
public class OracleConnection {
    
    public static Connection getConnection() throws Exception {
        String driver = "oracle.jdbc.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String username = "notasfia";
        String password = "1234567";
        Class.forName(driver); // load JDBC-ODBC driver
        return DriverManager.getConnection(url, username, password);
    }
}