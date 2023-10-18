package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;

public class SigninPage extends BaseTest {
	 WebDriver driver;
	
	public SigninPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath = "//a[text() = 'Sign in']")
	public WebElement link_SignIn;
	
	@FindBy(xpath = "//input[@id = 'login_id']")
	public WebElement input_LoginId;
	
	@FindBy(xpath = "//span[text() = 'Next']")
	public WebElement btn_Next;
	
	@FindBy(xpath = "//input[@id = 'password']")
	public WebElement input_password;
	
	@FindBy(xpath = "//button[@id = 'nextbtn']")
	public WebElement btn_nextbtn;
	
	@FindBy(xpath = "//p[text() = ' Some of our most popular apps']")
	public WebElement heading_home;
	
	

}
