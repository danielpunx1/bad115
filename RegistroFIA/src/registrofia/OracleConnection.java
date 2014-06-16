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
    public static String usr = "";
    public static String psw = "";
    
    public static Connection getConnection() throws Exception {
        String driver = "oracle.jdbc.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String username = "basenotas";
        String password = "basenotas";
        Class.forName(driver); // load JDBC-ODBC driver
        return DriverManager.getConnection(url, username, password);
    }

    public static String getUsr() {
        return usr;
    }

    public static void setUsr(String usr) {
        OracleConnection.usr = usr;
    }

    public static String getPsw() {
        return psw;
    }

    public static void setPsw(String psw) {
        OracleConnection.psw = psw;
    }
    
}
