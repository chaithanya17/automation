package stage;

import java.util.List;
import java.util.concurrent.TimeUnit;

//import org.junit.AfterClass;
//import org.junit.BeforeClass;
//import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
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
		/*driver.manage().deleteAllCookies();
		driver.manage().window().maximize();*/
	}

	@Test(priority=1)
	public void set_location() throws InterruptedException{
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//label[contains(text(),'Location ?')]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//label[contains(text(),'Bangalore')]")).click();
		WebElement selectpincode = driver.findElement(By.xpath("//input[@ng-model='ctrl.pinCode']"));
		selectpincode.sendKeys("560010");
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[contains(text(),'SET LOCATION')]")).click();
		Thread.sleep(1000);
		/*WebElement selectlocation = driver.findElement(By.xpath("//input[@ng-model='ctrl.googlePlacesObject']"));
		selectlocation.sendKeys("rajajinagar");
		Thread.sleep(1000);
		selectlocation.sendKeys(Keys.DOWN);
		selectlocation.sendKeys(Keys.RETURN);*/
		Thread.sleep(1000);
		
		
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
	public void orderReview(){
		
		WebElement reviewtext = driver.findElement(By.xpath("//md-card-title-text[@class='order-review-head-title layout-row']"));
        System.out.println(reviewtext.getText());
		Assert.assertEquals(reviewtext.getText().contains("Review Your Request"), true);				

		
	}
	/*@Test(priority=6)
	public void otpfield() throws InterruptedException{
		driver.findElement(By.xpath("//input[@name='otpEntered']")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//button[contains(text(),'Confirm booking')]")).click();
	}
	
	@AfterTest
	public void teardown(){
		driver.quit();
	}*/
	
}
