package com.project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;



public class Locator {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","E:\\\\chromedriver.exe");
	    
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
			//RegistrationFlow(driver);
		   //LoginFlow(driver);
		   incorrectPasswordFlow(driver);
		   //getWalletBalance(driver);
	}

	public static void LoginFlow(WebDriver driver) {
		driver.get("http://www.phptravels.net/login");
	    driver.findElement(By.name("email")).sendKeys("rukshanth@gmail.com");
	    driver.findElement(By.name("password")).sendKeys("123456789"); 	
	driver.findElement(By.cssSelector("button[type='submit']")).click();
	}
	public static void incorrectPasswordFlow(WebDriver driver) throws InterruptedException {
		String expectedErrorMessage ="Wrong credentials. try again!";
		driver.get("http://www.phptravels.net/login");
	    driver.findElement(By.name("email")).sendKeys("manav@gmail.com");
	   driver.findElement(By.name("password")).sendKeys("demo"); 	
	driver.findElement(By.cssSelector("button[type='submit']")).click();
	Thread.sleep(500);
		String wrongCredentialsText =driver.findElement(By.className("alert-danger")).getText();
		System.out.println("wrongCredentialsText");
		Assert.assertEquals(wrongCredentialsText,expectedErrorMessage);

	}
	
	public static void getWalletBalance(WebDriver driver) throws InterruptedException {
		Thread.sleep(500);
		String walletText = ((WebElement) driver.findElement(By.xpath("//div[contains(@class,'user_wallet')]/div/div/div[2]/h4"))).getText();
		String walletAmount =walletText.trim();
		System.out.println("Wallet Amount: "+walletAmount);
		Assert.assertEquals(walletAmount, "0");
		
	
	}
//	public static void RegistrationFlow(WebDriver driver) {
//		driver.get("https://phptravels.net/signup");
//		driver.findElement(By.name("first_name")).sendKeys("Ruskshanth");
//		driver.findElement(By.name("last_name")).sendKeys("Singh");
//		driver.findElement(By.name("phone")).sendKeys("9876543210");
//		driver.findElement(By.name("email")).sendKeys("rukshanth@gmail.com");
//	    driver.findElement(By.name("password")).sendKeys("123456789"); 	
//	  	driver.findElement(By.cssSelector("button[type='submit']")).click();
//	}

}
