package testcase;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseTest;
import freemarker.template.utility.Constants;
import pages.SigninPage;
import utilities.ActionClass;
import utilities.ReadWriteExcel;

public class SecondTestCase extends BaseTest {
	
	public static String excelFilePath;
	public String username;
	public String password;

	@Test(dataProvider = "testdata")
	public static void loginTest(String uname, String pass) {
		try {
			
			test1 = extent.createTest("SecondTestCase");
			
			ReadWriteExcel excelUtils = new ReadWriteExcel();
			excelFilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\TestData.xlsx";

			
			excelUtils.setExcelFile(excelFilePath,"LogintoZOHO");
			
			
			
			
			
			SigninPage sp = new SigninPage(driver);
			driver.manage().window().maximize();
			test1.log(Status.PASS, "Navigated to the specified URL");

			ActionClass.clickAction(sp.link_SignIn, "link_SignIn");
			ActionClass.inputText(sp.input_LoginId, "input_LoginId", "htiuy@jhjh.com");
			ActionClass.clickAction(sp.btn_Next, "btn_Next");

			ActionClass.inputText(sp.input_password, "input_password", "random");
			ActionClass.clickAction(sp.btn_nextbtn, "btn_nextbtn");

			ActionClass.verifyScreen(sp.heading_home, "Home");
			System.out.println("title is : " + driver.getTitle());

		} catch (Exception e) {

			System.out.println("Verify Login");

		}
	}

	@DataProvider(name = "testdata")
	public Object[][] tData() {
		return new Object[][] {

				{ "reshmag2020g@gmail.com", "UmVzaG1hZ0Ax" }

		};

	}

}
