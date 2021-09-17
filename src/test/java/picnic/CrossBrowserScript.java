package picnic;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
 
public class CrossBrowserScript {
 
WebDriver driver;
 
/**
* This function will execute before each Test tag in testng.xml
* @param browser
* @throws Exception
*/
@BeforeTest
@Parameters("browser")
public void setup(String browser) throws Exception{
//Check if parameter passed from TestNG is 'firefox'
if(browser.equalsIgnoreCase("chrome")){
//create firefox instance

System.setProperty("webdriver.chrome.driver","C:/Users/nikhiln.MAVERICSYSTEMS/selenium/selenium/driver/chromedriver.exe");
driver = new ChromeDriver();
}
 
//Check if parameter passed as 'chrome'
else if (browser.equalsIgnoreCase("firefox")){
	System.setProperty("webdriver.gecko.driver","C:/Users/nikhiln.MAVERICSYSTEMS/selenium/selenium/driver/geckodriver.exe");
	driver = new FirefoxDriver();
//set path to chromedriver.exe
	
 
}

else{
//If no browser passed throw exception
throw new Exception("Browser is not correct");
}
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
 
@Test
public void testParameterWithXML() throws InterruptedException{
	driver.get("https://opensource-demo.orangehrmlive.com/");   

	WebElement uname = driver.findElement(By.id("txtUsername"));
	
	uname.sendKeys("Admin");
	Thread.sleep(2000);
    WebElement passwd = driver.findElement(By.id("txtPassword"));
	
	passwd.sendKeys("admin123");
	
    WebElement submit = driver.findElement(By.id("btnLogin"));
	
	submit.click();
	
	Thread.sleep(3000);
	
	driver.quit();
}
}

