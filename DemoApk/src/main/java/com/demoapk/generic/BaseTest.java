package com.demoapk.generic;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;


public class BaseTest 
{
	//AppiumDriverLocalService service;
	public static AppiumDriver<MobileElement> driver;
		
	@BeforeMethod
	public void setUp()
	{		
			AppiumDriverLocalService service;
			String serverAddress = "127.0.0.1";
		
			DesiredCapabilities serverCapabilities = new DesiredCapabilities();
			AppiumServiceBuilder builder = new AppiumServiceBuilder().withCapabilities(serverCapabilities);
			builder.usingAnyFreePort();
			builder.withIPAddress(serverAddress);
			builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
			builder.withArgument(GeneralServerFlag.LOG_LEVEL, "warn");
		
			service = builder.build();
			service.start();
			/*service = AppiumDriverLocalService.buildDefaultService();
			service.start();*/
			/*DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("automationName", "Appium");	
			cap.setCapability("platformName", "Android");
			cap.setCapability("deviceName", "Gionee P4");
			cap.setCapability("platformVersion", "4.4.2");
			cap.setCapability("deviceName", "Micromax Q380");
			cap.setCapability("platformVersion", "5.0");
			//cap.setCapability("app","C:\\Users\\TYSS\\Desktop\\ApiDemos.apk");
			cap.setCapability("appPackage","io.appium.android.apis");
			cap.setCapability("appActivity","io.appium.android.apis.ApiDemos");
			
			try 
			{
				driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
				//driver.startActivity("io.appium.android.apis", "io.appium.android.apis.ApiDemos");
			} catch (MalformedURLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println("Session is created");*/
	}
	
	@AfterMethod
	public void closeApp()
	{
		//driver.quit();
	}
}
