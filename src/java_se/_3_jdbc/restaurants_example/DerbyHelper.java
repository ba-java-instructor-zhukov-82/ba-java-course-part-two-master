package java_se._3_jdbc.restaurants_example;

import java.sql.*;

public class DerbyHelper {

    public static boolean isSchemaExists(Connection conn, final String url, final String tableName)
                                         throws SQLException
    {
        Connection con = DriverManager.getConnection(url);
        ResultSet res = con.getMetaData().getTables(null, null, tableName.toUpperCase(), null);
        return res.next();
    }

    public static void printTables(Connection conn, final String url, final String tableName) {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url);
            ResultSet res = con.getMetaData().getTables(null, null, tableName.toUpperCase(), null);
            while(res.next())
                System.out.println(res.getString(3));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
