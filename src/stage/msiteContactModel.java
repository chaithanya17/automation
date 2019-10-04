package stage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class msiteContactModel {
	static WebDriver driver;
	
  @BeforeTest
  public void webPage() {
	  
	  System.setProperty("webdriver.chrome.driver","driver/chromedriver");
	  ChromeOptions options = new ChromeOptions();
	  options.addArguments("headless");
      options.addArguments("window-size=1200x600");
	  Map<String, String> mobileEmulation = new HashMap<String, String>();
	  mobileEmulation.put("deviceName", "Galaxy S5");
	  options.setExperimentalOption("mobileEmulation", mobileEmulation);
	  driver = new ChromeDriver(options);
	  driver.get("https://m.staging.bro4u.com/");
	  driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);   
  }
  
  @Test(priority=1)
	public void setLocation() throws InterruptedException{
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(text(),'Choose Your Location')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//h3[contains(text(),'Bangalore')]")).click();
		WebElement selectlocation = driver.findElement(By.id("input_0"));
		selectlocation.sendKeys("hampinagar");
	    Thread.sleep(1000);
	    List<WebElement> clickOnLocation= driver.findElements(By.xpath("//div[@role='listbox']"));
	    Thread.sleep(400);
	    clickOnLocation.get(0).click();
	    Thread.sleep(1500);		
	}
  @Test(priority=2)
  public void searchDrivingSchool() throws InterruptedException{
	  driver.findElement(By.xpath("//span[contains(text(),'Search for services')]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@placeholder='Search for services']")).sendKeys("driving");
		Thread.sleep(1000);
		List<WebElement> selectservice4 = driver.findElements(By.xpath("//button[@class='md-no-style md-button md-ink-ripple']"));
		selectservice4.get(1).click();
		Thread.sleep(1000);
 }
  @Test(priority=3)
  public void intermediateScreen() throws InterruptedException{
	  driver.findElement(By.xpath("//button[contains(text(),'View Experts')]")).click();
		Thread.sleep(1000);
  }
  @Test(priority=4)
  public void requirementScreen() throws InterruptedException{
	  
	  WebElement locationField = driver.findElement(By.id("location_int"));
		locationField.sendKeys("rajajinagar");
		Thread.sleep(1000);
	  List<WebElement>locationList = driver.findElements(By.id("g-autocomp-pred-container"));
	    Thread.sleep(400);
	  locationList.get(0).click();
	    Thread.sleep(1400);
	  
	  List<WebElement> filterselection = driver.findElements(By.xpath("//md-radio-button[@ng-repeat='option in card.options']"));
		filterselection.get(1).click();
		driver.findElement(By.xpath("//button[contains(text(),'TOMORROW')]")).click();
		Thread.sleep(200);
		List<WebElement> selecttimeslot3 = driver.findElements(By.xpath("//md-grid-tile[@ng-repeat='item in $ctrl.slotSelection.tomSlots']"));
		selecttimeslot3.get(4).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("//button[contains(text(),'Choose Expert')]")).click();
		Thread.sleep(1000);
  }
  @Test(priority=5)
  public void vendorListScreen() throws InterruptedException{
	  driver.findElement(By.xpath("//button[contains(text(),'VIEW')]")).click();
	  Thread.sleep(500);
	  driver.navigate().back();
	  Thread.sleep(500);
	  driver.findElement(By.xpath("//button[contains(text(),'GET CONTACT')]")).click();
	  Thread.sleep(1000);
  }
  
  @Test(priority=6)
	public void orderReviewScreen(){
		WebElement reviewtext = driver.findElement(By.xpath("//h3[contains(text(),'Confirm Order')]"));
		Assert.assertEquals(reviewtext.getText().contains("Confirm Order"), true); 
	}
}
