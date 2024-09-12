package services;

import java.sql.*;

public class DataBaseService {

    static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";

    static final String DATABASE_TYPE = "postgresql";
    static final String SERVER_URL = "localhost";
    static final String PORT = "5432";
    static final String DB_NAME = "postgres";

    static final String USERNAME = "postgres";
    static final String PASSWORD = "postgres";

    private String JDBC_URL;

    private static Connection connection;
    private static Statement statement;

    public DataBaseService() {
        JDBC_URL = "jdbc:" + DATABASE_TYPE + "://" + SERVER_URL + ":" + PORT + "/" + DB_NAME;

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static Statement getStatement() {
        try {
            if (statement == null) {
                statement = connection.createStatement();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return statement;
    }

    public void executeSQL(String sql) {
        try {
            System.out.println("Executing SQL: " + sql);
            System.out.println(getStatement().execute(sql));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet executeQuery(String sql) {
        try {
            System.out.println("Executing SQL: " + sql);
            return getStatement().executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
