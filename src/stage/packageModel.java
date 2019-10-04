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

public class packageModel {
	
	static WebDriver driver;
	
  @BeforeTest
  public void webBrowser() {
	  
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
	 /* WebElement selectpincode = driver.findElement(By.xpath("//input[@ng-model='ctrl.pinCode']"));
	  selectpincode.sendKeys("560010");
	  Thread.sleep(500);
	  driver.findElement(By.xpath("//button[contains(text(),'SET LOCATION')]")).click();
	  Thread.sleep(1000);*/
  }
  
  @Test(priority=2)
  public void searchForSofaCleaning() throws InterruptedException{
	  driver.findElement(By.xpath("//div[@id='search_services_input']")).click();
	  Thread.sleep(600);
	  driver.findElement(By.xpath("//input[@placeholder='Search for services']")).sendKeys("sofa cleaning");
	  Thread.sleep(800);
	  driver.findElement(By.xpath("//img[@alt='Sofa Cleaning']")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[contains(text(),'View Packages')]")).click();
	  Thread.sleep(1000);

  }
  
  @Test(priority=3)
  public void requirementScreen() throws InterruptedException{
	  
	  WebElement locationField = driver.findElement(By.id("location_int"));
		locationField.sendKeys("hampinagar");
		Thread.sleep(1000);
		locationField.sendKeys(Keys.DOWN);
		locationField.sendKeys(Keys.RETURN);
		Thread.sleep(1000);
	  
	  WebElement increasequan = driver.findElement(By.xpath("//div[@ng-click='$ctrl.updateOrder(1,$index,item, option)']"));
		increasequan.click();
		Thread.sleep(200);
		increasequan.click();
		WebElement decreasequan = driver.findElement(By.xpath("//div[@ng-click='$ctrl.updateOrder(0,$index,item, option)']"));
		decreasequan.click();
		Thread.sleep(500);
		
		driver.findElement(By.xpath("//button[contains(text(),'TOMORROW')]")).click();
		Thread.sleep(200);
		List<WebElement>selectTimeslot = driver.findElements(By.xpath("//button[@ng-repeat='item in $ctrl.slotSelection.tomSlots']"));
		selectTimeslot.get(1).click();
		
		driver.findElement(By.xpath("//button[contains(text(),'Choose A Package')]")).click();
		Thread.sleep(1000);
  }
  
  @Test(priority=4)
  public void vendorListScreen() throws InterruptedException{
	  driver.findElement(By.xpath("//button[contains(text(),'Book Now')]")).click();
	  Thread.sleep(1000);
  }
  
  @Test(priority=5)
  public void orderReviewScreen(){
	  WebElement reviewtext = driver.findElement(By.xpath("//span[contains(text(),'Review Selection And Confirm Order')]"));
		Assert.assertEquals(reviewtext.getText().contains("Review Selection And Confirm Order"), true); 
	  
  }
  
}
