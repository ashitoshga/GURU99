package com.qa.guru99.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.guru99.util.Testutil;

public class Testbase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static Alert alt;
	public TakesScreenshot ts;
	
	public Testbase()
	{
		try 
		{
			prop = new Properties();
			FileInputStream fis = new FileInputStream("D:\\Home_Projects\\GURU99\\src\\main\\java\\com\\qa\\"
					+ "guru99\\config\\config.properties");
			prop.load(fis);			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}

	public void Initilizations()
	{			 
		String browsername = prop.getProperty("browser");		
		if(browsername.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Practice\\Selenium_installable\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "D:\\Selenium_Practice\\Selenium_installable\\firefoxdriver.exe");
			driver = new FirefoxDriver();
		}
		else if (browsername.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", "D:\\Selenium_Practice\\Selenium_installable\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Testutil.PageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Testutil.ImplicitWait, TimeUnit.SECONDS);		
		
		driver.get(prop.getProperty("url"));
	}
	
	public void getscreenshot(String screenshotName) throws IOException
	{
		 ts = ((TakesScreenshot)driver);
		 File srcfile = ts.getScreenshotAs(OutputType.FILE);
		 String dstpath = System.getProperty("user.dir");
		 //System.out.println(System.getProperty("user.dir"));
		 File dstfile = new File(dstpath+"\\Screenshots"+"\\"+screenshotName+".png");
		 FileUtils.copyFile(srcfile, dstfile);		
	}
	

}
