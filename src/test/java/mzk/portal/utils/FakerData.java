package mzk.portal.utils;

import com.github.javafaker.Faker;

public class FakerData {

	private static Faker instance = null;

	public FakerData() {

	}

	public static Faker getInstance() {
		if (instance == null) {
			synchronized (FakerData.class) {
				if (instance == null) {
					instance = new Faker();
				}
			}
		}
		return instance;
	}

	public static String firstName = FakerData.getInstance().name().firstName().replaceAll("[^a-zA-Z]", "");
	public static String lastName = FakerData.getInstance().name().lastName().replaceAll("[^a-zA-Z]", "");
	public static String emailid = FakerData.getInstance().internet().emailAddress();
	public static int randomnumber = FakerData.getInstance().number().numberBetween(1, 999);
	public static String MemberID = firstName + randomnumber;

}
