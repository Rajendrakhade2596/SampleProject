package com.base;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.pages.RegisterPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserStackBaseClass extends BasePage {

	public WebDriver driver;
	public static final String USERNAME = "sandiplembhe_A1CWlV";
	public static final String AUTOMATE_KEY = "xDhKxywTdCsWoqF8Kpe2";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	@Parameters({ "browserName", "browserVersion", "os", "osVersion" })
	@BeforeMethod
	public WebDriver initialization(String browserName, String browser_Version, String os, String os_Version,
			Method name) {
		String methodName = name.getName();
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browserVersion", browser_Version);
		caps.setCapability("os", os);
		caps.setCapability("osVersion", os_Version);
		caps.setCapability("name", methodName);

		if (browserName.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			caps.setCapability("browserName", browserName);
		} else if (browserName.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			caps.setCapability("browserName", browserName);
		} else if (browserName.equals("Edge")) {
			WebDriverManager.edgedriver().setup();
			caps.setCapability("browserName", browserName);
		}

		try {
			driver = new RemoteWebDriver(new java.net.URL(URL), caps);
			driver.get("http://demo.automationtesting.in/Register.html");
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		return driver;

	}

	public RegisterPage loadRegisterPage() {

		RegisterPage registerpage = new RegisterPage(driver);

		return registerpage;

	}
}
