package testcase;

import java.util.Base64;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseTest;
import pages.SigninPage;
import utilities.ActionClass;

public class MyFirstTestFW extends BaseTest {

	@Test(dataProvider = "testdata")
	public static void loginTest(String uname, String pass) {
		try {
			
			test1 = extent.createTest("test"+Math.random());
			SigninPage sp = new SigninPage(driver);
					
			test1.log(Status.PASS, "Navigated to the specified URL");
			ActionClass.clickAction(sp.link_SignIn, "link_SignIn");
			ActionClass.inputText(sp.input_LoginId, "input_LoginId", uname);
			ActionClass.clickAction(sp.btn_Next, "btn_Next");
			
			byte[] decodedBytes = Base64.getDecoder().decode(pass);
			String decodedString = new String(decodedBytes);

			ActionClass.inputText(sp.input_password, "input_password",decodedString);
			ActionClass.clickAction(sp.btn_nextbtn, "btn_nextbtn");
			
			
			
			ActionClass.verifyScreen(sp.heading_home, "Explore All Products | Zoho");
			System.out.println("title is : " +driver.getTitle());
						
		
		} catch (Exception e) {

			test1.log(Status.FAIL, "Test case Failed");

		}
	}

	@DataProvider(name = "testdata")
	public Object[][] tData() {
		return new Object[][] {

				{ "reshmag2020g@gmail.com", "UmVzaG1hZ0Ax" }

		};

	}

}
