package PracticePackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBCRetriveFromRMG {

	public static void main(String[] args) throws SQLException 
	{
		Connection connect=null;
		try 
		{
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			connect=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
			Statement statement = connect.createStatement();
			ResultSet result = statement.executeQuery("select * from project;");
			
			while(result.next())
			{
				System.out.println(result.getString(1)+"  "+result.getString(2)+"  "+result.getString(3)+"  "+result.getString(4)+"  "+result.getString(5)+"  "+result.getString(6));
			}
		} 
		finally 
		{
			connect.close();
		}
	}

}
