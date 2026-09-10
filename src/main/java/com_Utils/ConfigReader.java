package com_Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
private static Properties prop;
	
	public Properties init_prop() {
		prop=new Properties();
		
		try {
			FileInputStream ip =new FileInputStream("./config/config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return prop;
	}
	public static String getProperty(String key) {
		return prop.getProperty(key);
	}

}
