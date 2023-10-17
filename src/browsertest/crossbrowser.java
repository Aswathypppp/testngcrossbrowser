package browsertest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class crossbrowser {
	private WebDriver driver;
	private String URL ="https://practicetestautomation.com/practice-test-login/";
	@Parameters("browser")
	
  @BeforeTest
  public void beforetest(String browser) {
      if(browser.equalsIgnoreCase("firefox")) {
	  System.setProperty("webdriver.firefox.driver", "C:\\Users\\91960\\OneDrive\\Desktop\\Automation\\geckodriver-v0.33.0-win64\\geckodriver.exe");
	  driver = new FirefoxDriver();
	  driver.get("https://practicetestautomation.com/practice-test-login/");
	  driver.manage().window().maximize();
	  
      }else if(browser.equalsIgnoreCase("chrome")) {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\91960\\OneDrive\\Desktop\\Automation\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("https://practicetestautomation.com/practice-test-login/");
	  driver.manage().window().maximize();
      }
      else if(browser.equalsIgnoreCase("edge")) {
		  System.setProperty("webdriver.edge.driver", "C:\\Users\\91960\\OneDrive\\Desktop\\Automation\\edgedriver_win64\\msedgedriver.exe");
		 driver = new EdgeDriver();
		  driver.get("https://practicetestautomation.com/practice-test-login/");
		  driver.manage().window().maximize();
      }
      else {
    	  throw new IllegalArgumentException("The Browser type is undefined");
      } 
   
  }
  @Test
  public void Test() {
	  WebElement username = driver.findElement(By.xpath("//*[@name=\"username\"]"));
	  username.sendKeys("student");
	  WebElement pw = driver.findElement(By.xpath("//*[@name=\"password\"]"));
	  pw.sendKeys("Password123");
	  WebElement login = driver.findElement(By.id("submit"));
      login.click();
  }

  @AfterTest
  public void afterTest() {
	 // driver.close();
  }

}
