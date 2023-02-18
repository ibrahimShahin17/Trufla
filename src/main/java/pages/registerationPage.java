package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class registerationPage extends PageBase{

	public registerationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	@FindBy (className = "ico-register")
	public WebElement registerIcon;

	@FindBy (id="gender-male")
	public WebElement gender;

	@FindBy (id="FirstName")
	public WebElement firstName;

	@FindBy( id="LastName")
	public WebElement lastName;

	
	@FindBy( css = "select[name='DateOfBirthDay']")
	public WebElement dateOfBirthDay;

	@FindBy( css = "select[name='DateOfBirthMonth']")
	public WebElement monthOfBirthDay;

	@FindBy( css = "select[name='DateOfBirthYear']")
	public WebElement yearOfBirthDay;
	
	@FindBy( id="Email")
	public WebElement email;
	
	@FindBy( id="Company")
	public WebElement company;
	
	@FindBy( id="Password")
	public WebElement password;
	
	@FindBy( id="ConfirmPassword")
	public WebElement confirmPassword;

	@FindBy( id="register-button")
	public WebElement registerBtn;

	@FindBy( css = ".result")
	public WebElement registerationMessage;
	
	public void clickOnRegisterBtn()
	{
		registerIcon.click();
	}
	
	public void clickOnGenderRadioBtn()
	{
		gender.click();
	}

	Select BirthDay = new Select(dateOfBirthDay);
	Select BirthMonth = new Select(monthOfBirthDay);
	Select BirthYear = new Select(yearOfBirthDay);
	
	public void selectBirthDate(String date, String month, String year) 
	{
		BirthDay.selectByValue(date);
		BirthMonth.selectByValue(month);
		BirthYear.selectByValue(year);
	}
	
	public void setPersonalDetails(String firts, String last, String date, String month, String year, String eMail) 
	{
		sendText(firstName, firts);
		sendText(lastName, last);
		selectBirthDate(date,  month,  year);
		sendText(email, eMail);
	}
	
	public void setCompanyDetails(String Company) 
	{
		sendText(company, Company);
	}
	
	public void setPassword(String Password) 
	{
		sendText(password, Password);
	}
	
	public void setConfirmationPassword(String Password) 
	{
		sendText(confirmPassword, Password);
	}
	
	public void clickOnRegisterationBtn() {

		registerBtn.click();
	}

}
