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
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class msiteQuickModel {
	
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
		selectlocation.sendKeys("rajajinagar");
	    Thread.sleep(1000);
	    List<WebElement> clickOnLocation= driver.findElements(By.xpath("//div[@role='listbox']"));
	    Thread.sleep(400);
	    clickOnLocation.get(0).click();
	    Thread.sleep(1500);
  		
  	}
  
  	@Test(priority=2)
  	public void electriciansCategory() throws InterruptedException{
	  
	    //Thread.sleep(1000);
	    driver.findElement(By.xpath("//span[contains(text(),'Search for services')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Search for services']")).sendKeys("elect");
		Thread.sleep(1000);
		List<WebElement> selectservice = driver.findElements(By.xpath("//button[@class='md-no-style md-button md-ink-ripple']"));
		selectservice.get(0).click();
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//button[@class='md-datepicker-triangle-button md-icon-button md-button']")).click();
  }
  	@Test(priority=3)
  	public void formFillInterScreen() throws InterruptedException{
  		
  		driver.findElement(By.id("input_5")).click();
  		List<WebElement> selectdate = driver.findElements(By.xpath("//td[@class='md-calendar-date']"));
  		selectdate.get(3).click();
  		Thread.sleep(500);
  		driver.findElement(By.xpath("//md-select[@name='service_time']")).click();
  		List<WebElement>selecttime = driver.findElements(By.xpath("//md-option[@ng-if='$ctrl.timeSlots && $ctrl.timeSlots.length']"));
  		selecttime.get(2).click();
  		Thread.sleep(1000);
  	}
  	
  	@Test(priority=4)
  	public void contactDetails() throws InterruptedException{
  		
  		driver.findElement(By.name("name")).sendKeys("Chaithanya");
  		driver.findElement(By.name("streetName")).sendKeys("bro4u, Rajajinagar");
  		driver.findElement(By.name("email")).sendKeys("chai@gmail.com");
  		driver.findElement(By.name("mobile")).sendKeys("8310852676");
  		Thread.sleep(500);
  		driver.findElement(By.xpath("//button[contains(text(),'Book Now')]")).click();
  		Thread.sleep(2000);
  	}
  	
  	@Test(priority=5)
  	public void orderReviewScreen() throws InterruptedException{
  	
  		WebElement reviewtext = driver.findElement(By.xpath("//span[contains(text(),'Review Your Request')]"));
		Assert.assertEquals(reviewtext.getText().contains("Review Your Request"), true); 
		Thread.sleep(5000);
		
		//back to home screen to select other category
		driver.findElement(By.xpath("//img[@alt='Bro4u']")).click();
		Thread.sleep(3000);
  	}
  	
  	@Test(priority=6)
  	public void weddingPhotography() throws InterruptedException{
  		
  		driver.findElement(By.xpath("//span[contains(text(),'Search for services')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Search for services']")).sendKeys("wedding");
		Thread.sleep(1000);
		List<WebElement> subfilters = driver.findElements(By.xpath("//md-list-item[@role='listitem']"));
		subfilters.get(1).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(text(),'VIEW EXPERTS')]")).click();
		Thread.sleep(1000);	
  	}
  	
  	@Test(priority=7)
  	public void requirementScreen() throws InterruptedException{
  		
  		List<WebElement> selectFilters = driver.findElements(By.xpath("//md-radio-button[@aria-label='Option Filters']"));
  		selectFilters.get(1).click();
  		Thread.sleep(1000);
  		selectFilters.get(4).click();
  		Thread.sleep(1000);
  		driver.findElement(By.xpath("//button[contains(text(),'TOMORROW')]")).click();
		Thread.sleep(200);
		List<WebElement> selecttimeslot4 = driver.findElements(By.xpath("//md-grid-tile[@ng-repeat='item in $ctrl.slotSelection.tomSlots']"));
		selecttimeslot4.get(1).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("//button[contains(text(),'Choose Expert')]")).click();
		Thread.sleep(1000);
  	}
  	
  	@Test(priority=8)
  	public void vendorlistScreen() throws InterruptedException{
  		
  		driver.findElement(By.xpath("//button[contains(text(),'BOOK NOW')]")).click();
  		Thread.sleep(1000);
  		
  		// order review screen
  		WebElement reviewtext = driver.findElement(By.xpath("//h3[contains(text(),'Confirm Order')]"));
		Assert.assertEquals(reviewtext.getText().contains("Confirm Order"), true); 
		Thread.sleep(1000);
  		
  	}
}
