package com.tests;

import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.base.BrowserStackBaseClass;
import com.pages.RegisterPage;

public class RegisterPageTest extends BrowserStackBaseClass{
	
	RegisterPage registerpage = loadRegisterPage();

	@Test
	public void verifyRegisterScenario() throws Exception {
		
		ArrayList<String> data1 = readSpecificValueFromExcelSheet("IndustrialWebRegistrationData.xlsx", "registerdata", 0);
		ArrayList<String> data2 = readSpecificValueFromExcelSheet("IndustrialWebRegistrationData.xlsx", "registerdata", 1);
		
		List<String> list1 = new ArrayList<String>();

		list1.add(data1.get(15));
		list1.add(data1.get(16));
		list1.add(data1.get(17));
		
		List<String> list2 = new ArrayList<String>();
		
		list2.add(data2.get(15));
		list2.add(data2.get(16));
		
		registerpage.checkCreateNewRegisterCredential(data1.get(0), data1.get(1), data1.get(2), data1.get(3), data1.get(4)
				, data1.get(5), list1, data1.get(6), data1.get(7), data1.get(8), data1.get(9), data1.get(10), data1.get(11)
				, data1.get(12), data1.get(13), data1.get(14));
		
		registerpage.checkCreateNewRegisterCredential(data2.get(0), data2.get(1),  data1.get(2), data2.get(3), data2.get(4)
				, data2.get(5), list2,  data2.get(6), data2.get(7), data2.get(8), data2.get(9), data2.get(10), data2.get(11)
				, data2.get(12), data2.get(13), data2.get(14));
	}
	
	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}
	
}
