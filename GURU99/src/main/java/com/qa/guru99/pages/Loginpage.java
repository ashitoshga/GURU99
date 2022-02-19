package com.qa.guru99.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.guru99.testbase.Testbase;

public class Loginpage extends Testbase{

	public Loginpage()
	{
		PageFactory.initElements(driver, this);
		//WebDriverWait wait  = new WebDriverWait(driver, 10);
	}
	
	//PageFactory
	@FindBy(name="uid")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement LoginBtn;
	
	@FindBy(name="btnReset")
	WebElement ResetBtn;
	
	public Homepage getlogin(String UN, String PWD)
	{
		username.sendKeys(UN);
		password.sendKeys(PWD);		
		LoginBtn.click();
		return new Homepage();
	}
	public String verifytitle()
	{
		return driver.getTitle();
	}
	
	public String Invalid_UN_PWD(String UN_invalid, String PWD_invalid)
	{
		username.sendKeys(UN_invalid);
		password.sendKeys(PWD_invalid);
		LoginBtn.click();		
		Alert alt = driver.switchTo().alert();
		String altmessage = alt.getText();
		alt.accept();
		return altmessage;
	}
	
	public String Invalid_UN(String UN_invalid, String PWD_invalid)
	{
		username.sendKeys(UN_invalid);
		password.sendKeys(PWD_invalid);
		LoginBtn.click();		
		Alert alt = driver.switchTo().alert();
		String altmessage = alt.getText();
		alt.accept();
		return altmessage;
	}
	public String Invalid_PWD(String UN_invalid, String PWD_invalid)
	{
		username.sendKeys(UN_invalid);
		password.sendKeys(PWD_invalid);
		LoginBtn.click();		
		Alert alt = driver.switchTo().alert();
		String altmessage = alt.getText();
		alt.accept();
		return altmessage;
	}
	

}
