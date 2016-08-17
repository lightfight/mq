package com.lightfight.properties;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public abstract class PropertiesBase {
	
	protected Properties properties = new Properties();
	
	protected PropertiesBase(){
		try {
			String name = getPropertitesName();
			InputStream input = new BufferedInputStream(new FileInputStream(name));
			properties.load(input);
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected abstract String getPropertitesName() throws IOException;
	
	public String get(String key) {
		return properties.getProperty(key);
	}
	
	public int getNumber(String key){
		int i = Integer.parseInt(properties.getProperty(key));
		return i != 0 ? i : 0;
	}
	
}
