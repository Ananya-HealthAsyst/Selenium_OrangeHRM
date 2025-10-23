package com.utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	public static String readPropertyFileData(String keyName, String fileName) {
		String readerValue = null;
		
		Properties properties=null;
		try {
			FileReader fileReader=new FileReader("./configuration/"+fileName+".properties");
			System.out.println(fileReader);
			properties = new Properties();
			properties.load(fileReader);
			readerValue=properties.getProperty(keyName).toString();
			
		}catch(IOException e) {
			//
			e.printStackTrace();
		}
		return readerValue;
	}
}
