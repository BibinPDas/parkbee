package com.parkbee.test.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ElementProperties {

	private static Properties properties;

	static {
		String configPath = System.getProperty("user.dir") + "/elements/elements.properties";
		Properties defaultProps = new Properties();
		try (FileInputStream in = new FileInputStream(configPath)) {
			defaultProps.load(in);
			properties = defaultProps;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String get(String key) {
		return properties.getProperty(key);
	}

	public static String get(String key, String defaultValue) {
		return properties.getProperty(key, defaultValue);
	}
}
