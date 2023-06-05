package PracticePackage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AmazonLinksInExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");
		List<WebElement> aTags = driver.findElements(By.xpath("//a"));
		
		//XLSX part
		FileInputStream fis=new FileInputStream("./src/test/resources/AmazonLinks.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
		for(int i=0;i<aTags.size();i++)
		{
			String link = aTags.get(i).getAttribute("href");
			wb.getSheet("Sheet1").createRow(i).createCell(0).setCellValue(link);
		}
		FileOutputStream fos=new FileOutputStream("./src/test/resources/AmazonLinks.xlsx");
		wb.write(fos);
		wb.close();
	}

}
