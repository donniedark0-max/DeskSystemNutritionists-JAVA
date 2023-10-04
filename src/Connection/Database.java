package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
private static final String URL = ""; //Poner la conexion a tu bd
    private static final String USER = "";
    private static final String PASSWORD = "";

    private Connection connection;
    private static Database instance;

    public static Database getInstance(){
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }
    private Database() {
        
    }
    
    public void connectToDatabase() throws SQLException {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to the database.");
        } catch (SQLException e) {
            System.err.println("Failed to connect to the database: " + e.getMessage());
        }
    }

   public Connection getConnection(){
       return connection;
   }
   
   public void setConnection(Connection connection){
       this.connection = connection;
   }

    public void closeConnection() {
    this.closeConnection();
    }    
    
}

