package com.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtils {
	
	public static String readPropertyFile(String key)  {
		
		Properties prop = new Properties();
		
	try {	
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/config.properties");
		
		prop.load(fis);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	    String value = prop.getProperty(key);
		
		return value;
		
	}

}
