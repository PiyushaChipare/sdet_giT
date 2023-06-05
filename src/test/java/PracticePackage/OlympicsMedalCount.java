package PracticePackage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OlympicsMedalCount {

	public static void main(String[] args) 
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
		driver.findElement(By.xpath("//button[.='Yes, I am happy']")).click();
		
		//Country names
		List<WebElement> country = driver.findElements(By.xpath("//span[@data-cy='country-name']"));
		
		//Gold medals
		List<WebElement> gMedals = driver.findElements(By.xpath("//div[@title='Gold']"));
		
		//Silver medal
		 List<WebElement> sMedals = driver.findElements(By.xpath("//div[@title='Silver']"));
		 
		 //Bronze medal
		 List<WebElement> bMedals = driver.findElements(By.xpath("//div[@title='Bronze']"));
		 
		 //Total medal
		 List<WebElement> tMedals = driver.findElements(By.xpath("//div[@title='']"));
		
		List<String> cName = new ArrayList<String>();
		List<String> gold = new ArrayList<String>();
		List<String> silver = new ArrayList<String>();
		List<String> bronze = new ArrayList<String>();
		List<String> totalMedals = new ArrayList<String>();
		List<String> medalDetails = new ArrayList<String>();
		for(WebElement e:country)
		{
			cName.add(e.getText());			
		}
		for(WebElement e:gMedals)
		{
			gold.add(e.getText());
		}
		for(WebElement e:sMedals)
		{
			silver.add(e.getText());
		}
		for(WebElement e:bMedals)
		{
			bronze.add(e.getText());
		}
		for(WebElement e:tMedals)
		{
			totalMedals.add(e.getText());
		}		
		for(int i=0;i<cName.size();i++)
		{
			medalDetails.add(cName.get(i)+" "+gold.get(i)+" "+silver.get(i)+" "+bronze.get(i)+" "+totalMedals.get(i));
		}
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Country name to check medal details");
		String n=sc.next();
		for(String d:medalDetails)
		{
			
			if(d.contains(n))
			{
				System.out.println(d);
				break;
			}			
		}
	}

}
