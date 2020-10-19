package storedProcedure;

import java.sql.*;

public class InParameters {

	public static void main(String[] args) {
		Connection connection;
		
		CallableStatement callableStatement;
			
		String dataBaseUrl = "jdbc:mysql://localhost:3306/cats";
			
		String user = "nqixt9";
		String password = "password";
			
		try 
		{
			System.out.println("14");
			
			connection = DriverManager.getConnection(dataBaseUrl, user, password);
			
			callableStatement = connection.prepareCall("{call set_cats_owner(?,?)}"); 
			
			callableStatement.setString(1, "Perzsa");
			
			callableStatement.setString(2, "Gal Dora");
			
			callableStatement.executeUpdate();
			
			callableStatement.close();
		}catch (Exception e)
		{				
			e.printStackTrace();
		}
	}

}
