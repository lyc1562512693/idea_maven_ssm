package effective.instance.serverprovide;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class JDBCTest {
    public static void connect() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("","","");
        conn.prepareStatement("");
    }
}
