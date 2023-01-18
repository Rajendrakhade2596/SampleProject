package com.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.pages.RegisterPage;
import com.utility.PropertiesUtils;

public class BaseClass extends BasePage {
	
	public static WebDriver driver =null ; 
	
	public WebDriver initialization() {
		
		String value = PropertiesUtils.readPropertyFile("browser");
		System.out.println(value);
		
		if(value.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
			
			driver = new ChromeDriver();
			System.out.println("*************ok***********");
		}
		else if(value.equals("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "D:/geckodriver.exe");
			
			 driver = new FirefoxDriver();
		}
		launchApplication();
		
		return driver;
	}
	
	
	
	public void  launchApplication() {
		
		driver.manage().window().maximize();
		
		driver.get(PropertiesUtils.readPropertyFile("url"));
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	
	public RegisterPage loadRegisterPage() {
		
		RegisterPage registerpage = new RegisterPage(driver);
		
		return registerpage;
		
		
	}
}
