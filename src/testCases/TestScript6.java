package testCases;


/* this test case will verify the purchase scenario from wish list
 * a valid account need to be created in prior
 * wish list should not be empty (will add something in wish list @before method)
 */

import static org.junit.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageFactory.CheckoutPage;
import pageFactory.HomePage;
import pageFactory.LoginPage;
import pageFactory.MyHome;

public class TestScript6 {
	private WebDriver driver;
	private String baseURL="http://live.guru99.com";
	String email_address_6="nanw03@qq.com";
	
	@BeforeTest
		public void setup() throws Exception{
//		System.setProperty("webdriver.gecko.driver","C:\\selenium\\geckodriver-v0.10.0-win64\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
	
//		driver= new FirefoxDriver();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		driver.get(baseURL);
		}
	
	@BeforeMethod
	//make sure wish list is not empty
		public void reloadWishList() throws Exception{
		
		HomePage objHomePage=new HomePage(driver);
		objHomePage.goToLogin();
		
		LoginPage objLoginPage=new LoginPage(driver);
		objLoginPage.Login(email_address_6, "123456");
		Thread.sleep(2000);
		
		//click TV
		driver.findElement(By.cssSelector(".level0.nav-2.last")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='top']/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[2]/ul/li[1]/a")).click();
		Thread.sleep(3000);
		
		//get back to home
		driver.get(baseURL);
		//log out
		MyHome objMyHome=new MyHome(driver);
		objMyHome.logOut();
	
		}
	
	@Test
	public void purchase() throws Exception{
	HomePage objHomePage=new HomePage(driver);
	objHomePage.goToLogin();
	
	LoginPage objLoginPage=new LoginPage(driver);
	objLoginPage.Login(email_address_6, "123456");
	Thread.sleep(2000);
	
	MyHome objMyHome=new MyHome(driver);
	objMyHome.goToMyWishlist();
	
	Thread.sleep(2000);
	//click ADD TO CART
	driver.findElement(By.cssSelector(".button.btn-cart")).click();
	Thread.sleep(2000);
	//click proceed to checkout
	driver.findElement(By.cssSelector(".button.btn-proceed-checkout.btn-checkout")).click();
	
	
	//if there is a existing address then then we have to select new address to proceed
	
	boolean existAddress= driver.findElement(By.id("billing-address-select")).isDisplayed();
	if(existAddress){
		Select addressDropdown= new Select(driver.findElement(By.cssSelector("#billing-address-select")));
		addressDropdown.selectByVisibleText("New Address");
	}
	
	//BILLING INFORMATION and continue
	CheckoutPage objCheckoutPage=new CheckoutPage(driver);
	
	objCheckoutPage.checkout("ABC", "New York", "New York", "542896", "United States", "12345678");
	
	
	//Verify shipping cost generated
    String sFlatRate = "Flat Rate";
    String flatRate = driver.findElement(By.xpath(".//*[@id='checkout-shipping-method-load']/dl/dt")).getText();	
    try {
    	System.out.println("sFlatRate = "+sFlatRate);
    	System.out.println("flatRate = "+flatRate);
    	assertEquals(sFlatRate, flatRate);
	    } catch (Exception e) {
	    	e.printStackTrace();	    	
	    }	
		
    	Thread.sleep(2000);
    //click continue
    	driver.findElement(By.xpath(".//*[@id='shipping-method-buttons-container']/button/span")).click();
    
    
    
    //select check radio button
    	driver.findElement(By.cssSelector("#checkout-payment-method-load>dt>label")).click();
    	
    //click continue
    	driver.findElement(By.xpath(".//*[@id='payment-buttons-container']/button")).click();
    	Thread.sleep(5000);
    	
    
    //click place order
    	driver.findElement(By.xpath(".//*[@id='review-buttons-container']/button")).click();
    	Thread.sleep(5000);
    //verify order placed
    	String confirmMsg=driver.findElement(By.xpath(".//*[@id='top']/body/div/div/div[2]/div/div/div[1]/h1")).getText();
    	String expectedMsg="YOUR ORDER HAS BEEN RECEIVED.";
    	
    	try{
    	assertEquals(expectedMsg,confirmMsg);
    	}catch (Exception e) {
    	e.printStackTrace();
    	}	    	
    	
    	
    //print order#
    	String orderNumber = driver.findElement(By.cssSelector(".col-main>p>a")).getText();
    	System.out.println("Order number is: "+orderNumber);
    }	
    	

	
	
	@AfterMethod
	public void clearWishList() throws Exception{
		//get back to home page
		driver.get(baseURL);
		Thread.sleep(3000);
		
		//call goToLogin to retrieve My Account Page (won't go to login as we are currently logged in)
		HomePage objHomePage=new HomePage(driver);
		objHomePage.goToLogin();
		Thread.sleep(3000);
		
		MyHome objMyHome=new MyHome(driver);
		objMyHome.goToMyWishlist();
		Thread.sleep(3000);
		
		//if wish list is empty, quit and finished
		if (driver.findElement(By.xpath(".//*[@id='wishlist-view-form']/div/p")).isDisplayed()){
			driver.quit();
			
		}else{
			
			//add all to cart (since there is no empty wish list button
			//we have to empty all items by add them all to cart and then empty cart)
			
			
			driver.findElement(By.xpath(".//*[@id='shipping-method-buttons-container']/button")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(".//*[@id='empty_cart_button']")).click();
			driver.quit();
		}
		
		
	
	}
	
}

	
