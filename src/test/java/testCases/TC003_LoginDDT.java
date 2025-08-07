package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.Dataproviders;

/*Data is valid -- login success--- test pass -- logout
 * Data is valid-- login failed --- test fail
 * 
 * Data is invalid ---login success-- test fail-- logout
 * Data is invalid-- login failed --- test pass
 * */


public class TC003_LoginDDT extends BaseClass
{
	@Test(dataProvider="LoginData", dataProviderClass=Dataproviders.class,groups="datadriven")	//since data provider is in different package
	public void verify_LoginDDT(String email, String pwd, String exp)
	{
		logger.info("*********Starting TC003_LoginDDT********");
	
	try
	{
		//HomePage
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
	
		
		//LoginPage
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);		    
		lp.setPassword(pwd);
		lp.clickLogin();
	
	
		//MyAccountPage
		MyAccountPage myacc= new MyAccountPage(driver);
		boolean target =myacc.isMyaccountPageexists();
		
		if (exp.equalsIgnoreCase("Valid"))
		{
			if (target==true)
			{
				myacc.clicklogout();
				Assert.assertTrue(true);
				
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		else if (exp.equalsIgnoreCase("Invalid"))
		{
			if (target==true)
			{
				myacc.clicklogout();
				Assert.assertTrue(false);
				
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
	 }catch(Exception e)
		{
		 	Assert.fail();
		}

		logger.info("*********Finished TC002_Logintest********");
	}
}
	
