package com.qa.guru99.testcases;


import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.guru99.pages.Homepage;
import com.qa.guru99.pages.Loginpage;
import com.qa.guru99.testbase.Testbase;
import com.qa.guru99.util.Testutil;

public class LoginpageTest extends Testbase {
	public Loginpage lpg;
	public Homepage hpg;
	
	public LoginpageTest()
	{
		super();
	}
	
	@BeforeMethod	
	public void setup()
	{
		Initilizations();
		 lpg = new Loginpage();			
	}
	
	@Test(priority=1)
	public void verifytitletest()
	{
		String actualtitle = lpg.verifytitle();		
		Assert.assertEquals(actualtitle, "Guru99 Bank Home Page", "Login Page title verified");		
	}
	
	@DataProvider
	public Object[][] getdata() throws Exception
	{
		 Object [][] data = Testutil.getDataFromExcel(Testutil.FILE_PATH, Testutil.SHEET_NAME, Testutil.TABLE_NAME);
		 return data;
	}
	
	@Test(priority = 2, dataProvider="getdata")
	public void Verify_logins(String username, String password) throws IOException
	{
		driver.findElement(By.name("uid")).clear();
		driver.findElement(By.name("uid")).sendKeys(username);
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("btnLogin")).click();
		//getscreenshot("LoginPage");
		try{			
			Alert alt = driver.switchTo().alert();
			String alert_txt = alt.getText();
			Assert.assertEquals(alert_txt, Testutil.Expect_Login_Alert);			
		}
		catch(NoAlertPresentException ale)
		{
			String actual_title = driver.getTitle();
			Assert.assertEquals(actual_title, Testutil.EXPECT_TITLE);
		}
	}
	
//	@Test(priority = 2)
//	public void Verify_Invalid_login1()
//	{
//		String actualmessage = lpg.Invalid_UN_PWD("INVALID", "INVALID");
//		Assert.assertEquals(actualmessage, "User or Password is not valid");
//	}
//	@Test(priority = 3)
//	public void Verify_Invalid_login2()
//	{
//		String actualmessage = lpg.Invalid_UN("INVALID", prop.getProperty("password"));
//		Assert.assertEquals(actualmessage, "User or Password is not valid");
//	}
//	@Test(priority = 4)
//	public void Verify_Invalid_login3()
//	{
//		String actualmessage = lpg.Invalid_PWD(prop.getProperty("username"), "INVALID");
//		Assert.assertEquals(actualmessage, "User or Password is not valid");
//	}
//	@Test(dependsOnMethods="verifytitletest")
//	public void verifylogin()
//	{		
//		hpg = lpg.getlogin(prop.getProperty("username"), prop.getProperty("password"));
//	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
