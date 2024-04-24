package mzk.portal.utils;

import java.util.Random;

public class TestData {
    private static TestData instance;
    private Random random = new Random();

    int ISocode = 784;
    int dob = random.nextInt(2006 - 1900 + 1) + 1900;
    int randomNumber = random.nextInt(1000000) + 9999999;
    int lastdigit = random.nextInt(9) + 1;

    String Emiratesid = Integer.toString(ISocode) + dob + randomNumber + lastdigit;

    String Mobilenumber = Integer.toString(random.nextInt(900000000) + 100000000);
    
    String Passport = Integer.toString(random.nextInt(9000000) + 1000000);

    public TestData() {
       
    }

    public static TestData getInstance() {
        if (instance == null) {
            instance = new TestData();
        }
        return instance;
    }

    public String getEmirateID() {
        return Emiratesid;
    }

    public String getDOB() {
        String DOB = Emiratesid.substring(3, 7);
        return DOB;
    }

    public String getMobilenumber() {
        return Mobilenumber;
    }

    public String getPassportNumber() {
        return Passport;
    }
}
