package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyHome {
WebDriver driver;
	
	@FindBy(xpath=".//*[@id='top']/body/div/div/div[2]/div/div[1]/div/div[2]/ul/li[8]/a")
	WebElement my_Wishlist;
	
	//Account Label
	@FindBy(xpath=".//*[@id='header']/div/div[2]/div/a/span[2]")
	WebElement accountLable;
	
	//Log Out
	@FindBy(xpath=".//*[@id='header-account']/div/ul/li[5]/a")
	WebElement log_out;
	
	public MyHome(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void goToMyWishlist(){
		my_Wishlist.click();
	}
	
	public void logOut(){
		accountLable.click();
		log_out.click();
	}
	
}
