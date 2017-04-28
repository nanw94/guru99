package pageFactory;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="pass")
	WebElement pass;

	@FindBy(id="send2")
	WebElement login;
	
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void Login(String vEmail, String vPass){
		email.clear();
		email.sendKeys(vEmail);
		
		pass.clear();
		pass.sendKeys(vPass);
		
		login.click();
	}
	
//	public void goToMyWishlist(){
//		driver.findElement(By.linkText("My Wishlist"));
//		email.sendKeys(vEmail);
//		
//		pass.clear();
//		pass.sendKeys(vPass);
//		
//		login.click();
//	}
	

}
