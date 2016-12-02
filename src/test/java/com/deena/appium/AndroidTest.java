package com.deena.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AndroidTest {

	AppiumDriver<WebElement> driver;
	
	@AndroidFindBy(id="de.komoot.android:id/button_register")
	WebElement signup;
	
	@AndroidFindBy(id="de.komoot.android:id/edittext_display_name")
	WebElement username;
	
	@BeforeMethod
	public void setup() throws MalformedURLException{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability("deviceName", "android emulator");
		capabilities.setCapability("platformName", "android");
		//capabilities.setCapability("bundleid", "com.deena.IPhone6S");
		//capabilities.setCapability("app", "/Users/deenathayalan_p/Softwares/komoot.apk");
		
		//walgreens app
		capabilities.setCapability("app", "/Users/deenathayalan_p/Softwares/walgreens.apk");
		
		//driver = new IOSDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Opeing the app");
		
	}
	
	@AfterMethod
	public void closure(){
		driver.quit();
		System.out.println("Closing the app");
	}
	
	@Test
	public void test(){
		System.out.println("Clicking the loging button");
		String emaillink = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[2]";
		//String email_id = "de.komoot.android:id/button_mail_register";
		//String name = "de.komoot.android:id/edittext_display_name";
		String email = "de.komoot.android:id/edittext_email";
		String password = "de.komoot.android:id/edittext_password";
		
		driver.findElement(By.xpath(emaillink)).click();
		//driver.findElement(By.id(name)).sendKeys("sachin");
		username.sendKeys("sachin");
		driver.findElement(By.id(email)).sendKeys("sachin.tendulkar@gmail.com");
		driver.findElement(By.id(password)).sendKeys("password");
		//signup.click();
		
		//driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]")).click();
		//System.out.println("Clicking the about button");
		//driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]")).click();
		//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1] - Settings
		//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1] - About
	}
}
