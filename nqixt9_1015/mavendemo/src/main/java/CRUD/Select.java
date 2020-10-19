package CRUD;

import java.sql.*;
public class Select {

	public static void main(String[] args) {
		Connection connection;
		
		PreparedStatement preparedStatement;
		
		ResultSet resultSet;
		
		String dataBaseUrl = "jdbc:mysql://localhost:3306/cats";
		
		String user = "nqixt9";
		String password = "password";
		
		try 
		{
			System.out.println("8");
			connection = DriverManager.getConnection(dataBaseUrl, user, password);
			
			preparedStatement = connection.prepareStatement("select * from cats");
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				String name = resultSet.getString("name");
				String breed = resultSet.getString("breed");
				int age = resultSet.getInt("age");
				String owner = resultSet.getString("owner");
				
				System.out.println(name + " " + breed + " " + age + " " + owner);
			}
			preparedStatement.close();
			
			System.out.println();
			
			String selectAgeMoreThan1 = "select * from cats where age > ?";
			
			preparedStatement = connection.prepareStatement(selectAgeMoreThan1);
			
			preparedStatement.setInt(1, 1);
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				String name = resultSet.getString("name");
				String breed = resultSet.getString("breed");
				int age = resultSet.getInt("age");
				String owner = resultSet.getString("owner");
				
				System.out.println(name + " " + breed + " " + age + " " + owner);
			}
			preparedStatement.close();
			
			
			System.out.println("9");
			
			String changeAge = "UPDATE cats SET age = 2 WHERE age = ?";
			
			preparedStatement = connection.prepareStatement(changeAge);
			
			preparedStatement.setInt(1, 5);
			
			preparedStatement.executeUpdate();
			
			preparedStatement.close();
			
			preparedStatement = connection.prepareStatement("select * from cats where age = 2");
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				String name = resultSet.getString("name");
				String breed = resultSet.getString("breed");
				int age = resultSet.getInt("age");
				String owner = resultSet.getString("owner");
				
				System.out.println(name + " " + breed + " " + age + " " + owner);
			}
			preparedStatement.close();
			
			
			System.out.println("10a");
			
			preparedStatement = connection.prepareStatement("select * from cats");
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				String name = resultSet.getString("name");
				String breed = resultSet.getString("breed");
				int age = resultSet.getInt("age");
				String owner = resultSet.getString("owner");
				
				System.out.println(name + " " + breed + " " + age + " " + owner);
			}
			preparedStatement.close();
			
		}catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
