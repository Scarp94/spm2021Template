package pros.unicam.spm2021.practice.Selenium;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FirstTest {
  private WebDriver driver;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    
    ChromeOptions chromeOptions = new ChromeOptions();
	  chromeOptions.addArguments("--headless");
	  chromeOptions.addArguments("--start-maximized");
    driver = new ChromeDriver(chromeOptions);
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testFirst() throws Exception {
    driver.get("http://pros.unicam.it/");
    driver.findElement(By.xpath("//button[@onclick='alxMediaMenu.toggleItem(this)']")).click();
    driver.findElement(By.linkText("BPMN Metrics Extractor")).click();
    driver.findElement(By.linkText("Tools")).click();
    driver.findElement(By.linkText("Projects & Collaborations")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

}
