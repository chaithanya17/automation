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

public class msitePackageModel {
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
  public void searchBathroomCleaning() throws InterruptedException{
	  
	  driver.findElement(By.xpath("//span[contains(text(),'Search for services')]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@placeholder='Search for services']")).sendKeys("bathroom");
		Thread.sleep(2000);
		List<WebElement> selectservice1 = driver.findElements(By.xpath("//button[@class='md-no-style md-button md-ink-ripple']"));
		selectservice1.get(0).click();
		Thread.sleep(1000);	  
  }
  @Test(priority=3)
  public void intermediateScreen() throws InterruptedException{
	  
	  driver.findElement(By.xpath("//button[contains(text(),'View Packages')]")).click();
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
	 
	  driver.findElement(By.xpath("//button[contains(text(),'TOMORROW')]")).click();
		List<WebElement> selecttimeslot = driver.findElements(By.xpath("//md-grid-tile[@ng-repeat='item in $ctrl.slotSelection.tomSlots']"));
		selecttimeslot.get(3).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[contains(text(),'Choose A Package')]")).click();
		Thread.sleep(1000);
  }
  @Test(priority=5)
  public void quantitySelection() throws InterruptedException{
	  
	  WebElement increasequan = driver.findElement(By.xpath("//div[@ng-click='$ctrl.updateOrder(1,$index,item)']"));
		increasequan.click();
		Thread.sleep(500);
		increasequan.click();
		WebElement decreasequan = driver.findElement(By.xpath("//div[@ng-click='$ctrl.updateOrder(0,$index,item)']"));
		decreasequan.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[contains(text(),'continue')]")).click();
		Thread.sleep(1000);
  }
  @Test(priority=6)
  public void vendorListScreen() throws InterruptedException{
	  
	  driver.findElement(By.xpath("//button[contains(text(),'VIEW')]")).click();
	  Thread.sleep(500);
	  driver.navigate().back();
	  Thread.sleep(500);
	  driver.findElement(By.xpath("//button[contains(text(),'BOOK NOW')]")).click();
	  Thread.sleep(1000);
  }
  
  @Test(priority=7)
	public void orderReviewScreen(){
	
		WebElement reviewtext = driver.findElement(By.xpath("//h3[contains(text(),'Confirm Order')]"));
		Assert.assertEquals(reviewtext.getText().contains("Confirm Order"), true); 
	}
}
