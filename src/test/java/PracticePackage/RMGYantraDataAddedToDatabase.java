package PracticePackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class RMGYantraDataAddedToDatabase {

	public static void main(String[] args) throws SQLException 
	{
			ChromeOptions opt=new ChromeOptions();
			opt.addArguments("--remote-allow-origins=*");
			WebDriver driver=new ChromeDriver(opt);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.get("http://rmgtestingserver:8084/");
			
			//Sign In
			driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
			driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
			driver.findElement(By.xpath("//button[.='Sign in']")).click();
			
			//Navigate to Projects
			driver.findElement(By.xpath("//a[.='Projects']")).click();
			driver.findElement(By.xpath("//span[.='Create Project']/..")).click();
			
			//Create Project
			String pName="ujetix_p";
			driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(pName);
			driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("hitendra");
			WebElement statusDropdown = driver.findElement(By.xpath("//label[.='Project Status ']/../select"));
			Select sel = new Select(statusDropdown);
			sel.selectByVisibleText("Created");
			driver.findElement(By.xpath("//input[@value='Add Project']")).click();
			
			Connection connect=null;
			try 
			{
				Driver drv=new Driver();
				DriverManager.registerDriver(drv);
				connect=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
				Statement statement = connect.createStatement();
				ResultSet result = statement.executeQuery("select * from project");
				List<String> projectName = new ArrayList<String>();
				while(result.next())
				{
					String name = result.getString(4);
					projectName.add(name);
				}
				int a=0;
				for(String n:projectName)
				{
					if(n.contains(pName))
					{
						System.out.println(pName+" Project is created SUCCESSFULLY");
						a++;
						break;
					}
				}
				if(a==0)
				{System.out.println(pName+" Project is NOT created");}
			} 
			
			finally 
			{
				connect.close();
			}
			
		}
		
			
	
}
