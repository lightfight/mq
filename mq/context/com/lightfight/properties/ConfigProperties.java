package com.lightfight.properties;

import java.io.File;
import java.io.IOException;

public class ConfigProperties extends PropertiesBase {

	private static PropertiesBase instance = new ConfigProperties();

	public static String getStr(String key) {
		return instance.get(key);
	}

	public static int getInt(String key) {
		return instance.getNumber(key);
	}

	public static long getLong(String key) {
		return instance.getNumber(key);
	}

	public static boolean getBoolean(String key) {
		return Boolean.valueOf(instance.get(key));
	}

	@Override
	protected String getPropertitesName() throws IOException {
		return "config" + File.separator + "app.properties";
	}
}
