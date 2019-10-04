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

public class contactModel {
	
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
	 /* WebElement selectpincode = driver.findElement(By.xpath("//input[@ng-model='ctrl.pinCode']"));
	  selectpincode.sendKeys("560010");
	  Thread.sleep(500);
	  driver.findElement(By.xpath("//button[contains(text(),'SET LOCATION')]")).click();
	  Thread.sleep(1000);*/
  }
  
  @Test(priority=2)
  public void SearchcontactModel() throws InterruptedException{
	  
	    driver.findElement(By.xpath("//li[@name='explore-services']")).click();
		Thread.sleep(500);
	    driver.findElement(By.xpath("//li[contains(text(),'Health & Personal')]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//h4[contains(text(),'Tattoo Artists')]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[@aria-label='Permanent']")).click();
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
		locationField.sendKeys("basavesh");
		Thread.sleep(1000);
		locationField.sendKeys(Keys.DOWN);
		locationField.sendKeys(Keys.RETURN);
		Thread.sleep(1000);
	  
	  List<WebElement>seltype = driver.findElements(By.xpath("//md-radio-button[@aria-label='Option Filters']"));
		seltype.get(0).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[contains(text(),'TOMORROW')]")).click();
		Thread.sleep(500);
		List<WebElement>seltime = driver.findElements(By.xpath("//button[@ng-repeat='item in $ctrl.slotSelection.tomSlots']"));
		seltime.get(1).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[contains(text(),'Choose Expert')]")).click();
		Thread.sleep(1000);
  }
  
  @Test(priority=5)
  public void vendorlistScren() throws InterruptedException{
	  driver.findElement(By.xpath("//button[contains(text(),'View')]")).click();
	  Thread.sleep(500);
	  driver.findElement(By.xpath("//button[contains(text(),'Go Back')]")).click();
	  Thread.sleep(500);
	  driver.findElement(By.xpath("//button[contains(text(),'GET CONTACT')]")).click();
	  Thread.sleep(1000);
	  
  }
  
  @Test(priority=6)
  public void reviewScreen(){
	  
	  WebElement reviewtext = driver.findElement(By.xpath("//span[contains(text(),'Review Selection And Confirm Order')]"));
		Assert.assertEquals(reviewtext.getText().contains("Review Selection And Confirm Order"), true); 
  }
  
  
  
}
