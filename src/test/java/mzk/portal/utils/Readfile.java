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

	public String getExpiryYear() {
		String year = pro.getProperty("EXPIRYYEAR");
		return year;
	}
	
	public String getLanguage() {
		String Language = pro.getProperty("LANGUAGE");
		return Language;
	}

	public String getAddress() {
		String Address = pro.getProperty("ADDRESS");
		return Address;
	}

	public String getEID() {
		String eid = pro.getProperty("EMIRATESID");
		return eid;
	}

	public String getEmailid() {
		String eid = pro.getProperty("EMAILID");
		return eid;
	}

	public String getFirstName() {
		String Firstname = pro.getProperty("FIRSTNAME");
		return Firstname;
	}

	public String getLastName() {
		String Lastname = pro.getProperty("LASTNAME");
		return Lastname;
	}

	public String getEIDNumber() {
		String EIDnum = pro.getProperty("EIDNUMBER");
		return EIDnum;
	}

	public String getDateOfBirth() {
		String DateOfBirth = pro.getProperty("DOB");
		return DateOfBirth;
	}

	public String getMobilenumber() {
		String Mobilenumber = pro.getProperty("MOBILENUMBER");
		return Mobilenumber;
	}
	
	public String getEffectiveDate() {
		String EffectiveDate = pro.getProperty("EFFECTIVEDATE");
		return EffectiveDate;
	}
}
