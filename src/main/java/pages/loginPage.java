package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends PageBase{

	public loginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	@FindBy (className = "ico-login")
	public WebElement loginIcon;

	@FindBy( id="Email")
	public WebElement email;

	@FindBy( id="Password")
	public WebElement password;

	@FindBy( css = ".button-1.login-button")
	public WebElement loginBtn;

	public void openLoginPage()
	{
		loginIcon.click();
	}

	public void setLoginData(String eMail, String pass) 
	{
		sendText(email, eMail);
		sendText(password, pass);
	}
		
	public void clickOnLoginBtn() {

		loginBtn.click();
	}

}
