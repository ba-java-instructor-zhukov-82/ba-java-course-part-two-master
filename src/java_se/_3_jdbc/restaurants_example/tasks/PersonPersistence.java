package java_se._3_jdbc.restaurants_example.tasks;

import java_se._3_jdbc.restaurants_example.DerbyHelper;

import java.sql.*;
import java.util.Scanner;

public class PersonPersistence {

    private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String DB_NAME = "Persons Persistence DB";
    private static final String CREATE = "create=true";
    private static final String USER = "user=admin";
    private static final String PASSWORD = "password=root";
    private static final String DB_PROPERTIES = String.format("%s;%s;%s", CREATE, USER, PASSWORD);
    private static final String DB_URL = "jdbc:derby:" + DB_NAME + ";" + DB_PROPERTIES;

    private static final String TABLE_NAME = "PERSONS";
    private static Connection conn = null;
    private static Statement stmt = null;

    private static Person p = new Person();
    private static Scanner input = new Scanner(System.in);
    private static final int NUMBER_OF_PERSONS = 3;

    public static void main(String[] args) {
        createConnection();
        createTable();

        /*for(int i = 0; i < NUMBER_OF_PERSONS; ++i) {
            System.out.println("Please, enter First Name:");
            p.setFirstName(input.nextLine());
            System.out.println("Please, enter Last Name:");
            p.setLastName(input.nextLine());
            System.out.println("Please, enter Age:");
            p.setAge(Integer.parseInt(input.nextLine()));
            System.out.println(new String(new char[20]).replace('\0', '-'));
            insertPerson();
        }*/

        selectPersons();
        deletePersons();
        System.out.println("\n\n");
        selectPersons();
        updatePerson();
        System.out.println("\n\n");
        selectPersons();
        //DerbyHelper.printTables(conn, DB_URL, TABLE_NAME);
        shutdown();
    }

    private static void createConnection() {
        try {
            Class.forName(DRIVER).newInstance();
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
                        "FIRST_NAME varchar(128),\n" +
                        "LAST_NAME varchar(128),\n" +
                        "AGE INT,\n" +
                        "CONSTRAINT primary_key PRIMARY KEY (ID)" +
                        ")");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertPerson() {


        try {
            stmt = conn.createStatement();
            stmt.execute("insert into " + TABLE_NAME + "(FIRST_NAME, LAST_NAME, AGE)" +
                    " values ('" + p.getFirstName() + "','" + p.getLastName() + "', " + p.getAge() + ")");
            stmt.close();
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }
    }

    private static void selectPersons() {
        try {
            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("select * from " + TABLE_NAME);
            ResultSetMetaData rsmd = results.getMetaData();
            int numberCols = rsmd.getColumnCount();
            for (int i = 1; i <= numberCols; i++)
                System.out.print(rsmd.getColumnLabel(i) + "\t\t");

            System.out.println("\n-------------------------------------------------");

            while (results.next()) {
                int id = results.getInt(1);
                String firstName = results.getString(2);
                String lastName = results.getString(3);
                int age = results.getInt(4);
                System.out.println(id + "\t\t" + firstName + "\t\t" + lastName + "\t\t" + age);
            }
            results.close();
            stmt.close();
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }
    }

    private static void updatePerson() {
        try {
            Thread.sleep(2000);
            stmt = conn.createStatement();
            stmt.execute("UPDATE " + TABLE_NAME + " SET FIRST_NAME = 'Olenka'" +
                         "WHERE FIRST_NAME = 'Olena'");
            stmt.close();
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void deletePersons() {
        try {
            Thread.sleep(2000);
            stmt = conn.createStatement();
            stmt.execute("DELETE FROM " + TABLE_NAME + " WHERE FIRST_NAME = 'Mykola'");
            stmt.close();
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
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
