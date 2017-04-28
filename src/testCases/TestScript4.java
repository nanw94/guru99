package testCases;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestScript4 {
		private WebDriver driver;
		private String baseURL="http://live.guru99.com";
		
		
		@BeforeMethod
			public void setup() throws Exception{
			System.setProperty("webdriver.gecko.driver","C:\\selenium\\geckodriver-v0.10.0-win64\\geckodriver.exe");
//			System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
		
			driver= new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			}
			
		
		
		
		
		@Test
			public void compareWindow() throws Exception{
			//go to home page;
			driver.get(baseURL);
			
			//Maximize window
			driver.manage().window().maximize();
			
			//go to mobile page
			driver.findElement(By.linkText("Mobile")).click();
			
			
			
			//add Sony to compare
			driver.findElement(By.xpath(".//*[@id='top']/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[3]/ul/li[2]/a")).click();
			                            
			//wait
			Thread.sleep(3000);
			
			//add iPhone to compare
			driver.findElement(By.xpath(".//*[@id='top']/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/div[3]/ul/li[2]/a")).click();
			
		
			//click compare button
			driver.findElement(By.xpath(".//*[@id='top']/body/div/div/div[2]/div/div[3]/div[1]/div[2]/div/button")).click();
			
			//switch to new window
			for (String handle : driver.getWindowHandles()) {
		    	driver.switchTo().window(handle);
		    	}
			//acquire info for checking
			
			
			//
			//close new window
			driver.findElement(By.xpath("//button[@title='Close Window']")).click();
		}
}
