package com.dempApk.testScripts;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.internal.TouchAction;
//import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;


public class HomePage 
{
	public AppiumDriver<MobileElement> driver;
	
	@FindBy(xpath="//android.widget.TextView[@text='Media']")
	private WebElement media;
	
	public HomePage(AppiumDriver<MobileElement> driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void tapMedia() throws Exception
	{
		TouchAction act=new TouchAction(driver);	
		act.tap(60,180).perform();
		
	}
	
	public void verticalSwipe()
	{
		Dimension dim = driver.manage().window().getSize();
		int height = dim.getHeight();
		int width = dim.getWidth();
		int x = width/2;
		int starty = (int)(height*0.80);
		int endy = (int)(height*0.20);
		driver.swipe(x, starty, x, endy, 500);
		//System.out.println(height+"\n" + width + "\n"+ x +"\n"+starty+"\n"+endy);		
	}
	
	public void clickTab12()
	{
		verticalSwipe();
		boolean flag = false;
		driver.findElementByAccessibilityId("Views").click();
		for(int i=0;i<=5;i++)
		{
			try {
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				driver.findElementByAccessibilityId("Tabs").click();
				break;
			} catch (Exception e) {
				verticalSwipe();
			}
		}
		flag = driver.findElementByAccessibilityId("1. Content By Id").isDisplayed();
		if(flag)
		{
			System.out.println("Passed");
		}else
		{
			System.out.println("Failed");
		}
	}
	
	public void clickTab13()
	{
		verticalSwipe();
		boolean flag = false;
		driver.findElementByAccessibilityId("Views").click();
		for(int i=0;i<=20;i++)
		{
			try {
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				driver.findElementByAccessibilityId("Tabs").click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				break;
			} catch (Exception e) {
				verticalSwipe();
			}
		}
		driver.findElementByAccessibilityId("5. Scrollable").click();
	}
	
	public void verifyTab28()
	{
		boolean f =false;
		for(int i =1;i<=20;i++)
		{
			try {
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				f = driver.findElementByXPath("//*[@text='TAB 28']").isDisplayed();
				f = true;
				break;
			} catch (Exception e) {
				hortizonalSwipe();
			}
		}
		if(f)
		{
			System.out.println("Passed");
		}else
		{
			System.out.println("Failed");
		}
	}
		
	public void hortizonalSwipe()
	{
		Dimension dim = driver.manage().window().getSize();
		int height = dim.getHeight();
		int width = dim.getWidth();
		int y = (int)(height*0.20);
		int startx = (int)(width*0.75);
		int endx = (int)(width*0.35);
		driver.swipe(startx, y, endx, y, 500);
	}
	
	public void getWebViewText()
	{
		System.out.println("First Current Context : "+driver.getContext());
		driver.findElementByAccessibilityId("Views").click();
		for(int i=0;i<=20;i++)
		{
			try {
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				driver.findElementByAccessibilityId("WebView").click();
				break;
			} catch (Exception e) {
				verticalSwipe();
			}
		}
		// Using this method we switch to web view
		switchContext("WEBVIEW");
		String webViewText = driver.findElementByXPath("//a[text()='Hello World! - 1']").getText();
		System.out.println(webViewText);
		
	}
	public void switchContext(String context)
	{
		System.out.println("Before Switching : "+driver.getContext());
		Set<String> con = driver.getContextHandles();
		for(String c : con)
		{
			System.out.println("Available Context : "+c);
			if(c.contains(context))
			{
				driver.context(c);
				break;
			}
		}
		System.out.println("After Switching : "+driver.getContext());
	}
	
}
