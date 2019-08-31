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

public class mobilerecharge {
  
	static WebDriver driver;
	
	  @BeforeTest
	  public void webBrowser() {
		  
		  System.setProperty("webdriver.chrome.driver","driver/chromedriver");
		 ChromeOptions options = new ChromeOptions();
	      options.addArguments("headless");
	      options.addArguments("window-size=1200x600");
			driver=new ChromeDriver(options);
		  	//driver= new ChromeDriver();
			driver.get("https://web.staging.bro4u.com/");
			driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
			
	  }
	  
	  @Test
	  public void rechargelink() throws InterruptedException {
	  
		  driver.findElement(By.xpath("//li[@name='recharge']")).click();
			driver.findElement(By.xpath("//md-radio-button[@name='networktype']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@name='connectionNumber']")).sendKeys("8310852676");
			
			driver.findElement(By.id("operatorSelect")).click();
			List<WebElement>selectOperator = driver.findElements(By.xpath("//md-option[@class='ng-scope md-ink-ripple']"));
			selectOperator.get(3).click();
			Thread.sleep(1000);
			
			driver.findElement(By.id("circleSelect")).click();
			WebElement selectCircle = driver.findElement(By.xpath("//md-option[@ng-repeat='item in ($ctrl.operatorCircles | toArray:false)']"));
			selectCircle.sendKeys("k", Keys.ENTER);
			
			driver.findElement(By.name("amt")).sendKeys("250");
			driver.findElement(By.id("recharge-btn")).click();
	  }
	  //do login and proceed further 
}

