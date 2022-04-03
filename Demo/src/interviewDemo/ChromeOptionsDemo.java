package interviewDemo;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class ChromeOptionsDemo 
{
	
	public static void main(String[] args) throws IOException 
	{
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		opt.addArguments("disable-infobars");
		opt.addArguments("start-maximized");
		opt.addArguments("--incognito");
		opt.addArguments("version");
		
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\Chrome Driver\\chrome 98\\chromedriver.exe");
		WebDriver drv = new ChromeDriver(opt);
		
		drv.manage().deleteAllCookies();
		drv.manage().window().fullscreen();
		drv.manage().deleteAllCookies();
		
		drv.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		drv.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		Alert alt = drv.switchTo().alert();
		alt.accept();
		
		File sour = ((TakesScreenshot) drv).getScreenshotAs(OutputType.FILE);
		
		Date dt = new Date();
		
		String currdate = dt.toString();
		dt.getDate();
		
		File dest = new File("D:\\"+currdate+".jpg");
		FileHandler.copy(sour, dest);
		
		JavascriptExecutor js = ((JavascriptExecutor) drv);
		js.executeScript("window.scrollBy(0,300)", " ");
		
		Dimension dim = new Dimension(200, 100);
		drv.manage().window().setSize(dim);
		
		File f1 = new File("d:\\abc.xls");
		Workbook exl1 = WorkbookFactory.create(f1);
		
		Sheet sh1 = exl1.getSheet("sheet1");
		
		
		
		
	}
}