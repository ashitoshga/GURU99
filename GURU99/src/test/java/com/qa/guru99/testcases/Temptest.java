package com.qa.guru99.testcases;

import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.qa.guru99.testbase.Testbase;

import java.io.File;
import java.io.IOException;
public class Temptest extends Testbase{
	
	public WebDriver driver;
	public Temptest()
	{
		super();
	}

	//@Test
//	public void takescreenshot() throws IOException
//	{
//		
//		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		File DestFile =new File(System.getProperty("user.dir"));
//	    FileUtils.copyFile(srcfile, DestFile);		
//	}
	
//	public void takescreenshot() throws IOException
//	{		
//		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		File DestFile =new File(System.getProperty("user.dir"));
//	    FileUtils.copyFile(srcfile, DestFile);		
//	}	
	@Test
	public void test() throws IOException
	{
		Initilizations();
//		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Practice\\Selenium_installable\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		driver.manage().deleteAllCookies();
//		driver.manage().window().maximize();
//		
//		driver.get("http://www.demo.guru99.com/V4/");
//		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
//		String beforelogin = driver.getTitle();
//		System.out.println("beforelogin"+beforelogin);
		driver.findElement(By.name("uid")).sendKeys("mngr205449");
		driver.findElement(By.name("password")).sendKeys("UrehumE");
		//takescreenshot();
		getscreenshot("LoginPage");
		driver.findElement(By.name("btnLogin")).click();
		String afterlogin = driver.getTitle();
		System.out.println("afterlogin"+afterlogin);
		getscreenshot("HomePage");
	}
}
