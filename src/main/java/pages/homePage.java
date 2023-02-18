package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class homePage extends PageBase{

	public homePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy (className = "page-body")
	public WebElement pageBody;
	
	@FindBy (className = "item-grid") 
	public WebElement itemGrid;
	
	@FindBy (linkText = "Books")
	public WebElement bookBtn;

	@FindBy( id = "products-orderby")
	public WebElement productsOrderby;

	@FindBy( xpath = "/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[2]/div/div[2]/div[3]/div[2]/button[1]")
	public WebElement addBtn;
	
	@FindBy( id = "topcartlink")
	public WebElement cartIcon;
	
	Select sortBy = new Select(productsOrderby);

	public void selectSortingType(String sortingType) 
	{
		productsOrderby.click();
		sortBy.selectByValue(sortingType);
		productsOrderby.click();
	}
	
	public void addToCart() 
	{
		addBtn.click();
	}
	public void openCart() 
	{
		cartIcon.click();
	}
}
