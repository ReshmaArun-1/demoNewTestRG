package testcase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseTest;
import pages.CartPage;
import utilities.ActionClass;

public class SampleCart extends BaseTest {

	public static String product;

	@Test(dataProvider = "testdata")
	public static void loginTest(String uname, String pass) {
		try {

			test1 = extent.createTest("Sample Cart TestCase");
			CartPage sp = new CartPage(driver);

			ActionClass.inputText(sp.input_UserName, "User Name field", uname);
			
			
			ActionClass.inputText(sp.input_Password, "Password field", pass);

			ActionClass.clickAction(sp.button_Login, "Login button");

			System.out.println("title is : " + driver.getTitle());

			ActionClass.verifyScreenTitle("Swag Labs");

			ActionClass.selectValueByText(sp.select_ProductSort, "Price (low to high)");

			//String s = sp.container_First.getText();
			//System.out.println("Content : " + s);

			assertTrue(sp.link_CartLink.isDisplayed());
			
			product = sp.text_ItemName.getText().trim();

			ActionClass.clickAction(sp.img_FirstItem, "Open First Product");

			//Set<String> ele = driver.getWindowHandles();

			//System.out.println("Number of Windows : " + ele.size());
			System.out.println("button status : "+sp.button_AddToCart.isEnabled());

			
			
			
			//sp.button_AddToCart.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
			
			ActionClass.clickAction(sp.button_AddToCart, "Add to cart button");
			
			boolean check = sp.button_RemoveFromCart.isDisplayed();
			
			Assert.assertTrue(check);
			
			test1.log(Status.PASS, "Item Added to Cart Successfully");

			Assert.assertEquals(sp.link_CartBadge.isDisplayed(), true);
			ActionClass.clickAction(sp.link_BackToProducts, "Back to Products");

			ActionClass.pageScroll();

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));

			ActionClass.clickAction(sp.link_CartLink, "Cart Link");

			assertEquals(sp.link_CartItemName.getText().trim(), product);

			ActionClass.clickAction(sp.button_Checkout, "Checkout button");

			assertTrue(sp.titleText_Checkout.isDisplayed());

			ActionClass.inputText(sp.input_FirstName, "First Name Field", "Reshma");

			ActionClass.inputText(sp.input_LastName, "Last Name Field", "G");

			ActionClass.inputText(sp.input_PostalCode, "Postal code Field", "686513");

			ActionClass.clickAction(sp.button_Submit, "Submit button");
			ActionClass.pageScroll();

			ActionClass.clickAction(sp.button_Finish, "Finish button");

			assertTrue(sp.message_OrderConfirmed.isDisplayed());
			ActionClass.pageScroll();

		} catch (Exception e) {

			test1.log(Status.FAIL, "Test case Failed with the following error : "+e.getMessage());
 
		}
	}

	@DataProvider(name = "testdata")
	public Object[][] tData() {
		return new Object[][] {

				{ "standard_user", "secret_sauce" }

		};

	}

}
