package PracticePackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBCAddData {

	public static void main(String[] args) throws SQLException 
	{	
		Connection connect = null;
		try 
		{
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			
			//Create connection
			connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet48","root","TIGER");
			
			//Create Statement
			Statement statment = connect.createStatement();
			
			//Update Data in TABLE
			int res = statment.executeUpdate("insert into stud values(002,'HARSHITA','BENGALORE')");
			if(res==1)
				System.out.println("Data Added SUCCESFULLY");
			else
				System.out.println("Data NOT Added SUCCESFULLY");			
		} 
		finally {
			connect.close();
		}
	}

}
