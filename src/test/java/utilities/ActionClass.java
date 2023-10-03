package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import base.BaseTest;

public class ActionClass extends BaseTest {
	
	public static Actions actions = new Actions(driver);
	public static JavascriptExecutor js = (JavascriptExecutor)driver;

	static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	public static void clickAction(WebElement element, String key) throws Exception {

		wait.until(ExpectedConditions.visibilityOf(element));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		highlightElement(driver, element);
		actions.click(element).build().perform();
		test1.addScreenCaptureFromPath(takeScreenhotAndReturnPath(key), key);
		test1.log(Status.PASS, "clicked on " + key);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(7));
	}

	public static void inputText(WebElement element, String key, String value) throws Exception {

		wait.until(ExpectedConditions.visibilityOf(element));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		highlightElement(driver, element);
		//actions.sendKeys(value).build().perform();
		element.sendKeys(value);
		test1.addScreenCaptureFromPath(takeScreenhotAndReturnPath(key), key);
		test1.log(Status.PASS, "Entered text in " + key);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		

	}
	
	public static void verifyScreenTitle(String title) throws Exception {

		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(7));
		Assert.assertEquals(driver.getTitle(), title);
		
		//test1.addScreenCaptureFromPath(takeScreenhotAndReturnPath(title), title);
		test1.log(Status.PASS, "Verified the "+title+" Screen Successfully");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		

	}

	public static void verifyScreen(WebElement element, String key) throws Exception {

		wait.until(ExpectedConditions.visibilityOf(element));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		test1.addScreenCaptureFromPath(takeScreenhotAndReturnPath(key), key);
		Assert.assertEquals(key, driver.getTitle());
		test1.log(Status.PASS, "Landed on " + key + " screen");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
	}
	
	public static void mouseHover(WebElement element, String key) throws Exception {

		wait.until(ExpectedConditions.visibilityOf(element));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		test1.addScreenCaptureFromPath(takeScreenhotAndReturnPath(key), key);
		highlightElement(driver, element);
		actions.moveToElement(element).build().perform();
		test1.log(Status.PASS, "Moved to " + key);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
	}
	
	public static String takeScreenhotAndReturnPath(String fileName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		File sourceScreenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destinationScreenshotFile = new File(System.getProperty("user.dir")
				+ "\\src\\test\\resources\\reports\\FailedTestsScreenshots\\" + fileName + dateName + ".png");
		FileUtils.copyFile(sourceScreenshotFile, destinationScreenshotFile);
		return destinationScreenshotFile.getAbsolutePath();
	}
	
	public static void selectValueByText(WebElement element,String value) throws IOException {
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(7));
		wait.until(ExpectedConditions.visibilityOf(element));
		highlightElement(driver, element);
		Select select = new Select(element);
		select.selectByVisibleText(value);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
		test1.addScreenCaptureFromPath(takeScreenhotAndReturnPath(value), value);
		test1.log(Status.PASS, "Selected the Value " + value);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(7));
		
	}
	
	public static void highlightElement(WebDriver driver,WebElement element)
	{
				
		js.executeScript("arguments[0].setAttribute('style' , 'background: yellow; border: 2px solid red;');",element);
		
		try {
			Thread.sleep(500);
					}
		catch(InterruptedException e)
		{
			System.out.println(e.getMessage());
		}
		
		js.executeScript("arguments[0].setAttribute('style' ,  'border: solid 2px white')",element);
	}
	
	public static void pageScroll() throws IOException {
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(7));
		test1.addScreenCaptureFromPath(takeScreenhotAndReturnPath("Scrolled"), "Scrolled");
	}
		

	



}
