package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage
{
	public MyAccountPage(WebDriver driver)
	{
		super(driver);    // Invoke the parent class constructor from class BasePage
	}
	
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement msgHeading;
	
    @FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
    WebElement linklogout;
	
	public boolean isMyaccountPageexists()
	{
		try
		{
			return (msgHeading.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public void clicklogout()
	{
		linklogout.click();
	}
}
