package com.learnautomation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {

	Properties properties;

	public ConfigDataProvider() {
		File file = new File(System.getProperty("user.dir") + "/Config/config.properties");
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			properties = new Properties();
			properties.load(fileInputStream);
		} catch (IOException e) {
			System.out.println("not able to load config file : " + e.getMessage());
		}
	}

	public String getDataFromConfig(String keyToSearch) {
		return properties.getProperty(keyToSearch);
	}

	public String getBrowser() {
		return properties.getProperty("browser");
	}

	public String getStagingURL() {
		return properties.getProperty("QA_URL");
	}

}
