package testcase;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseTest;

import pages.BrowserstackPage;
import utilities.ActionClass;


public class SampleActions extends BaseTest {
	

		@Test
		public void testActions() throws Exception {

			try {

				test1 = extent.createTest("My Sample Test");
				BrowserstackPage bs = new BrowserstackPage(driver);
				test1.log(Status.PASS, "Navigated to the specified URL");

				ActionClass.clickAction(bs.dropdown_Product, "dropdown_Product");
				Thread.sleep(2000);
				ActionClass.clickAction(bs.dropdown_Item_Automate, "dropdown_Item_Automate");
					
				
				
				ActionClass.clickAction(bs.button_FreeTrial, "button_FreeTrial");
				
				Thread.sleep(3000);
				
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("window.scrollBy(0,10000)", "");
				
				Thread.sleep(3000);
				
				ActionClass.inputText(bs.input_Name, "input_Name", "Reshma");
				ActionClass.inputText(bs.input_Email, "input_Email", "test@345.com");
				ActionClass.inputText(bs.input_Password, "input_CompanyName", "ABtest6C");

			} catch (Exception e) {

				test1.log(Status.FAIL, "Test case Failed");

			}

		}
	}
