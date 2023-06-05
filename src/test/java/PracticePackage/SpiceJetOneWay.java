package PracticePackage;

import java.time.Duration;

import org.apache.commons.math3.analysis.function.Exp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SpiceJetOneWay {

	public static void main(String[] args) 
	{
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		opt.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.spicejet.com/");
		
		driver.findElement(By.xpath("//div[.='round trip' and @dir='auto']")).click();
		
		//FROM
		driver.findElement(By.xpath("//div[.='From']//input[@class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu']")).sendKeys("pnq");
		
		//TO
		driver.switchTo().activeElement().sendKeys("kol");
		
		// start DATE
		driver.switchTo().activeElement().findElement(By.xpath("//div[@data-testid='undefined-month-May-2023']//div[@data-testid='undefined-calendar-day-18']")).click();
		
		//end Date
		driver.findElement(By.xpath("//div[@data-testid='undefined-month-October-2023']//div[@data-testid='undefined-calendar-day-11']")).click();
		
		//Add Passengers
		driver.findElement(By.xpath("//div[@data-testid='home-page-travellers']")).click();
		driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).click();
		driver.findElement(By.xpath("//div[@data-testid='home-page-travellers-done-cta']")).click();
		
		//PAX Category
		//driver.findElement(By.xpath("//div[.='Family & Friends' and @dir='auto']")).click();
		
		//Search Flights
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(2000));
		
		WebElement search = driver.findElement(By.xpath("//div[@data-testid='home-page-flight-cta']"));
		wait.until(ExpectedConditions.visibilityOf(search));
		search.click();
		wait.until(ExpectedConditions.urlContains("PNQ"));
		String resultUrl = driver.getCurrentUrl();
		System.out.println(resultUrl);
		if(resultUrl.contains("PNQ"))
			System.out.println("Pass");
		else
			System.out.println("Fail");
	}

}
