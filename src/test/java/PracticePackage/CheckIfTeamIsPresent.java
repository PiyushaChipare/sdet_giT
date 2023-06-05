package PracticePackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckIfTeamIsPresent {

	public static void main(String[] args) 
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		List<WebElement> countryList = driver.findElements(By.xpath("//span[@class='u-hide-phablet']"));
		String givenName="ggreece";
		int count=0;
		for(WebElement ele:countryList)
		{
			String cName = ele.getText();
			if(cName.equalsIgnoreCase(givenName))
			{
				count++;
				System.out.println(givenName+" EXISTS");
				break;
			}
		}
		if(count==0)
			System.out.println(givenName+" does NOT exist");
		driver.quit();
	}

}
