package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Dataproviders 
{
	//DataProvider1
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
	    String path = System.getProperty("user.dir") + "\\testData\\sheet1.xlsx"; // taking xl file from testData

	    ExcelUtils xlutil=new ExcelUtils(path); // creating an object for XLUtility

	    int totalrows=xlutil.getRowCount("Sheet1");
	    int totalcols=xlutil.getCellCount("Sheet1",1);

	    String logindata[][]=new String[totalrows][totalcols]; // created for two dimension array which can store

	    for(int i=1;i<=totalrows;i++)  // i=1 //read the data from xl storing in two dimensional array
	    {
	        for(int j=0;j<totalcols;j++)  // i is rows j is col
	        {
	            logindata[i-1][j]= xlutil.getCellData("Sheet1",i, j);  // 1,0
	        }
	    }
	    return logindata; // returning two dimension array
	}
}
