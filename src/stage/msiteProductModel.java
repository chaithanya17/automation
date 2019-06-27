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

public class msiteProductModel {
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
  public void cakeDelivery() throws InterruptedException{
	  
	    driver.findElement(By.xpath("//span[contains(text(),'Search for services')]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@placeholder='Search for services']")).sendKeys("Cake");
		Thread.sleep(2000);
		List<WebElement> selectservice3 = driver.findElements(By.xpath("//button[@class='md-no-style md-button md-ink-ripple']"));
		selectservice3.get(0).click();
		Thread.sleep(1000);
  }
  @Test(priority=3)
  public void requirementScreen() throws InterruptedException{
	  
	  List<WebElement> productfilteropt = driver.findElements(By.xpath("//md-radio-button[@aria-label='Option Filters']"));
		productfilteropt.get(0).click();
		Thread.sleep(200);
		productfilteropt.get(4).click();
		driver.findElement(By.xpath("//button[contains(text(),'TOMORROW')]")).click();
		Thread.sleep(200);
		List<WebElement> selecttimeslot2 = driver.findElements(By.xpath("//md-grid-tile[@ng-repeat='item in $ctrl.slotSelection.tomSlots']"));
		selecttimeslot2.get(1).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("//button[contains(text(),'VIEW Items')]")).click();
		Thread.sleep(1000);
  }
  @Test(priority=4)
  public void productSelection() throws InterruptedException{
	  
	  List<WebElement> cakeselection = driver.findElements(By.xpath("//md-card[@ng-repeat='vendor in $ctrl.dataArray']"));
		cakeselection.get(2).click();
		Thread.sleep(1000);
  }
  @Test(priority=5)
  public void quatitySelection() throws InterruptedException{
	  
	  WebElement increasequantity = driver.findElement(By.xpath("//div[@ng-click='$ctrl.updateQuantity(1)']"));
		increasequantity.click();
		Thread.sleep(200);
		increasequantity.click();
		WebElement decreasequantity = driver.findElement(By.xpath("//div[@ng-click='$ctrl.updateQuantity(0)']"));
		decreasequantity.click();
		Thread.sleep(200);
		driver.findElement(By.xpath("//button[contains(text(),'Order Now')]")).click();
		Thread.sleep(1000);
  }
  
  @Test(priority=6)
  public void orderReviewScreen(){
		WebElement reviewtext = driver.findElement(By.xpath("//h3[contains(text(),'Confirm Order')]"));
		Assert.assertEquals(reviewtext.getText().contains("Confirm Order"), true); 
	}
}
