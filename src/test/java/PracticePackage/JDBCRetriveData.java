package PracticePackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBCRetriveData {

	public static void main(String[] args) throws SQLException 
	{
		Connection connect=null;
		try 
		{
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet48","root","TIGER");
			Statement statement = connect.createStatement();
			ResultSet result = statement.executeQuery("select * from stud;");
			
			while(result.next())
			{
				System.out.println(result.getInt(1)+"  "+result.getString(2)+"  "+result.getString(3));
			}
		} 
		finally 
		{
			connect.close();
		}
		
	}

}
