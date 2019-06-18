package stage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class weborderflow {

	static{
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
	}
	static WebDriver driver=null;
	
	
	public static void main(String[] args) throws InterruptedException, AWTException {
		
		driver = new ChromeDriver();
		driver.get("https://bro4u.com/");
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		//Regression test from Services
		weborderflow regressiontest = new weborderflow();
		regressiontest.Setlocation();
		//Thread.sleep(500);
		//regressiontest.quickmodel();
		//Thread.sleep(500);
		//regressiontest.packagemodel();
		//Thread.sleep(500);
		//regressiontest.Quotemodel();
		//Thread.sleep(500);
		//regressiontest.productmodel();
		//Thread.sleep(500);
		//regressiontest.contactmodel();
		//Thread.sleep(500);
		//regressiontest.cartmodel();
		
		}
	
	public void Setlocation() throws InterruptedException, AWTException{
		Thread.sleep(1000);
		driver.findElement(By.id("header_loc_btn")).click();
		//driver.findElement(By.xpath("//label[contains(text(),'Location ?')]")).click();
		driver.findElement(By.xpath("//label[contains(text(),'Bangalore')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@ng-model='ctrl.googlePlacesObject']")).sendKeys("rajajinagar");
		
		Robot r= new Robot();
		r.keyPress(KeyEvent.VK_KP_DOWN);
		Thread.sleep(600);
		r.keyRelease(KeyEvent.VK_KP_DOWN);
		
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(600);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
	}
	
}
