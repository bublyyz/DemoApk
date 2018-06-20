package com.dempApk.testScripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class DemoTest 
{
	/*public AndroidDriver driver;
	@Test
	public void install()
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("automationName", "Appium");	
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "Micromax Q380");
		cap.setCapability("platformVersion", "5.0");
		//cap.setCapability("app","C:\\Users\\TYSS\\Desktop\\ApiDemos.apk");
		cap.setCapability("appPackage","io.appium.android.apis");
		cap.setCapability("appActivity","io.appium.android.apis.ApiDemos");
		
		try 
		{
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
			driver.unlockDevice();
			WebElement media=driver.findElementByXPath("//android.widget.TextView[@text='Media']");			
			TouchAction act=new TouchAction(driver);
			act.tap(media);
			//act.singleTap(media);
		} 
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Session is created");
		//driver.unlockDevice();
		
	}*/
}
