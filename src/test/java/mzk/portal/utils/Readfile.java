package mzk.portal.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Readfile {

	private Properties pro;
	private static Readfile instance;
	public Readfile() {
		File file = new File("./Configurations/config.properties");

		try {
			FileInputStream fls = new FileInputStream(file);
			pro = new Properties();
			pro.load(fls);
		} catch (Exception e) {
			System.out.println("Exception is :" + e.getMessage());
		}
	}
	
	public static Readfile getInstance() {
		if (instance == null) {
			instance = new Readfile();
		}
		return instance;
	}
	
	public String getUrl() {
		String url = pro.getProperty("URL");
		return url;
	}

	public String getEmail() {
		String Email = pro.getProperty("EMAIL");
		return Email;
	}
	
	public String getOtp() {
		String Otpp = pro.getProperty("OTP");
		return Otpp;
	}
	
	public String getEffectiveDate() {
		String EffectiveDate = pro.getProperty("EFFECTIVEDATE");
		return EffectiveDate;
	}
}
