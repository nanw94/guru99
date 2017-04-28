package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.*;

public class TestScript2{
	private WebDriver driver;

@BeforeMethod
	public void setup() throws Exception{
	System.setProperty("webdriver.gecko.driver","C:\\selenium\\geckodriver-v0.10.0-win64\\geckodriver.exe");
//	System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");

	driver= new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}

@Test
void verifyPrice() throws Exception{
	String outterPrice;//price shows on the mobile page
	String innerPrice;//price shows on the detail page
	driver.get("http://live.guru99.com/");
	driver.findElement(By.linkText("Mobile")).click();
	outterPrice=driver.findElement(By.cssSelector("#product-price-1 > span.price")).getText();
	driver.findElement(By.linkText("Sony Xperia")).click();
	innerPrice=driver.findElement(By.cssSelector("#product-price-1 > span.price")).getText();
	try{
		AssertJUnit.assertEquals(innerPrice, outterPrice);
		
	}
	
	catch(Exception e){
		System.out.println(e);
	}
	
	
}

}
