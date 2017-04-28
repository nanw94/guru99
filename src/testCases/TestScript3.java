package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestScript3 {
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
			public void verifyQTYError(){
			//go to home page;
			driver.get(baseURL);
			
			//go to mobile page
			driver.findElement(By.linkText("Mobile")).click();
			
			//click add to cart button of Sony
			driver.findElement(By.xpath(".//*[@id='top']/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[3]/div/div[3]/button")).click();
			
			//update Quantity to 1000
			driver.findElement(By.xpath(".//*[@id='shopping-cart-table']/tbody/tr/td[4]/input")).clear();
			driver.findElement(By.xpath(".//*[@id='shopping-cart-table']/tbody/tr/td[4]/input")).sendKeys("1000");
			
			//click update button
			driver.findElement(By.xpath(".//*[@id='shopping-cart-table']/tbody/tr/td[4]/button")).click();
			
			//verify error message
			String actualMessage;
			String expectedMessage="* The maximum quantity allowed for purchase is 500.";
			actualMessage=driver.findElement(By.xpath(".//*[@id='shopping-cart-table']/tbody/tr/td[2]/p")).getText();
			AssertJUnit.assertEquals(expectedMessage, actualMessage);
			
			//empty cart
			driver.findElement(By.id("empty_cart_button")).click();
			
			//verify empty cart message
			String emptyMsg_Act;
			String emptyMsg_Exp="SHOPPING CART IS EMPTY";
			emptyMsg_Act=driver.findElement(By.xpath(".//*[@id='top']/body/div/div/div[2]/div/div/div[1]/h1")).getText();
			AssertJUnit.assertEquals(emptyMsg_Exp, emptyMsg_Act);

			
		
			
			
			
		}
}
