package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;

public class BrowserstackPage extends BaseTest {
	 public WebDriver driver;
		
	public BrowserstackPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath = "//button[@id = 'product-menu-toggle']")
	public WebElement dropdown_Product;
	
	@FindBy(xpath = "//*[@alt = 'Icon for BrowserStack Automate']")
	public WebElement dropdown_Item_Automate;
	
	@FindBy(xpath = "//a[text() = 'Free Trial']")
	public WebElement button_FreeTrial;

	@FindBy(xpath = "//input[@id = 'user_full_name']")
	public WebElement input_Name;
	
	@FindBy(xpath = "//input[@id = 'user_email_login']")
	public WebElement input_Email;
	
	@FindBy(xpath = "//input[@id = 'user_password']")
	public WebElement input_Password;
	
	}

