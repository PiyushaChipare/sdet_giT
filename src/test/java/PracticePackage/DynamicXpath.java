package PracticePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicXpath {

	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		String countryName="India";
		String points = driver.findElement(By.xpath("//span[.='"+countryName+"']/../..//td[4]")).getText();
		System.out.println(countryName+" scored points "+points);
		driver.quit();
	}

}
