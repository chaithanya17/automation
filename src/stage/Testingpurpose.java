package stage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testingpurpose {
	static{
		System.setProperty("webdriver.chrome.driver","driver/chromedriver");
		}
	static WebDriver driver=null;
  
	@BeforeTest
  public void web() {
	  
	  driver = new ChromeDriver();
		driver.get("https://web.staging.bro4u.com/");
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
  }
	
	@Test(priority=1)
	public void set_location() throws InterruptedException{
		
		//driver.findElement(By.id("header_loc_btn")).click();
		driver.findElement(By.xpath("//label[contains(text(),'Location ?')]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//label[contains(text(),'Bangalore')]")).click();
		WebElement selectpincode = driver.findElement(By.xpath("//input[@ng-model='ctrl.pinCode']"));
		selectpincode.sendKeys("560010");
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[contains(text(),'SET LOCATION')]")).click();
		/*WebElement selectlocation = driver.findElement(By.xpath("//input[@ng-model='ctrl.googlePlacesObject']"));
		selectlocation.sendKeys("rajajinagar");
		Thread.sleep(1000);
		selectlocation.sendKeys(Keys.DOWN);
		selectlocation.sendKeys(Keys.RETURN);*/
		Thread.sleep(1000);
		}
	
	@Test(priority=2)
	public void select_category() throws InterruptedException{
		driver.findElement(By.xpath("//label[contains(text(),'Electricians')]")).click();
		
		}
	@Test(priority=3)
	public void select_requirement() throws InterruptedException{
		
		driver.findElement(By.xpath("//button[@class='md-datepicker-triangle-button md-icon-button md-button']")).click();
		List<WebElement>CalenderDateSel = driver.findElements(By.xpath("//span[@class='md-calendar-date-selection-indicator']"));
		//("//td[@id="md-1-month-2019-5-14"]")
		Thread.sleep(1000);
		CalenderDateSel.get(3).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//md-select[@name='service_time']")).click();
		List<WebElement>selecttime = driver.findElements(By.xpath("//md-option[@ng-if='$ctrl.timeSlots && $ctrl.timeSlots.length']"));
		selecttime.get(3).click();
		Thread.sleep(800);
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
	
}
