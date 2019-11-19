package stage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import net.bytebuddy.dynamic.scaffold.MethodRegistry.Handler.ForAbstractMethod;

public class HomescreenTestcases {
  
	static WebDriver driver;

	@BeforeTest
	public void webBrowser() {

		System.setProperty("webdriver.chrome.driver","driver/chromedriver");
		/*ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		options.addArguments("window-size=1200x600");
		driver=new ChromeDriver(options);*/
		driver= new ChromeDriver();
		driver.get("https://web.staging.bro4u.com/");
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
	}
	
	@Test(priority = 2)
	public void set_location() throws InterruptedException{

		Thread.sleep(1000);
		WebElement locationName= driver.findElement(By.id("header_loc_btn"));
		String location = locationName.getText();

		if (location.equals("Location ?")) {
		driver.findElement(By.xpath("//label[contains(text(),'Location ?')]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//label[contains(text(),'Bangalore')]")).click();
		WebElement selectlocation = driver.findElement(By.xpath("//input[@ng-model='ctrl.googlePlacesObject']"));
		selectlocation.sendKeys("hampinagar");
		Thread.sleep(1000);
		selectlocation.sendKeys(Keys.DOWN);
		selectlocation.sendKeys(Keys.RETURN);
		Thread.sleep(1500);
		System.out.println("Location Title : "+driver.findElement(By.id("header_loc_btn")).getText()+"\n");
		}else {
			System.out.println("Location Title : "+driver.findElement(By.id("header_loc_btn")).getText()+"\n");
		}
		Thread.sleep(800);
	}
	
	@Test(priority = 1)
	public void headerbar_verify() {
		
		boolean title = driver.findElement(By.xpath("//div[@class='brand-logo flex-sm-15 flex-md-15 flex-10']")).isDisplayed();
		System.out.println("Page title is present: "+title+"\n");
		System.out.println(driver.getTitle()+"\n");
		
		boolean setLocation = driver.findElement(By.xpath("//div[@class='loc-img']")).isDisplayed();
		System.out.println("Set Location is present: "+setLocation+"\n");
		
		boolean searchbar = driver.findElement(By.xpath("//div[@class='searchbar flex-90']")).isDisplayed();
		System.out.println("Search bar is present : "+searchbar);
		
		boolean profilepic = driver.findElement(By.id("header_profile_pic")).isDisplayed();
		System.out.println("Profile pic option is present: "+profilepic);
		
	}
	
	@Test(priority = 3)
	public void homebaroptions() {
		
		List<WebElement> homebar = driver.findElements(By.xpath("//li[@role='presentation']"));
		for (int i = 0; i < homebar.size(); i++) {
			if (homebar.get(i).isDisplayed()) {
				System.out.println(homebar.get(i).getText());
			}else {
				System.out.println("Home bar options are missing");
			}
		}
	}
	
	@Test(priority = 4)
	public void homebanner_check() {
		
		boolean banner = driver.findElement(By.xpath("//div[@class=\"carousel-item\"]")).isDisplayed();
		System.out.println("Banner is present: "+banner+"\n");
	}
	
	@Test(priority = 5)
	public void home_recharge_check() {
		boolean recharge_option = driver.findElement(By.xpath("//div[@class='homerecharge-input-form ng-scope']")).isDisplayed();
		System.out.println("Home recharge option is present: "+recharge_option+"\n");

		List<WebElement> options_recharge = driver.findElements(By.xpath("//md-tab-item[@ng-repeat=\"tab in $mdTabsCtrl.tabs\"]"));
		for (int i = 0; i < options_recharge.size(); i++) {
			if (options_recharge.get(i).isDisplayed()) {
				System.out.println(options_recharge.get(i).getText());
			}else {
				System.out.println("Recharge options are missing");
			}
		}

		List<WebElement>rech_optionRadio = driver.findElements(By.xpath("//md-radio-button[@role='radio']"));
		for (int j = 0; j < rech_optionRadio.size(); j++) {
			if (rech_optionRadio.get(j).isDisplayed()) {
				System.out.println(rech_optionRadio.get(j).getText());
			}else {
				System.out.println("Recharge options are missing");
			}
		}
		boolean mobileNum = driver.findElement(By.xpath("//input[@placeholder='Mobile Number']")).isDisplayed();
		System.out.println("Mobile number text box is present: "+mobileNum+"\n");
		boolean recharge_button = driver.findElement(By.xpath("//button[contains(text(),'RECHARGE NOW')]")).isDisplayed();
		System.out.println("Recharge button is present: "+recharge_button+"\n");
}
	
	@Test(priority = 6)
	public void trending_services() {
		
		List<WebElement> heading = driver.findElements(By.xpath("//h2[@class='activity-head-text']"));
		if (heading.get(0).isDisplayed()) {
			System.out.println(heading.get(0).getText());
		}else {
			System.out.println("Heading of Trending services is missing on screen");
		}
		List<WebElement>cat_names = driver.findElements(By.xpath("//div[@class='top-service-card ng-scope flex']"));
		System.out.println("Total categories displaying under Trending services: "+cat_names.size()+"\n");
		for (int i = 0; i < cat_names.size(); i++) {
			System.out.println(cat_names.get(i).getText());			
		}
		boolean moreservices_button = driver.findElement(By.xpath("//button[contains(text(),'More Services')]")).isDisplayed();
		System.out.println("More services button is Present: "+moreservices_button+"\n");
	}
	
	@Test(priority = 7)
	public void whats_happening_around() {
		List<WebElement> headingtit = driver.findElements(By.xpath("//h2[@class='activity-head-text']"));
		if (headingtit.get(1).isDisplayed()) {
			System.out.println(headingtit.get(1).getText());
		}else {
			System.out.println("What’s happening around you is missing on the page");
	}
		List<WebElement> activities = driver.findElements(By.xpath("//div[@ng-repeat='activity in $ctrl.activities']"));
		System.out.println("Total activities displaying are: "+activities.size()+"\n");
		for (int j = 0; j < activities.size(); j++) {
			System.out.println(activities.get(j).getText());
		}
		boolean loadMore_button = driver.findElement(By.xpath("//button[contains(text(),'Load More')]")).isDisplayed();
		System.out.println("Load more button is present: "+loadMore_button+"\n");
	}
}
