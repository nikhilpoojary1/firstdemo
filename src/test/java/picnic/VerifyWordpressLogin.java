package picnic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
* 
*/

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import picnic.LoginPage;
 
/**
* @author Mukesh_50
*
*/
public class VerifyWordpressLogin 
{
 
 
@Test
public void verifyValidLogin() throws InterruptedException
{
System.setProperty("webdriver.chrome.driver","C:\\Users\\nikhiln.MAVERICSYSTEMS\\selenium\\selenium\\driver\\chromedriver.exe");
WebDriverManager.chromedriver().setup();

 
WebDriver driver=new ChromeDriver();
driver.get("https://opensource-demo.orangehrmlive.com/");
 
driver.manage().window().maximize();
 
LoginPage login=new LoginPage(driver);
login.loginToWordpress("Admin","admin123");
Thread.sleep(2000);
 
/*
 * login.typeUserName("Admin"); Thread.sleep(2000);
 * login.typePassword("admin123"); Thread.sleep(2000);
 * login.clickOnLoginButton(); Thread.sleep(2000);
 */
 
driver.quit();
 
}
 
 
}
