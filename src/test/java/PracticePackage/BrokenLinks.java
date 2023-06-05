package PracticePackage;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {

	public static void main(String[] args) 
	{
			WebDriverManager.firefoxdriver().setup();
			WebDriver driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get("https://www.amazon.in/ref=nav_logo");
			List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
			List<String> brokenLinks = new ArrayList<String>();
			for(WebElement ele:allLinks)
			{
				String link = ele.getAttribute("href");
				int statusCode=0;
					try
					{	URL url=new URL(link);
						URLConnection urlConnect = url.openConnection();
						HttpURLConnection httpUrlConnection = (HttpURLConnection)urlConnect;
						statusCode=httpUrlConnection.getResponseCode();
						if(statusCode>400)
						{
							brokenLinks.add(link+" "+statusCode);
						}
					}
					catch(Exception e)
					{
						brokenLinks.add(link+" "+statusCode);
						continue;
					}
			}
			for(String link:brokenLinks)
			{
				System.out.println(link);
			}
	}

}
