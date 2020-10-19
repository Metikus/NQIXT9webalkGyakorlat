package CRUD;

import java.sql.*;

public class Update {

	public static void main(String[] args) {
		Connection connection;
		
		PreparedStatement preparedStatement;
		
		String dataBaseUrl = "jdbc:mysql://localhost:3306/cats";
		
		String user = "nqixt9";
		String password = "password";
		
		try 
		{
			System.out.println("11");
			connection = DriverManager.getConnection(dataBaseUrl, user, password);
			
			preparedStatement = connection.prepareStatement("update cats SET owner = 'Piros Ferenc' WHERE breed = 'Sziami'");
			
			preparedStatement.executeUpdate();
			
			preparedStatement.close();
		}catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}