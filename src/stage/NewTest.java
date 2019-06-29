package stage;

import java.util.List;
import java.util.concurrent.TimeUnit;

//import org.junit.AfterClass;
//import org.junit.BeforeClass;
//import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class NewTest {
  
	static WebDriver driver;
	
	@BeforeTest
	public void webpage(){
		
		System.setProperty("webdriver.chrome.driver","driver/chromedriver");
		ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("window-size=1200x600");
  		driver=new ChromeDriver(options);
		driver.get("https://web.staging.bro4u.com/");
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		
	}

	@Test(priority=1)
	public void set_location() throws InterruptedException{
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//label[contains(text(),'Location ?')]")).click();
		Thread.sleep(500);
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
	public void select_category() throws InterruptedException{
		
		driver.findElement(By.xpath("//img[@alt='Electricians']")).click();
		Thread.sleep(1000);
    
	}
	
	@Test(priority=3)
	public void select_requirement() throws InterruptedException{
		
		driver.findElement(By.xpath("//button[@class='md-datepicker-triangle-button md-icon-button md-button']")).click();
		List<WebElement>CalenderDateSel = driver.findElements(By.xpath("//span[@class='md-calendar-date-selection-indicator']"));
		Thread.sleep(1000);
		CalenderDateSel.get(3).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//md-select[@name='service_time']")).click();
		List<WebElement>selecttime = driver.findElements(By.xpath("//md-option[@ng-if='$ctrl.timeSlots && $ctrl.timeSlots.length']"));
		selecttime.get(3).click();
		Thread.sleep(1000);	
		
	}
	
	@Test(priority=4)
	public void contact_details() throws InterruptedException{
		
		driver.findElement(By.name("name")).sendKeys("Chaithanya");
		driver.findElement(By.name("streetName")).sendKeys("bro4u, Rajajinagar");
		driver.findElement(By.name("email")).sendKeys("chai@gmail.com");
		driver.findElement(By.name("mobile")).sendKeys("8310852676");
		Thread.sleep(800);
		List<WebElement>BookNowButton = driver.findElements(By.xpath("//button[contains(text(),'Book Now')]"));
		BookNowButton.get(0).click();
		Thread.sleep(2500);
	}
	
	@Test(priority=5)
	public void orderReview() throws InterruptedException{
		
		WebElement reviewtext = driver.findElement(By.xpath("//md-card-title-text[@class='order-review-head-title layout-row']"));
        //System.out.println(reviewtext.getText());
		Assert.assertEquals(reviewtext.getText().contains("Review Your Request"), true);				
		Thread.sleep(1000);
		
		//back to home screen to select other category
		driver.navigate().back();
		Thread.sleep(1000);
	}
	
	@Test(priority=6)
	public void weddingPhotography() throws InterruptedException{
		
		  driver.findElement(By.xpath("//div[@id='search_services_input']")).click();
		  Thread.sleep(600);
		  driver.findElement(By.xpath("//input[@placeholder='Search for services']")).sendKeys("wedding");
		  Thread.sleep(800);
		  List<WebElement> subCategories = driver.findElements(By.xpath("//div[@ng-repeat='item in searchServiceCtrl.searchResult']"));
		  subCategories.get(1).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//button[contains(text(),'View Experts')]")).click();
		  Thread.sleep(1000);
	}
	
	@Test(priority=7)
	public void requireScreen() throws InterruptedException{
		
		List<WebElement> selectOptions = driver.findElements(By.xpath("//md-radio-button[@aria-label='Option Filters']"));
		selectOptions.get(0).click();
		Thread.sleep(1000);
		selectOptions.get(3).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(text(),'TOMORROW')]")).click();
		Thread.sleep(200);
		List<WebElement>selectTimeslot = driver.findElements(By.xpath("//button[@ng-repeat='item in $ctrl.slotSelection.tomSlots']"));
		selectTimeslot.get(1).click();
		
		driver.findElement(By.xpath("//button[contains(text(),'Choose Expert')]")).click();
		Thread.sleep(1000);
	}
	
	@Test(priority=8)
	public void vendorlistScreen() throws InterruptedException{
		
		  driver.findElement(By.xpath("//button[contains(text(),'Book Now')]")).click();
		  Thread.sleep(1000);
		  
		  //order review screen
		  WebElement reviewtext = driver.findElement(By.xpath("//span[contains(text(),'Review Selection And Confirm Order')]"));
		  Assert.assertEquals(reviewtext.getText().contains("Review Selection And Confirm Order"), true);				
		  Thread.sleep(1000);
	}
}
