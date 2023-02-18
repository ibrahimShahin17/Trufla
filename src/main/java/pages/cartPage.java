package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class cartPage extends PageBase{

	public cartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy( id = "checkout")
	public WebElement checkoutBtn;

	@FindBy( id = "termsofservice")
	public WebElement termsCheck;
	
	public void checkTermsBox() 
	{
		termsCheck.click();
	}
	
	public void pressCheckOut() 
	{
		checkoutBtn.click();
	}
}
