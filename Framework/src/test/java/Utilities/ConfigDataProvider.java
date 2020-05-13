package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
	public Properties pro;

	public ConfigDataProvider() {
		File srs = new File("./Config/Config.properties");
		try {

			FileInputStream fis = new FileInputStream(srs);
			pro = new Properties();

			pro.load(fis);

		} catch (Exception e) {
			System.out.println("file not found : " + e.getMessage());
		}
	}

	public String getDataFromConfi(String keySearch) {

		return pro.getProperty(keySearch);

	}

	public String getBrowser() {

		return pro.getProperty("Browser");

	}

	public String getqaUrl() {

		return pro.getProperty("qaUrl");
	}

}
