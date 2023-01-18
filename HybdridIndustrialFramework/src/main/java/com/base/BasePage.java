package com.base;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
	
/*************************Click on Any WebElement*****************/

	public void clickOnWebElement(WebElement element) {

		element.isDisplayed();

		element.click();
	}
	
/****************************Submit the form**********************/

	public void submitByWebElement(WebElement element) {
		
		element.isDisplayed();
		
		element.submit();
		
	}
	
/**********************Send Value to WebElement*******************/

	public void SendValue(WebElement element, String value) {

		element.clear();

		element.sendKeys(value);

	}
	
/************Select Radio Button By Attribute Value***************/
	
	public void selectRadioButtonByValue(List<WebElement> elements, String value) {

		for (WebElement element : elements) {

			if (element.getAttribute("value").equals(value)) {

				element.click();

				break;
			}

		}
	}
	
/*******************Select Radio Button By Text*******************/

	public void selectRadioButtonByText(List<WebElement> elements, String text) {

		for (WebElement element : elements) {

			if (element.getText().equals(text)) {

				element.click();

				break;
			}

		}
	}

/************Select Multiple CheckBoxes By Attribute Value************/
	
	public void selectMultipleCheckBoxesByValue(List<WebElement> elements, List<String> values) {

		for (String value : values) {

			for (WebElement element : elements) {

				if (element.getAttribute("value").equals(value)) {

					element.click();

					break;
				}

			}
		}
	}
	
/************Select Single CheckBoxes By Attribute Value*************/
	
	public void selectSingleCheckBoxByValue(List<WebElement> elements, String value) {
		
			for (WebElement element : elements) {
				
				if (element.getAttribute("value").equals(value)) {
					
					element.click();
					
					break;
			}
		}
	}

/***************Select value By Visible in SelectTag*****************/
	
	public void selectByVisibleText(WebElement element, String value) {

		Select select = new Select(element);

		select.selectByVisibleText(value);
	}
	
/************Select Multiple Value By Visible in SelectTag************/
	
	public void selectMultipleWebElementByVisibleText(WebElement element1,WebElement element2,WebElement element3, String value1, String value2, String value3) {
		
		selectByVisibleText(element1, value1);
		
		selectByVisibleText(element2, value2);
		
		selectByVisibleText(element3, value3);
		
	}
	

/*****************Select value By Options in SelectTag******************/
	
	public void selectByOptions(WebElement element, String value) {

		Select select = new Select(element);

		List<WebElement> list = select.getOptions();

		for (WebElement webElement : list) {

			if (webElement.getText().equals(value)) {

				webElement.click();
			}
		}

	}
	

/*****************Select value From List Before Click*******************/

	public void clickAndSelectElementFromList(List<WebElement> list, WebElement element, String value) {

		element.click();

		for (int i = 0; i < list.size(); i++) {

			if (list.get(i).getText().equals(value)) {

				list.get(i).click();

				break;
			}

		}

	}

/*********************File Upload Using Robot Class**********************/

	public void uploadFileUsingRobotClass(WebElement element, String path) throws Exception {

		Robot robot = new Robot();

		element.click();

		StringSelection str = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null );

		robot.delay(1000);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.delay(3000);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.delay(3000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}
	
/*********************File Upload Using SendKeys**********************/

	public void uploadFileUsingSendKeys(WebElement element, String path) {

		element.sendKeys(path);
	}

/***************Retrive Specific Data from ExcelSheet*****************/

	public ArrayList<String> readSpecificValueFromExcelSheet(String filepath, String sheetname, int cols)
			throws Exception {

		DataFormatter df = new DataFormatter();

		FileInputStream fis = new FileInputStream(filepath);

		Workbook wb = WorkbookFactory.create(fis);

		Sheet sh = wb.getSheet(sheetname);

		int rows = sh.getLastRowNum();

		ArrayList<String> list = new ArrayList<String>();

		for (int i = 0; i <= rows; i++) {

			for (int j = cols; j <= cols; j++) {

				Cell c = sh.getRow(i).getCell(j);

				String value = df.formatCellValue(c);

				list.add(value);

			}

		}
		return list;
	}

}
