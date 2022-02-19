package com.qa.guru99.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.guru99.pages.Homepage;
import com.qa.guru99.pages.Loginpage;
import com.qa.guru99.testbase.Testbase;

public class HomepageTest extends Testbase {
	public Loginpage lpg;
	public Homepage hpg;
	
	public HomepageTest()
	{
		super();
	}
	
	@BeforeMethod	
	public void setup()
	{
		Initilizations();
		 lpg = new Loginpage();	
		 hpg = new Homepage();
		 lpg.getlogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(invocationCount=2)
	public void verifyHomepage_title() throws IOException
	{
		String Homepage_title = hpg.getHomepage_title();
		Assert.assertEquals(Homepage_title, "Guru99 Bank Manager HomePage", "Home Page title verified");
		getscreenshot("HomePage");
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
