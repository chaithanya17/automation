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
	 /* ChromeOptions options = new ChromeOptions();
      options.addArguments("headless");
      options.addArguments("window-size=1200x600");
	  //driver=new ChromeDriver(options);
		
		Map<String, String> mobileEmulation = new HashMap<String, String>();
		mobileEmulation.put("deviceName", "Galaxy S5");
		Map<String, Object> chromeOptions = new HashMap<String, Object>();
		chromeOptions.put("mobileEmulation", mobileEmulation);
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		driver = new ChromeDriver(capabilities); */
		//driver=new ChromeDriver(options);
	  
	  ChromeOptions options = new ChromeOptions();
	  options.addArguments("headless");
      options.addArguments("window-size=1200x600");
	  Map<String, String> mobileEmulation = new HashMap<String, String>();
	  mobileEmulation.put("deviceName", "Galaxy S5");
	  options.setExperimentalOption("mobileEmulation", mobileEmulation);
	  driver = new ChromeDriver(options);
	  driver.get("https://m.staging.bro4u.com/");
	  driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		
		//WebDriver driver = new ChromeDriver(capabilities);  	  
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
		//driver.findElement(By.id("input_5")).click();
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
  		Thread.sleep(1000);
  	}
  	
  	@Test(priority=5)
  	public void orderReviewScreen(){
  	
  		WebElement reviewtext = driver.findElement(By.xpath("//span[contains(text(),'Review Your Request')]"));
		Assert.assertEquals(reviewtext.getText().contains("Review Your Request"), true); 
  	}
}
