package com.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.Pages.LoginPage;
import com.Utilites.DPExcel;

public class LoginTest extends BaseTest {
    LoginPage objLogin;

    @Test(priority = 1, dataProvider = "excelData", dataProviderClass = DPExcel.class)
    public void testLogin(String username, String password, String testType) {
    	objLogin=new LoginPage(getDriver());
        objLogin.login(username, password);

        switch (testType.toLowerCase()) {
            case "pass":
                Assert.assertFalse(driver.get().getTitle().contains("Swag Labs: Login"), "Login failed for valid user.");
                break;
            default:
                Assert.fail("Invalid test type in Excel: " + testType);
        }
    }
}
