package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.AssertJUnit;
import org.testng.annotations.*;
import pageFactory.HomePage;

import static org.junit.Assert.assertEquals;

import java.io.File;
import org.apache.commons.io.FileUtils;

public class TestScript1 {
private WebDriver driver;
private String BaseUrl;

@BeforeMethod
public void setUp() throws Exception{
	System.setProperty("webdriver.gecko.driver","C:\\selenium\\geckodriver-v0.10.0-win64\\geckodriver.exe");
//	System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
//	driver=new ChromeDriver();
	driver=new FirefoxDriver();
	BaseUrl="http://live.guru99.com";
	driver.get(BaseUrl);
	
}
@Test
//Test1: verify "This is demo site for" is displayed on home page.
public void verifyDemoText(){
	String demoText=driver.findElement(By.cssSelector("h2")).getText();
	AssertJUnit.assertEquals("THIS IS DEMO SITE FOR   ", demoText);
	System.out.println(demoText);
}


//Test2: verify Title of the Mobile Page .
@Test
public void verifyMobilePageTitle() throws Exception{
	HomePage objHomePage=new HomePage(driver);
	objHomePage.goToMobile();
	Thread.sleep(5000);
	String MobilePageTitle=driver.getTitle();
	assertEquals(MobilePageTitle,"Mobile");
}
//Test3: verify Mobile is shown on Mobile Page

@Test
public void verifyMobileText() throws Exception{
	HomePage objHomePage=new HomePage(driver);
	objHomePage.goToMobile();
	Thread.sleep(3000);
	String mobileText=driver.findElement(By.linkText("Mobile")).getText();
	AssertJUnit.assertEquals("MOBILE", mobileText);
	System.out.println(mobileText);
}

@Test
public void verifyNameSelection() throws Exception{
	int scc = 0;
	HomePage objHomePage=new HomePage(driver);
	objHomePage.goToMobile();
	Thread.sleep(3000);
	WebElement menu=driver.findElement(By.xpath(".//*[@id='top']/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select"));
	menu.click();
	Select mobileMenu=new Select(menu);
	mobileMenu.selectByVisibleText("Name");
	Thread.sleep(3000);
	//take screenshot	
	scc=scc+1;
	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String png = ("C:\\Guru99 eCommerce Live Project\\Day01_TestCase1\\Mobile Products are sorted" + scc + ".png");
	FileUtils.copyFile(scrFile, new File(png));
}

@AfterMethod
public void tearDown() throws Exception {
	driver.quit();
   
  }

}


