package CRUD;

import java.sql.*;

public class Insert {

	public static void main(String[] args) {
		Connection connection;
		
		PreparedStatement preparedStatement;
		
		String dataBaseUrl = "jdbc:mysql://localhost:3306/cats";
		
		String user = "nqixt9";
		String password = "password";
		
		try 
		{
			System.out.println("10");
			connection = DriverManager.getConnection(dataBaseUrl, user, password);
			
			preparedStatement = connection.prepareStatement("INSERT INTO cats (id,name,breed,age,owner)VALUES(?,?,?,?,?);");
			
			preparedStatement.setInt(1, 5);
			preparedStatement.setString(2, "Kandur");
			preparedStatement.setString(3, "Szfinx");
			preparedStatement.setInt(4, 28);
			preparedStatement.setString(5, "Dr Genya");
			
			preparedStatement.executeUpdate();
			
			preparedStatement.close();
		}catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}