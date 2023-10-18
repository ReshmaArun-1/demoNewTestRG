package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;

public class CartPage extends BaseTest {
	 public WebDriver driver;
		
	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	//adding latest changes for testing 
	@FindBy(css = "#user-name")
	public WebElement input_UserName;
	
	@FindBy(css = "#password")
	public WebElement input_Password;
	
	@FindBy(xpath = "//input[@type = 'submit']")
	public WebElement button_Login;
	
	@FindBy(css = ".product_sort_container")
	public WebElement select_ProductSort;
	
	@FindBy(css = "div.page_wrapper div:nth-child(2) div:nth-child(1) div.inventory_container div.inventory_list > div.inventory_item:nth-child(1)")
	public WebElement container_First;
	
	@FindBy(xpath = "//button[text() = 'Add to cart']")
	public WebElement button_AddToCart;
	
	@FindBy(css = "#remove-sauce-labs-onesie")
	public WebElement button_RemoveFromCart;
	
	@FindBy(xpath = "//a[@class = 'shopping_cart_link']")
	public WebElement link_CartLink;
	
	@FindBy(xpath = "//span[@class = 'shopping_cart_badge']")
	public WebElement link_CartBadge;
	
	@FindBy(xpath = "//div[@id = 'inventory_container']/div[@class = 'inventory_list']/div[1]/div/a")
	public WebElement img_FirstItem;
	
	@FindBy(xpath = "//div[@id = 'inventory_container']/div[@class = 'inventory_list']/div[1]/div[2]/div/a")
	public WebElement text_ItemName;
	
	@FindBy(css = "#back-to-products")
	public WebElement link_BackToProducts;
	
	@FindBy(css = ".inventory_item_name")
	public WebElement link_CartItemName;
	
	@FindBy(css = "#checkout")
	public WebElement button_Checkout;
	
	@FindBy(css = "span[class='title']")
	public WebElement titleText_Checkout;
	
	@FindBy(css = "#first-name")
	public WebElement input_FirstName;
	

	@FindBy(css = "#last-name")
	public WebElement input_LastName;

	@FindBy(css = "#postal-code")
	public WebElement input_PostalCode;
	
	@FindBy(css = "input[type = 'submit']")
	public WebElement button_Submit;
	
	@FindBy(css = "#finish")
	public WebElement button_Finish;
	
	@FindBy(xpath = "//h2[contains(text() , 'Thank you')]")
	public WebElement message_OrderConfirmed;
	
	
	
	
}
