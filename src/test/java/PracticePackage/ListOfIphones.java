package PracticePackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ListOfIphones 
{
	public static void main(String[] args) 
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/s?k=iphone&crid=2RBFG65CTREZP&sprefix=iphone%2Caps%2C275&ref=nb_sb_noss_2");
		
		List<WebElement> mobileList = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		for(WebElement w:mobileList)
		{
			String mName = w.getText();
			String price = driver.findElement(By.xpath("//span[text()='"+mName+"']/../../../..//span[@class='a-price-whole']")).getText();
			System.out.println(mName+" "+price);
		}
		//driver.quit();
	}
}
