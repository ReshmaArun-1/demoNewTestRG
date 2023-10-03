package base;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static FileReader fr;
	public static ExtentTest test1;
	public static String reportPath;
	public static ExtentReports extent = new ExtentReports();

	@BeforeSuite
	public static void createnewReport() {

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")
				.format(new Timestamp(System.currentTimeMillis()));
		reportPath = System.getProperty("user.dir") + "\\src\\test\\resources\\reports\\" + "STMExtentReport_"
				+ timeStamp + ".html";
		System.out.println("Report Path :" + reportPath);
		ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
		extent.attachReporter(spark);

	}

	@BeforeMethod
	public void setUp() throws IOException {

		if (driver == null) {
			System.out.println(System.getProperty("user.dir"));
			fr = new FileReader(
					System.getProperty("user.dir") + "\\src\\test\\resources\\configfiles\\config.properties");
			prop.load(fr);
			
		}
		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(prop.getProperty("testurl"));
			driver.manage().window().maximize();
		} else if (prop.getProperty("browser").equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			driver.get(prop.getProperty("testurl"));
			driver.manage().window().maximize();
		}
	}
//added new
	@AfterMethod
	public void tearDown()

	{
		driver.quit();
		System.out.println("tear down");
	}

	@AfterSuite
	public static void endTest() {

		extent.flush();

	}

}
