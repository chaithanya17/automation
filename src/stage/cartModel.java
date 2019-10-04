package stage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class cartModel {
	
	static WebDriver driver;
	
  @BeforeTest
  public void webPage() {
	  
	  System.setProperty("webdriver.chrome.driver","driver/chromedriver");
	  ChromeOptions options = new ChromeOptions();
      options.addArguments("headless");
      options.addArguments("window-size=1200x600");
	  driver=new ChromeDriver(options);
	  driver.get("https://web.staging.bro4u.com/");
	  driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);  
  }
  
  @Test(priority=1)
  public void setLocation() throws InterruptedException{
	  
	  Thread.sleep(1000);
	  driver.findElement(By.id("header_loc_btn")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//label[contains(text(),'Bangalore')]")).click();
	  WebElement selectlocation = driver.findElement(By.xpath("//input[@ng-model='ctrl.googlePlacesObject']"));
	  selectlocation.sendKeys("rajajinagar");
	  Thread.sleep(1000);
	  selectlocation.sendKeys(Keys.DOWN);
	  selectlocation.sendKeys(Keys.RETURN);
	  Thread.sleep(1000);
		
		/*WebElement selectpincode = driver.findElement(By.xpath("//input[@ng-model='ctrl.pinCode']"));
		  selectpincode.sendKeys("560010");
		  Thread.sleep(500);
		  driver.findElement(By.xpath("//button[contains(text(),'SET LOCATION')]")).click();
		  Thread.sleep(1000);*/
		
  }
  @Test(priority=2)
  public void searchBeautyServices() throws InterruptedException{
	  
	  	driver.findElement(By.xpath("//li[@name='explore-services']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[contains(text(),'Health & Personal')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//h4[contains(text(),'Beauty Services')]")).click();
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
		locationField.sendKeys("mallesh");
		Thread.sleep(1000);
		locationField.sendKeys(Keys.DOWN);
		locationField.sendKeys(Keys.RETURN);
		Thread.sleep(1000);
	  
	  driver.findElement(By.xpath("//button[contains(text(),'TOMORROW')]")).click();
		Thread.sleep(200);
		List<WebElement>seltime = driver.findElements(By.xpath("//button[@ng-repeat='item in $ctrl.slotSelection.tomSlots']"));
		seltime.get(1).click();
		driver.findElement(By.xpath("//button[contains(text(),'Choose Expert')]")).click();
		Thread.sleep(1000);
	  
  }
  
  @Test(priority=5)
  public void vendorlistScreen() throws InterruptedException{
	
	  driver.findElement(By.xpath("//button[contains(text(),'Book Now')]")).click();
		Thread.sleep(1000);
  }
  
  @Test(priority=6)
  public void selectionOfMenu() throws InterruptedException{
	  
	  	List<WebElement> selectiontab = driver.findElements(By.xpath("//md-tab-item[@ng-repeat='tab in $mdTabsCtrl.tabs']"));
		selectiontab.get(1).click();
		Thread.sleep(200);
		List<WebElement> selectoption = driver.findElements(By.xpath("//div[@ng-click='$ctrl.updateOrder(1,$index,item)']"));
		selectoption.get(1).click();
		Thread.sleep(200);
		selectoption.get(2).click();
		Thread.sleep(500);
		selectiontab.get(2).click();
		Thread.sleep(200);
		List<WebElement> selectoption1 = driver.findElements(By.xpath("//div[@ng-click='$ctrl.updateOrder(1,$index,item)']"));
		selectoption1.get(1).click();
		Thread.sleep(500);	
		driver.findElement(By.xpath("//button[contains(text(),'Book now')]")).click();
		Thread.sleep(1000);
  }
  
  @Test(priority=7)
  public void orderreview(){
	  WebElement reviewtext = driver.findElement(By.xpath("//span[contains(text(),'Review Selection And Confirm Order')]"));
		Assert.assertEquals(reviewtext.getText().contains("Review Selection And Confirm Order"), true); 
  }
}
