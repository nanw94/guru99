package testCases;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;
import pageFactory.AccountRegPage;
import pageFactory.HomePage;


public class TestScript5 {
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
		public void AccountCreation() throws Exception{
			//go to home page
			driver.get(baseURL);
		    driver.manage().window().maximize();

			
			//click Account to make the submenu visible
			driver.findElement(By.xpath(".//*[@id='header']/div/div[2]/div/a/span[2]")).click();
			
			//click My account in the sub menu.
			driver.findElement(By.linkText("My Account")).click();
			Thread.sleep(3000);
			
			//switching to new window
		    for (String handle : driver.getWindowHandles()) {
		    	driver.switchTo().window(handle);
		    }
		    
		    driver.manage().window().maximize();
			//click create an account
			driver.findElement(By.linkText("Create an Account")).click();
			
			 //switching to new window
			 for (String handle : driver.getWindowHandles()) {
			    	driver.switchTo().window(handle);
			 }
			 
			 driver.manage().window().maximize();
			 //call page factory of AccountRegPage
			 AccountRegPage objAccountRegPage=new AccountRegPage(driver);
			 
			 
			 //create a new account
			 String fName="Nan04";
			 String lName="Wang";
			 objAccountRegPage.register(fName,lName, "nanw04@qq.com", "123456", "123456");
			 
			 
			 //verify welcome message is shown
			 String welcomeMsg = driver.findElement(By.cssSelector(".hello>strong")).getText();
			 String expMsg=("Hello, "+fName+" "+lName+"!");
			 System.out.println("Actual welcome message is: "+ welcomeMsg);
			 
			 
			 //verify registration is done
			  try {	    	
			    	assertEquals(welcomeMsg, expMsg);
				    } catch (Exception e) {
				    	e.printStackTrace();	    	
				    }
			 
			  
			  //
			
			 
			 
			 
			 
//			//switching to new window
//			 for (String handle : driver.getWindowHandles()) {
//				 driver.switchTo().window(handle);
//			 }
//			 
			//click on TV link
			driver.findElement(By.linkText("TV")).click();
			
			//add LG to wishlist
			driver.findElement(By.cssSelector(".add-to-links>li")).click();
			
//			//switching to new window
//			for (String handle : driver.getWindowHandles()) {
//				driver.switchTo().window(handle);
			
			//click share wishlist
			driver.findElement(By.xpath(".//*[@id='wishlist-view-form']/div/div/button[1]")).click();
			
			//add some text and click share button
			driver.findElement(By.id("email_address")).clear();
		    driver.findElement(By.id("email_address")).sendKeys("nanw94@foxmail.com");
		    driver.findElement(By.id("message")).clear();
		    driver.findElement(By.id("message")).sendKeys("this message was sent by an automation script");
		    driver.findElement(By.xpath(".//*[@id='form-validate']/div[2]/button")).click();
			
		    
		    //Check wishlist is shared. Expected wishlist shared successfully. 
		    String vWishList = "Your Wishlist has been shared.";
		    String wishList = driver.findElement(By.cssSelector(".success-msg>ul>li>span")).getText();
		    System.out.println("wishList = "+wishList);
		    try {	    	
		    	assertEquals(vWishList, wishList);
			    } catch (Exception e) {
			    	e.printStackTrace();	    	
			    }	
		    	    
		    Thread.sleep(2000);
		}

		
		@AfterTest
		public void tearDown() throws Exception {
			Thread.sleep(5000);
			driver.quit();
		}
}
		

