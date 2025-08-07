package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC002_Logintest extends BaseClass
{
	@Test(groups={"Sanity","Master"})	
	public void verify_login()
	{
		if (logger == null) 
		{
	        System.out.println("LOGGER IS NULL");
	    }
		logger.info("*********Starting TC002_Logintest********");
		
		try
		{
		//HomePage
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		
		//LoginPage
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));		    //pass values from config.properties file
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		
		//MyAccountPage
		MyAccountPage myacc= new MyAccountPage(driver);
		boolean target =myacc.isMyaccountPageexists();
		
		Assert.assertEquals(target, true, "Login failed");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("*********Finished TC002_Logintest********");
		
	}
}
