package interviewDemo;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoQA 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\Chrome Driver\\chrome 97\\chromedriver.exe");
//		WebDriver drv = new ChromeDriver();
		ChromeDriver drv = new ChromeDriver();
		drv.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		drv.get("https://demoqa.com");
		drv.manage().window().maximize();
		
		//Scroll down page to see "Element"
		JavascriptExecutor js = (JavascriptExecutor) drv;
		js.executeScript("window.scrollBy(0,350)", " ");
		
		//Click on Element
		drv.findElement(By.xpath("//h5[contains(text(),'Elements')]")).click();
		
		//get the list under Element using findelements
		List<WebElement> list = drv.findElements(By.xpath("(//div[@class='element-group'])[1]/div/ul/li"));
		Iterator<WebElement> itr = list.iterator();
		while(itr.hasNext())
		{
			//Print only Check Box option from entire list
			String a = itr.next().getText();
		
			if (a.equals("Check Box"))
			{
				System.out.println(a);
				break;
			}
	
			//Print all options available in the list
			//System.out.println(itr.next().getText());
		}
		
//		drv.close();
		
//		drv.manage().window().maximize();

		
	}

}
