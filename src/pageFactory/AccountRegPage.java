package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AccountRegPage {
WebDriver driver;

@FindBy(id="firstname")
WebElement firstName;

@FindBy(id="lastname")
WebElement lastName;

@FindBy(id="email_address")
WebElement emailAddress;

@FindBy(id="password")
WebElement password;

@FindBy(id="confirmation")
WebElement confirmation;

@FindBy(xpath=".//*[@id='form-validate']/div[2]/button")
WebElement submit;

	public AccountRegPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void register(String first_Name, String last_Name, String email_Address, String pW, String cF){
		firstName.clear();
		firstName.sendKeys(first_Name);
		
		lastName.clear();
		lastName.sendKeys(last_Name);
		
		emailAddress.clear();
		emailAddress.sendKeys(email_Address);
		
		password.clear();
		password.sendKeys(pW);
		
		confirmation.clear();
		confirmation.sendKeys(cF);
		
		submit.click();
	}
}
