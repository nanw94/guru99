package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pageFactory.HomePage;
import pageFactory.LoginPage;
import pageFactory.MyHome;

public class LocatorTest {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.gecko.driver","C:\\eclipse\\extension\\geckodriver-v0.11.1-win32\\geckodriver.exe");
		
		WebDriver driver=new FirefoxDriver();
		
//		driver.get("http://live.guru99.com/index.php/tv.html");
//		driver.findElement(By.cssSelector(".add-to-links>li")).click();
		driver.get("http://live.guru99.com");
		driver.manage().window().maximize();
		
		HomePage objHomePage=new HomePage(driver);
		objHomePage.goToLogin();
		
		LoginPage objLoginPage=new LoginPage(driver);
		objLoginPage.Login("nanw01@qq.com", "123456");
		Thread.sleep(2000);
		
		MyHome objMyHome=new MyHome(driver);
		objMyHome.goToMyWishlist();
		
		driver.get("http://live.guru99.com");
		
		driver.findElement(By.cssSelector(".level0.nav-2.last")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='top']/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[2]/ul/li[1]/a")).click();
	}
	
}
