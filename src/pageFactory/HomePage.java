package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
WebDriver driver;

@FindBy(linkText="Mobile")
WebElement mobileMenu;

//@FindBy(xpath=".//*[@id='header']/div/div[2]/div/a/span[2]")
//WebElement account;
//
//@FindBy(linkText="My Account")
//WebElement my_Account;


	public HomePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void goToMobile(){
		mobileMenu.click();
	}
	
	
	
	public void goToLogin() throws Exception{
		//click Account to make the submenu visible
		driver.findElement(By.xpath(".//*[@id='header']/div/div[2]/div/a/span[2]")).click();
		
		//click My account in the sub menu.
		driver.findElement(By.linkText("My Account")).click();
		Thread.sleep(3000);
	}
	

		
}



