package stage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class msiteLandingPageRedesign {
	static WebDriver driver;

  @BeforeTest
  public void browserlaunch() {
		  
	  System.setProperty("webdriver.chrome.driver","driver/chromedriver");
	  Map<String, String> mobileEmulation = new HashMap<String, String>();
	  mobileEmulation.put("deviceName", "Galaxy S5");
	  Map<String, Object> chromeOptions = new HashMap<String, Object>();
	  chromeOptions.put("mobileEmulation", mobileEmulation);
	  DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	  capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
	  driver = new ChromeDriver(capabilities);
	  driver.get("https://m.staging.bro4u.com/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);		  
  }
  
  @Test(priority=1)
	public void setLocation() throws InterruptedException{
		
		Thread.sleep(1500);
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
	  
	    driver.findElement(By.xpath("//span[contains(text(),'Search for services')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Search for services']")).sendKeys("breakdown");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='button']")).click();
		System.out.println("screen title is : "+ driver.findElement(By.xpath("//span[contains(text(),'Select your Requirement')]")).getText()+"\n");	
		Thread.sleep(200);
		List<WebElement> pricechart = driver.findElements(By.xpath("//span[contains(text(),'Price Chart')]"));
		if (pricechart.size()>0) {
			System.out.println("price chart is displaying"+"\n");
			Thread.sleep(200);
			List<WebElement> open_pricechart = driver.findElements(By.xpath("//div[@ng-repeat='eachPriceCard in $ctrl.intScn.intermediateData.price_chart | limitTo:5']"));
			open_pricechart.get(0).click();
			Thread.sleep(500);
			driver.findElement(By.xpath("//i[@class='fa fa-times big-btn']")).click();
		}
		else {
			System.out.println("price chart is not displaying"+"\n");
		}
		Thread.sleep(800);
  	}
  
  @Test(priority = 3)
	public void dateTimeicon() throws InterruptedException {

		boolean calendericon = driver.findElement(By.xpath("//i[@class='fa fa-calendar']")).isDisplayed();
		System.out.println("Calender icon is present : "+calendericon+"\n");
		
		boolean timeicon = driver.findElement(By.xpath("//i[@class='fa fa-clock-o']")).isDisplayed();
		System.out.println("Time icon is present : "+timeicon+"\n");
		Thread.sleep(1000);
	}
  
  @Test(priority = 4)
	public void requirementselect() throws InterruptedException {
		driver.findElement(By.name("service_type")).click();
		Thread.sleep(300);
		List<WebElement> optionSelect = driver.findElements(By.xpath("//md-option[@ng-repeat='option in $ctrl.intScn.intermediateData.option_data track by $index']"));
		optionSelect.get(1).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//md-select[@aria-label='Breakdown Type']")).click();
		List<WebElement> selectoption = driver.findElements(By.xpath("//md-option[@ng-repeat='option in card.options track by option.option_id']"));
		selectoption.get(1).click();
		Thread.sleep(300);

		driver.findElement(By.id("input_26")).click();
		Thread.sleep(200);
  		List<WebElement> selectdate = driver.findElements(By.xpath("//td[@class='md-calendar-date']"));
  		selectdate.get(3).click();
  		Thread.sleep(500);
  		driver.findElement(By.xpath("//md-select[@name='service_time']")).click();
  		List<WebElement>selecttime = driver.findElements(By.xpath("//md-option[@ng-if='$ctrl.timeSlots && $ctrl.timeSlots.length']"));
  		selecttime.get(2).click();
  		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();	
	}
  
  @Test(priority = 5)
	public void provideDetails_screen() throws InterruptedException {
      JavascriptExecutor js = (JavascriptExecutor) driver;

	  System.out.println("Next screen title is : "+driver.findElement(By.xpath("//span[contains(text(),'Provide Details')]")).getText()+"\n");
	  Thread.sleep(300);

	  boolean backArrow = driver.findElement(By.xpath("//i[@class='fa fa-long-arrow-left']")).isDisplayed();
	  System.out.println("Back button is present on Provide details: "+backArrow+"\n");

	  driver.findElement(By.name("name")).sendKeys("Chaithanya");
	  driver.findElement(By.name("streetName")).sendKeys("bro4u, Rajajinagar");
	  driver.findElement(By.name("email")).sendKeys("chai@gmail.com");
	  driver.findElement(By.name("mobile")).sendKeys("8311852676");
	  Thread.sleep(500);

	  js.executeScript("window.scrollBy(0,500)");
      driver.findElement(By.id("location_int")).sendKeys("hampinagar");
	  Thread.sleep(1000);
	  List<WebElement>locationList = driver.findElements(By.id("g-autocomp-pred-container"));
	  Thread.sleep(400);
	  locationList.get(0).click();
	  Thread.sleep(1400);

	  js.executeScript("window.scrollBy(0,-500)");
	  Thread.sleep(800);
	  driver.findElement(By.xpath("//button[contains(text(),'Book Now')]")).click();
	  Thread.sleep(2000);	
	}
  
  @Test(priority = 6)
	public void reveiwRequest_screen() throws InterruptedException {
		System.out.println("screen title is : "+driver.findElement(By.xpath("//span[contains(text(),'Review Your Request')]")).getText()+"\n");
		boolean backArrow = driver.findElement(By.xpath("//i[@class='fa fa-long-arrow-left']")).isDisplayed();
		System.out.println("Back button is present on Review your request: "+backArrow+"\n");
		Thread.sleep(1500);

		System.out.println(driver.findElement(By.xpath("//span[contains(text(),'Contact details')]")).getText());
		List<WebElement> details = driver.findElements(By.xpath("//div[@class='service-detail layout-column flex-100']"));
		System.out.println(details.get(1).getText()+"\n");		
		System.out.println(driver.findElement(By.xpath("//span[contains(text(),'Service partner will visit below address')]")).getText());
		System.out.println(details.get(2).getText()+"\n");;
	}
  
  @Test(priority = 7)
	public void ConfirmOtp_verify() throws InterruptedException {
	  
		System.out.println(driver.findElement(By.xpath("//span[contains(text(),'confirm OTP')]")).getText()+"\n");
		boolean mobileNumber = driver.findElement(By.xpath("//div[@class='layout-align-start-center layout-row flex-25']")).isDisplayed();
		System.out.println("mobile number is present : "+mobileNumber+"\n");
		
		boolean changeButton = driver.findElement(By.xpath("//div[@class='change-number-btn-container layout-align-start-center layout-row flex-25']")).isDisplayed();
		System.out.println("Change button is present : "+changeButton+"\n");
		
		boolean resendOtpButton = driver.findElement(By.xpath("//span[contains(text(),'resend otp')]")).isSelected();
		System.out.println("Resend otp button is enabled : "+resendOtpButton+"\n");
		boolean timer = driver.findElement(By.xpath("//span[@ng-show='!$ctrl.isOtpCountDownZero()']")).isDisplayed();
		System.out.println("timer is present : "+timer+"\n");
		System.out.println("Timer value is : "+driver.findElement(By.xpath("//span[@ng-show='!$ctrl.isOtpCountDownZero()']")).getText()+"\n");
		boolean otpTextbox = driver.findElement(By.name("otpEntered")).isDisplayed();
		System.out.println("Otp textbox is present : "+otpTextbox+"\n");
		//check change button is working or not
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='change-number-btn-container layout-align-start-center layout-row flex-25']")).click();
		driver.findElement(By.name("mobile")).sendKeys("7801787879");
		List<WebElement>BookNowButton = driver.findElements(By.xpath("//button[contains(text(),'Book Now')]"));
		BookNowButton.get(0).click();
		Thread.sleep(2000);
	}
	
  @Test(priority = 8)
	public void verify_backbutton() throws InterruptedException {
		  
	  driver.findElement(By.xpath("//i[@class='fa fa-long-arrow-left']")).click();
	  Thread.sleep(1500);
	  driver.findElement(By.xpath("//i[@class='fa fa-long-arrow-left']")).click();

	  WebElement screenTitle = driver.findElement(By.xpath("//span[contains(text(),'Select your Requirement')]"));
	  if (screenTitle.isDisplayed()) {
		  System.out.println("Back button is working fine"+ "\n");
	  }else {
		  System.out.println("Back button is not working"+"\n");
	  }
	  Thread.sleep(1500);
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	  Thread.sleep(1000);
	  List<WebElement>BookNowButton = driver.findElements(By.xpath("//button[contains(text(),'Book Now')]"));
	  BookNowButton.get(0).click();
	  Thread.sleep(2000);	
	}
  
  @Test(priority = 9)
	public void invalidOtp_resendotp() throws InterruptedException {
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0,500)");
	  Thread.sleep(500);
	  driver.findElement(By.name("otpEntered")).sendKeys("78788");
	  Thread.sleep(800);
	  driver.findElement(By.xpath("//button[@ng-click='$ctrl.proceedLandingBooking()']")).click();
	  Thread.sleep(200);
	  //WebElement toastMessage = driver.findElement(By.xpath("//span[@class='md-toast-text ng-binding']"));
	  System.out.println("Enter valid otp toast message");
	  Thread.sleep(62000);
	  boolean resendOtpButton = driver.findElement(By.xpath("//span[contains(text(),'resend otp')]")).isEnabled();
	  System.out.println("Resend otp button is enabled : "+resendOtpButton+"\n");
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//span[contains(text(),'resend otp')]")).click();
	  Thread.sleep(200);
	  System.out.println("Resend otp toast");
	  driver.quit();
  }
  
}
