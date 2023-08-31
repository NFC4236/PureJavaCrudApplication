package schoolPack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

	    public Connection getConnection() {
	        String url = "jdbc:mysql://localhost:3306/school_system";
	        String user = "root";
	        String password = "root";
	        Connection connection = null;
	        try {
	            connection = DriverManager.getConnection(url, user, password);
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	        return connection;
	    }
     }


	


