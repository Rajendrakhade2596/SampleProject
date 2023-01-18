package com.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
import com.base.BrowserStackBaseClass;

public class RegisterPage extends BrowserStackBaseClass {

	WebDriver driver = null;

	public RegisterPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder = 'First Name' and @type='text']")
	private WebElement firstName;

	@FindBy(xpath = "//input[@placeholder = 'Last Name' and @type='text']")
	private WebElement lastName;

	@FindBy(xpath = "//div[@class='col-md-8 col-xs-8 col-sm-8']//child::textarea")
	private WebElement address;

	@FindBy(xpath = "//input[@type='email']")
	private WebElement emailAddress;

	@FindBy(xpath = "//input[@type='tel']")
	private WebElement mobileNumber;

	@FindBy(xpath = "//div[@class='col-md-4 col-xs-4 col-sm-4']//following-sibling::input[@type='radio']")
	private List<WebElement> genderRadios;

	@FindBy(xpath = "//*[@type='checkbox']")
	private List<WebElement> hobbiesCheckboxes;

	@FindBy(xpath = "//div[@class='ui-autocomplete-multiselect ui-state-default ui-widget' and @id='msdd']")
	private WebElement clickOnLanguage;

	@FindBy(xpath = "//form[@id='basicBootstrapForm']")
	private WebElement clickOutFromLang;

	@FindBy(xpath = "//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all']//li")
	private List<WebElement> languageOptions;

	@FindBy(xpath = "//select[@type='text' and @id ='Skills']")
	private WebElement selectSkill;

	@FindBy(xpath = "//select[@id ='country']//following::span[@role='presentation']")
	private WebElement clickOnSelectCountry;

	@FindBy(xpath = "//ul[@id='select2-country-results']//li")
	private List<WebElement> chooseCountry;

	@FindBy(xpath = "//select[@type='text' and @id='yearbox']")
	private WebElement yearOptions;

	@FindBy(xpath = "//select[@type='text' and @placeholder='Month']")
	private WebElement monthOptions;

	@FindBy(xpath = "//select[@type='text' and @id='daybox']")
	private WebElement dayOptions;

	@FindBy(xpath = "//input[@id='firstpassword']")
	private WebElement sendPassword;

	@FindBy(xpath = "//input[@id='secondpassword']")
	private WebElement sendConfirmPassword;

	@FindBy(xpath = "//input[@id='imagesrc' and @type='file']")
	private WebElement chooseFile;

	@FindBy(xpath = "//button[@id='submitbtn' and @type='submit']")
	private WebElement submitButton;

	@FindBy(xpath = "//button [@id='Button1' and @type='button']")
	private WebElement refreshButton;

	
	
	public void checkCreateNewRegisterCredential(String firstname,String lastname, String add, 
			String email, String phone, String gender, List<String> hobbies, String lang, 
			String skill, String country, String year, String month, String date, String passfirst,
			String passconfirm, String path) throws Exception {

		SendValue(firstName, firstname);

		SendValue(lastName, lastname);

		SendValue(address, add);

		SendValue(emailAddress, email);

		SendValue(mobileNumber, phone);
		
		Thread.sleep(1000);

		selectRadioButtonByValue(genderRadios, gender);
		
		Thread.sleep(2000);

		selectMultipleCheckBoxesByValue(hobbiesCheckboxes, hobbies);
		
		Thread.sleep(3000);

		clickAndSelectElementFromList(languageOptions, clickOnLanguage, lang);
		
		Thread.sleep(1000);
		
		clickOnWebElement(clickOutFromLang);
		
		Thread.sleep(2000);
		
		selectByVisibleText(selectSkill, skill);
		
		Thread.sleep(2000);
		
		clickAndSelectElementFromList(chooseCountry, clickOnSelectCountry, country);
		
		Thread.sleep(2000);
		
		selectMultipleWebElementByVisibleText(yearOptions, monthOptions, dayOptions, year, month, date);

		Thread.sleep(2000);
		
		SendValue(sendPassword, passfirst);

		Thread.sleep(2000);

		SendValue(sendConfirmPassword, passconfirm);

		SendValue(chooseFile, path);

		Thread.sleep(2000);

		submitByWebElement(submitButton);
		
		Thread.sleep(2000);
		
		clickOnWebElement(refreshButton);
		
		Thread.sleep(3000);

	}
}
