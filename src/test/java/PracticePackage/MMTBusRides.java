package PracticePackage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MMTBusRides {

	public static void main(String[] args) 
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.makemytrip.com/");
		
		//Go to Buses Section
		driver.findElement(By.xpath("//li[@data-cy='menu_Buses']")).click();
		
		//Enter From
		WebElement from = driver.findElement(By.id("fromCity"));
		from.click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("pune");
		driver.findElement(By.xpath("//span[.='Pune, Maharashtra']")).click();
		driver.switchTo().activeElement().sendKeys("shirdi");
		driver.findElement(By.xpath("//span[.='Shirdi, Maharashtra']")).click();
		driver.findElement(By.xpath("//div[@aria-label='Thu May 11 2023']")).click();
		driver.findElement(By.id("search_button")).click();
		//List<WebElement> busList = driver.findElements(By.xpath("//div[@class='bus-card']//span[@class='latoBlack font22 blackText appendRight15']"));
		driver.findElement(By.xpath("//img[@class='blueArrow']")).click();
		driver.findElement(By.xpath("//span[.='Lowest Price']")).click();
		List<WebElement> bus = driver.findElements(By.xpath("//span[@class='latoBlack font22 blackText appendRight15']"));
		List<WebElement> price = driver.findElements(By.xpath("//span[@class='sc-ckVGcZ dYlDBG']"));
		List<String> busDetails = new ArrayList<String>();
		for(int i=0;i<bus.size();i++)
		{
			busDetails.add(bus.get(i).getText()+" "+price.get(i).getText());
			System.out.println(busDetails.get(i));
		}
		System.out.println("==========Cheapest Bus==========");
		System.out.println(busDetails.get(0));
		//driver.quit();
		
	}

}
