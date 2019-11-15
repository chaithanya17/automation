package stage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.Color;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class landingPageRedesignWeb {
	static WebDriver driver;

	@BeforeTest
	public void launchWebpage() {

		System.setProperty("webdriver.chrome.driver","driver/chromedriver");
		/*ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("window-size=1200x600");
  		driver=new ChromeDriver(options);*/
		driver= new ChromeDriver();
		driver.get("https://web.staging.bro4u.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void set_location() throws InterruptedException{

		Thread.sleep(1000);
		driver.findElement(By.xpath("//label[contains(text(),'Location ?')]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//label[contains(text(),'Bangalore')]")).click();
		WebElement selectlocation = driver.findElement(By.xpath("//input[@ng-model='ctrl.googlePlacesObject']"));
		selectlocation.sendKeys("hampinagar");
		Thread.sleep(1000);
		selectlocation.sendKeys(Keys.DOWN);
		selectlocation.sendKeys(Keys.RETURN);
		Thread.sleep(1500);
	}
	
	@Test(priority = 2)
	public void check_pricechart() throws InterruptedException {
		
		driver.findElement(By.xpath(" //label[contains(text(),'Search For Services Here...')]")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search for services']")).sendKeys("breakdown");
		Thread.sleep(800);
		driver.findElement(By.xpath("//div[@ng-repeat='item in searchServiceCtrl.searchResult']")).click();
		System.out.println("screen title is : "+ driver.findElement(By.xpath("//span[contains(text(),'Select your Requirement')]")).getText()+"\n");	
		Thread.sleep(200);
		List<WebElement> pricechart = driver.findElements(By.xpath("//span[contains(text(),'Price Chart')]"));
		if (pricechart.size()>0) {
			System.out.println("price chart is displaying"+"\n");
			Thread.sleep(200);
			List<WebElement> open_pricechart = driver.findElements(By.xpath("//div[@ng-repeat='eachPC in $ctrl.intScn.intermediateData.price_chart | limitTo:6']"));
			open_pricechart.get(1).click();
			Thread.sleep(500);
			driver.findElement(By.xpath("//i[@class=\"fa fa-times fa-1x\"]")).click();
		}
		else {
			System.out.println("price chart is not displaying"+"\n");
		}
		Thread.sleep(800);
	}
	
	@Test(priority = 3)
	public void dateTimeicon() throws InterruptedException {

		boolean calendericon = driver.findElement(By.xpath("//i[@class='fa fa-calendar mt-5']")).isDisplayed();
		System.out.println("Calender icon is present : "+calendericon+"\n");
		
		boolean timeicon = driver.findElement(By.xpath("//i[@class='fa fa-clock-o mt-9']")).isDisplayed();
		System.out.println("Time icon is present : "+timeicon+"\n");
		Thread.sleep(1000);
		
		/*driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(300);
		String textbox_colour = driver.findElement(By.xpath("//div[@class=\"md-datepicker-input-container\"]")).getCssValue("color");
		//String converthex = Color.fromString(textbox_colour).getColor();
		System.out.println("textbox colour is " +textbox_colour.gett);
		driver.quit();*/
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
		selectoption.get(2).click();
		Thread.sleep(300);

		driver.findElement(By.xpath("//button[@class='md-datepicker-triangle-button md-icon-button md-button']")).click();
		List<WebElement>CalenderDateSel = driver.findElements(By.xpath("//span[@class='md-calendar-date-selection-indicator']"));
		Thread.sleep(1000);
		CalenderDateSel.get(3).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//md-select[@name='service_time']")).click();
		Thread.sleep(500);
		List<WebElement>selecttime = driver.findElements(By.xpath("//md-option[@ng-if='$ctrl.timeSlots && $ctrl.timeSlots.length']"));
		selecttime.get(3).click();
		Thread.sleep(1500);	
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	}
	
	@Test(priority = 5)
	public void provideDetails_screen() throws InterruptedException {
		System.out.println("Next screen title is : "+driver.findElement(By.xpath("//span[contains(text(),'Provide Details')]")).getText()+"\n");
		Thread.sleep(300);
		
		boolean backArrow = driver.findElement(By.xpath("//i[@class='fa fa-long-arrow-left']")).isDisplayed();
		System.out.println("Back button is present on Provide details: "+backArrow+"\n");
		
		driver.findElement(By.name("name")).sendKeys("Chaithanya");
		driver.findElement(By.name("streetName")).sendKeys("bro4u, Rajajinagar");
		driver.findElement(By.name("email")).sendKeys("chai@gmail.com");
		driver.findElement(By.name("mobile")).sendKeys("8310852678");
		WebElement locationField = driver.findElement(By.id("location_int"));
		locationField.sendKeys("koramangala");
		Thread.sleep(1000);
		locationField.sendKeys(Keys.DOWN);
		locationField.sendKeys(Keys.RETURN);
		Thread.sleep(1000);
		List<WebElement>BookNowButton = driver.findElements(By.xpath("//button[contains(text(),'Book Now')]"));
		BookNowButton.get(0).click();
		Thread.sleep(1500);
		
	}
	
	@Test(priority = 6)
	public void reveiwRequest_screen() throws InterruptedException {
		System.out.println("screen title is : "+driver.findElement(By.xpath("//span[contains(text(),'Review Your Request')]")).getText()+"\n");
		boolean backArrow = driver.findElement(By.xpath("//i[@class='fa fa-long-arrow-left']")).isDisplayed();
		System.out.println("Back button is present on Review your request: "+backArrow+"\n");
		Thread.sleep(1500);

		System.out.println(driver.findElement(By.xpath("//span[contains(text(),'Contact details')]")).getText());
		List<WebElement> details = driver.findElements(By.xpath("//div[@class=\"service-detail layout-column flex-100\"]"));
		System.out.println(details.get(1).getText()+"\n");
			
	}
	
	@Test(priority = 7)
	public void ConfirmOtp_verify() throws InterruptedException {
		System.out.println(driver.findElement(By.xpath("//span[contains(text(),'confirm OTP')]")).getText()+"\n");
		boolean mobileNumber = driver.findElement(By.xpath("//div[@class=\"layout-align-start-center layout-row flex-30\"]")).isDisplayed();
		System.out.println("mobile number is present : "+mobileNumber+"\n");
		
		boolean changeButton = driver.findElement(By.xpath("//div[@class=\"change-number-btn-container layout-align-start-center layout-row flex-25\"]")).isDisplayed();
		System.out.println("Change button is present : "+changeButton+"\n");
		
		boolean resendOtpButton = driver.findElement(By.xpath("//span[contains(text(),'resend otp')]")).isSelected();
		System.out.println("Resend otp button is enabled : "+resendOtpButton+"\n");
		boolean timer = driver.findElement(By.xpath("//span[@ng-show=\"!$ctrl.isOtpCountDownZero()\"]")).isDisplayed();
		System.out.println("timer is present : "+timer+"\n");
		System.out.println("Timer value is : "+driver.findElement(By.xpath("//span[@ng-show=\"!$ctrl.isOtpCountDownZero()\"]")).getText()+"\n");
		boolean otpTextbox = driver.findElement(By.name("otpEntered")).isDisplayed();
		System.out.println("Otp textbox is present : "+otpTextbox+"\n");
		//check change button is working or not
		Thread.sleep(300);
		driver.findElement(By.xpath("//div[@class=\"change-number-btn-container layout-align-start-center layout-row flex-25\"]")).click();
		driver.findElement(By.name("mobile")).sendKeys("7878787879");
		List<WebElement>BookNowButton = driver.findElements(By.xpath("//button[contains(text(),'Book Now')]"));
		BookNowButton.get(0).click();
		Thread.sleep(4000);
	}
	
	@Test(priority = 8)
	public void verify_backbutton() throws InterruptedException {
		driver.findElement(By.xpath("//i[@class='fa fa-long-arrow-left']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//i[@class='fa fa-long-arrow-left']")).click();
		
		WebElement screenTitle = driver.findElement(By.xpath("//span[contains(text(),'Select your Requirement')]"));
		if (screenTitle.isDisplayed()) {
			System.out.println("Back button is working fine"+ "\n");
		}else {
			System.out.println("Back button is not working"+"\n");
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(800);
		List<WebElement>BookNowButton = driver.findElements(By.xpath("//button[contains(text(),'Book Now')]"));
		BookNowButton.get(0).click();
		Thread.sleep(800);	
	}
	
	@Test(priority = 9)
	public void invalidOtp_resendotp() throws InterruptedException {
		driver.findElement(By.name("otpEntered")).sendKeys("78788");
		Thread.sleep(300);
		driver.findElement(By.xpath("//button[@ng-click=\"$ctrl.proceedLandingBooking()\"]")).click();
		WebElement toastMessage = driver.findElement(By.xpath("//div[contains(text(),'Please Enter Valid OTP')]"));
		System.out.println(toastMessage.getText());
		Thread.sleep(62000);
		boolean resendOtpButton = driver.findElement(By.xpath("//span[contains(text(),'resend otp')]")).isEnabled();
		System.out.println("Resend otp button is enabled : "+resendOtpButton);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'resend otp')]")).click();
		Thread.sleep(200);
		System.out.println("resend otp toast : "+driver.findElement(By.xpath("//div[contains(text(),'OTP sent to your mobile no.')]")).getText()+"\n");
		driver.quit();
	}

	
}
