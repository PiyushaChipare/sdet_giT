package PracticePackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.mysql.cj.jdbc.Driver;

public class RMGYantraVerifyInApplicationDataAddedToDatabase {

	public static void main(String[] args) throws SQLException 
	{
		String pName = "UJETIX";
		Connection connect = null;
		try 
		{
			Driver drv=new Driver();
			DriverManager.registerDriver(drv);
			
			//Create connection
			connect=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
			
			//Create Statement
			Statement statment = connect.createStatement();
			
			//Update Data in TABLE
			int res = statment.executeUpdate("insert into project values('TY_PROJ_9999','piyusha','11/05/2023','"+pName+"','Created',0)");
			if(res==1)
				System.out.println("Data Added SUCCESFULLY");
			else
				System.out.println("Data NOT Added SUCCESFULLY");			
		} 
		finally {
			connect.close();
		}
		
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
		List<WebElement> pList = driver.findElements(By.xpath("//table[@class='table table-striped table-hover']//tr//td[2]"));
		int a=0;
		for(WebElement e:pList)
		{
			String projectName = e.getText();
			if(projectName.contains(pName))
			{
				a++;
				System.out.println(pName+" Project is Present");
				break;
			}
		}
		if(a==0)
		System.out.println(pName+" Project NOT is Present");

	}

}
