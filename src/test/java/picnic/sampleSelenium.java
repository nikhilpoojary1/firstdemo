package picnic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sampleSelenium {
	
	
	ExtentSparkReporter reporter;
	ExtentReports extent;

	@BeforeSuite
	public void setUp() {
	reporter = new ExtentSparkReporter("myreport.html");
	extent = new ExtentReports();
	extent.attachReporter(reporter);
	}
	@Test
	public void TestMethod() {
		
		ExtentTest test = extent.createTest("My first test");
		test.log(Status.INFO, "This shows info");
		
		

		// System.setProperty("webdriver.chrome.driver","C:\\Users\\nikhiln.MAVERICSYSTEMS\\selenium\\selenium\\driver\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		;

		WebElement name = driver.findElement(By.id("txtUsername"));
		name.sendKeys("Admin");
		WebElement pass = driver.findElement(By.id("txtPassword"));
		pass.sendKeys("admin123");
		WebElement submit = driver.findElement(By.id("btnLogin"));
		submit.click();

	}
	
	@AfterSuite
	public void tearDown() {
	extent.flush();
	}
}
