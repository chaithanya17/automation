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
		
		boolean banner = driver.findElement(By.xpath("//div[@class='banner-img flex-65']")).isDisplayed();
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
	
	@Test(priority = 8)
	public void howTo_useBro4u() {
		
		List<WebElement> headingtitle = driver.findElements(By.xpath("//h2[@class='activity-head-text']"));
		if (headingtitle.get(2).isDisplayed()) {
			System.out.println(headingtitle.get(2).getText());
		}else {
			System.out.println("What’s happening around you is missing on the page");
	}
		List<WebElement> videos = driver.findElements(By.xpath("//div[@class='play-btn-container']"));
		System.out.println("Total videos displaying on screen are: "+videos.size()+"\n");
		boolean playbutton = driver.findElement(By.xpath("//img[@alt='Video Preview Button']")).isDisplayed();
		System.out.println("Play button on video is present: "+playbutton+"\n");
	}
	
	@Test(priority = 9)
	public void why_bro4u() {
		boolean whyBro4u_card = driver.findElement(By.xpath("//md-card[@layout-align='center center']")).isDisplayed();
		System.out.println("Why Bro4u card is present: "+whyBro4u_card+"\n");
		System.out.println(driver.findElement(By.xpath("//h2[@class='how-text-head ng-binding']")).getText()+"\n");
		
		List<WebElement> subtext = driver.findElements(By.xpath("//md-list-item[@role='listitem']"));
		for (int i = 0; i < subtext.size(); i++) {
			if (subtext.get(i).isDisplayed()) {
				System.out.println(subtext.get(i).getText());
			}
		}
	}
	
	@Test(priority = 10)
	public void download_applink() {
		
		boolean app_download_component = driver.findElement(By.xpath("//app-download-component[@layout-align='center']")).isDisplayed();
		System.out.println("App download component is present: "+app_download_component+"\n");
		System.out.println(driver.findElement(By.xpath("//span[@class='bold-font font-white']")).getText()+"\n");
		
		boolean downloadApp_image = driver.findElement(By.xpath("//img[@alt='Download bro4u app']")).isDisplayed();
		System.out.println("Download app image is present: "+downloadApp_image+"\n");
		
		List<WebElement> subtext = driver.findElements(By.xpath("//span[@class='bold-font-subContent font-white']"));
		System.out.println(subtext.get(0).getText()+"\n");
		boolean appstore_Dlink = driver.findElement(By.xpath("//img[@alt='Download App From App Store']")).isDisplayed();
		System.out.println("App store download link is present: "+appstore_Dlink+"\n");
		
		boolean google_playstore_link = driver.findElement(By.xpath("//img[@alt='Download App From Play Store']")).isDisplayed();
		System.out.println("Google playstore download link is present : "+google_playstore_link+"\n");
		
		System.out.println(subtext.get(1).getText());
		boolean mobileNum_textbox = driver.findElement(By.id("connectionNumber")).isDisplayed();
		System.out.println("Mobile number textbox under app download component is present: "+mobileNum_textbox+"\n");
		
		boolean getNow_button = driver.findElement(By.xpath("//button[contains(text(),'GET NOW')]")).isEnabled();
		System.out.println("Get now button is enabled: "+getNow_button+"\n");
	}
	
	@Test(priority = 11)
	public void listAs_partner() {
		boolean listas_partnerComp = driver.findElement(By.xpath("//div[@class='how-it-works become-partner']")).isDisplayed();
		System.out.println("List As a partner component is Present: "+listas_partnerComp+"\n");
		System.out.println(driver.findElement(By.xpath("//h2[contains(text(),'Are you a Service Professional?')]")).getText());
		
		boolean list_Aspartner_button = driver.findElement(By.xpath("//a[contains(text(),'List as Partner')]")).isEnabled();
		System.out.println("List as a partner button is enabled: "+list_Aspartner_button+"\n");
	}
	
	@Test(priority = 12)
	public void footer_links() {
		
		boolean footer_logo = driver.findElement(By.id("footer_logo")).isDisplayed();
		System.out.println("Footer logo is present: "+footer_logo+"\n");

		System.out.println("Total number of social links: "+driver.findElements(By.xpath("//a[@rel='nofollow']")).size()+"\n");

		List<WebElement> footer_links= driver.findElements(By.tagName("a"));
		for (int i = 8; i < footer_links.size(); i++) {
			System.out.println(footer_links.get(i).getText());
		}
		boolean copyright = driver.findElement(By.xpath("//div[@class='prop-info layout-padding ng-binding flex-sm-90 flex-md-90 flex-75']")).isDisplayed();
		System.out.println("Copyright is displaying on screen: "+copyright+"\n");
		System.out.println(driver.findElement(By.xpath("//div[@class='prop-info layout-padding ng-binding flex-sm-90 flex-md-90 flex-75']")).getText()+"\n");
		driver.quit();
	}
}
