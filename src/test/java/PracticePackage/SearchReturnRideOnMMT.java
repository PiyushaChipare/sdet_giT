package PracticePackage;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchReturnRideOnMMT {

	public static void main(String[] args) 
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.makemytrip.com/flights/");
		
		//For Return Round
		driver.findElement(By.xpath("//li[.='Round Trip']")).click();
		System.out.println("clicked on return round");
	
		//Enter From City
		driver.findElement(By.id("fromCity")).sendKeys("chennai");
		driver.findElement(By.xpath("//div[@class='calc60']/p[.='Chennai, India']")).click();
		System.out.println("from selected");
		
		//Enter To City
		driver.findElement(By.id("toCity")).sendKeys("goa");
		driver.findElement(By.xpath("//p[.='Goa - Dabolim Airport, India']")).click();
		System.out.println("to selected");
		
		Date date = new Date();
		String[] d = date.toString().split(" ");
		String day = d[0];
		String month = d[1];
		String date1 = d[2];
		String year = d[5];
		String tourDate=day+" "+month+" "+date1+" "+year;
	 
		if(tourDate.equals("Tue May 09 2023"))
		{
			System.out.println("SAME");
		}
		else
		{
			System.out.println(tourDate);
			System.out.println("Tue May 09 2023");
		}
		//Set Travel Date
		driver.findElement(By.xpath("//div[@aria-label='"+tourDate+"']")).click();
		System.out.println("start date selected");
		for(;;)
		{
			try 
			{
				System.out.println("Element to found");
				driver.findElement(By.xpath("//div[@aria-label='Tue Aug 08 2023']")).click();
				System.out.println("Element is clickable");
				break;
			}
			catch (Exception e) 
			{
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
				
			}
		}
		System.out.println("return date selected");
		
		//Set Travel and Class
		driver.findElement(By.xpath("//span[.='Travellers & Class']")).click();
		driver.findElement(By.xpath("//li[@data-cy='adults-2']")).click();
		driver.findElement(By.xpath("//li[.='Premium Economy']")).click();
		driver.findElement(By.xpath("//button[.='APPLY']")).click();
		System.out.println("class selected");
		
		//Search for this FLIGHT
		driver.findElement(By.xpath("//a[.='Search']")).click();
		System.out.println("DONE");
		
	}

}
