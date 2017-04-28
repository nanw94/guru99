package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class CheckoutPage {
WebDriver driver;

@FindBy(id="billing:street1")
WebElement street1;

@FindBy(id="billing:city")
WebElement city;

@FindBy(id="email_address")
WebElement emailAddress;

@FindBy(id="billing:region_id")
WebElement region;

@FindBy(id="billing:postcode")
WebElement zip;

@FindBy(id="billing:country_id")
WebElement country;

@FindBy(id="billing:telephone")
WebElement tele;

@FindBy(xpath=".//*[@id='billing-buttons-container']/button")
WebElement continue_button;


	public CheckoutPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void checkout(String vStreet1, String vCity, String vRegion, String vZip, String vCountry,String vTele) throws Exception{
		street1.clear();
		street1.sendKeys(vStreet1);
		
		city.clear();
		city.sendKeys(vCity);
		
		Select country_dropdown=new Select(country);
		country_dropdown.selectByVisibleText(vCountry);
		
		Select region_dropdown=new Select(region);
		region_dropdown.selectByVisibleText(vRegion);
				
		zip.clear();
		zip.sendKeys(vZip);
		
		tele.clear();
		tele.sendKeys(vTele);
		
		Thread.sleep(2000);
		//click continue
		continue_button.click();
		

	}
}

