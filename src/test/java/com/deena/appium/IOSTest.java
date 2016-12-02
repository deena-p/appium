package com.deena.appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;

public class IOSTest {

	AppiumDriver<WebElement> driver;
	
	@BeforeMethod
	public void setup() throws MalformedURLException{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability("deviceName", "iPhone Simulator");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("bundleid", "com.deena.IPhone6S");
		capabilities.setCapability("app", "/Users/deenathayalan_p/Desktop/IPhone6S.app");
		
		driver = new IOSDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		System.out.println("Opeing the app");
		
	}
	
	@AfterMethod
	public void closure(){
		driver.quit();
		System.out.println("Closing the app");
	}
	
	@Test
	public void test(){
		System.out.println("Clicking the settings button");
		
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]")).click();
		System.out.println("Clicking the about button");
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]")).click();
		//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1] - Settings
		//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1] - About
	}
	
}
