package CRUD;

import java.sql.*;

public class Delete {

	public static void main(String[] args) {
		Connection connection;
			
		PreparedStatement preparedStatement;
			
		String dataBaseUrl = "jdbc:mysql://localhost:3306/cats";
			
		String user = "nqixt9";
		String password = "password";
			
		try 
		{
			System.out.println("12");
			connection = DriverManager.getConnection(dataBaseUrl, user, password);
			
			preparedStatement = connection.prepareStatement("delete from cats WHERE name = 'Perzsa' and owner='Gal Dora'");
			
			preparedStatement.executeUpdate();
			
			preparedStatement.close();
		}catch (Exception e)
		{				
			e.printStackTrace();
		}
	}

}
