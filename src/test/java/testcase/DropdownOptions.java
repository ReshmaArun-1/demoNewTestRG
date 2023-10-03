package testcase;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base.BaseTest;

public class DropdownOptions extends BaseTest {
	
	
	@Test
	public static void testSelectmethod()
	{

		String url = " https://www.tutorialspoint.com/tutor_connect/index.php";
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Select s = new Select(driver.findElement(By.xpath("//select[@name=’selType’]")));
		// getting the list of options in the dropdown with getOptions()
		List<WebElement> op = s.getOptions();
		
		
		int size = op.size();
		for (int i = 0; i < size; i++) {
			String options = op.get(i).getText();
			System.out.println(options);
		}
		driver.quit();
	}
}