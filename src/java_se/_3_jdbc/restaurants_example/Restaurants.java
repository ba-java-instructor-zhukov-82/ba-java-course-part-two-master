package java_se._3_jdbc.restaurants_example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;


public class Restaurants {
    private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String DB_NAME = "restaurantsDB";
    private static final String CREATE = "create=true";
    private static final String USER = "user=admin";
    private static final String PASSWORD = "password=root";
    private static final String DB_PROPERTIES = String.format("%s;%s;%s", CREATE, USER, PASSWORD);
    private static final String DB_URL = "jdbc:derby:" + DB_NAME + ";" + DB_PROPERTIES;

    private static final String TABLE_NAME = "restaurants";
    private static Connection conn = null;
    private static Statement stmt = null;

    public static void main(String[] args) {
        createConnection();
        createTable();
        insertRestaurants("LaVals", "Berkeley");
        selectRestaurants();
        //DerbyHelper.printTables(conn, DB_URL, TABLE_NAME);
        shutdown();
    }

    private static void createConnection() {
        try {
            Class.forName(DRIVER).newInstance();
            //Get a connection
            conn = DriverManager.getConnection(DB_URL);
        } catch (Exception except) {
            except.printStackTrace();
        }
    }

    private static void createTable() {
        try {
            if (!DerbyHelper.isSchemaExists(conn, DB_URL, TABLE_NAME)) {
                stmt = conn.createStatement();
                stmt.execute("CREATE TABLE " + TABLE_NAME + "\n" +
                        "(\n" +
                        "ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),\n" +
                        "NAME varchar(128),\n" +
                        "CITY varchar(128),\n" +
                        "CONSTRAINT primary_key PRIMARY KEY (ID)" +
                        ")");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertRestaurants(String restName, String cityName) {
        try {
            stmt = conn.createStatement();
            stmt.execute("insert into " + TABLE_NAME + "(NAME, CITY)" +
                        " values ('" + restName + "','" + cityName + "')");
            stmt.close();
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }
    }

    private static void selectRestaurants() {
        try {
            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("select * from " + TABLE_NAME);
            ResultSetMetaData rsmd = results.getMetaData();
            int numberCols = rsmd.getColumnCount();
            for (int i = 1; i <= numberCols; i++) {
                //print Column Names
                System.out.print(rsmd.getColumnLabel(i) + "\t\t");
            }

            System.out.println("\n-------------------------------------------------");

            while (results.next()) {
                int id = results.getInt(1);
                String restName = results.getString(2);
                String cityName = results.getString(3);
                System.out.println(id + "\t\t" + restName + "\t\t" + cityName);
            }
            results.close();
            stmt.close();
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }
    }

    private static void shutdown() {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                DriverManager.getConnection(DB_URL + ";shutdown=true");
                conn.close();
            }
        } catch (SQLException sqlExcept) {

        }

    }
}
