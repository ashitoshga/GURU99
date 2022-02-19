package com.qa.guru99.pages;

import org.openqa.selenium.support.PageFactory;

import com.qa.guru99.testbase.Testbase;

public class Homepage extends Testbase {
	public Homepage()
	{
		PageFactory.initElements(driver, this);
	}
//
	//PageFactory
	
	public String getHomepage_title()
	{
		return driver.getTitle();
	}
}
