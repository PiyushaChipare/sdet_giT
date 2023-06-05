package PracticePackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchRideOnMMT {

	public static void main(String[] args) 
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.get("https://www.makemytrip.com/flights/");
		
		//Enter From City
		driver.findElement(By.id("fromCity")).sendKeys("chennai");
		driver.findElement(By.xpath("//div[@class='calc60']/p[.='Chennai, India']")).click();
		
		//Enter To City
		driver.findElement(By.id("toCity")).sendKeys("goa");
		driver.findElement(By.xpath("//p[.='Goa - Dabolim Airport, India']")).click();
		
		//Set Travel Date
		driver.findElement(By.xpath("//div[@aria-label='Mon May 15 2023']")).click();
		
		//Set Traveller and Class
		driver.findElement(By.xpath("//span[.='Travellers & Class']")).click();
		driver.findElement(By.xpath("//li[@data-cy='adults-2']")).click();
		driver.findElement(By.xpath("//li[.='Premium Economy']")).click();
		driver.findElement(By.xpath("//button[.='APPLY']")).click();
		
		//Search for this FLIGHT
		driver.findElement(By.xpath("//a[.='Search']")).click();
		System.out.println("DONE");
		
	}

}
