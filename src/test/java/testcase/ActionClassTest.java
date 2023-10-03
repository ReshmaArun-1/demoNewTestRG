package testcase;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import base.BaseTest;

public class ActionClassTest extends BaseTest {
	
	
	@Test
	public static void testmethod()
	{
//specify the LambdaTest URL
	driver.get("https://www.lambdatest.com/");
	
	assertEquals(driver.getTitle(), "Next-Generation Mobile Apps and Cross Browser Testing Cloud | LambdaTest");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
//specify the locator of the Resources menu
	WebElement element = driver.findElement(By.xpath("//button[text() = 'Resources ']"));

         Actions act = new Actions(driver);
//mouse hover the Resources element
	act.moveToElement(element).build().perform();
	
//specify the locator for the element Blog and click
	driver.findElement(By.xpath("//h3[text() = 'Blog']")).click();
	
	

	assertEquals(driver.getCurrentUrl(), "https://www.lambdatest.com/blog/");

//verify the page title after navigating to the Blog section

	assertEquals(driver.getTitle(), "LambdaTest Blogs");

	driver.close();
}


}
