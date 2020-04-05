import java.sql.*;

class DBConnect {
    String database_url = "jdbc:mysql://localhost:8888/test?";
    String username = "root";
    String password = "";
    String driver = "com.mysql.cj.jdbc.Driver";

    Connection connection;

    public DBConnect() {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(database_url, username, password);
            System.out.println("Connection successfull");
        } catch (ClassNotFoundException er) {
            System.out.println("Class Error" + er.getMessage());
        } catch (SQLException e) {
            System.out.println("Sql Error message=" + e.getMessage());
        }
    }
}
