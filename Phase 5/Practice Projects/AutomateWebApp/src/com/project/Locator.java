package com.project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class Locator {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","E:\\chromedriver.exe");
	    
		WebDriver driver=new ChromeDriver();
	    
			RegistrationFlow(driver);
		   LoginFlow(driver);
		
	}

	/**
	 * @param driver
	 */
	public static void RegistrationFlow(WebDriver driver) {
		driver.get("https://phptravels.net/signup");
		driver.findElement(By.name("first_name")).sendKeys("Ruskshanth");
		driver.findElement(By.name("last_name")).sendKeys("Singh");
		driver.findElement(By.name("phone")).sendKeys("9876543210");
		driver.findElement(By.name("email")).sendKeys("rukshanth@gmail.com");
	    driver.findElement(By.name("password")).sendKeys("123456789"); 	
	  	driver.findElement(By.cssSelector("button[type='submit']")).click();
	}
	public static void LoginFlow(WebDriver driver) {
		driver.get("http://www.phptravels.net/login");
	    driver.findElement(By.name("email")).sendKeys("sri@gmail.com");
	    driver.findElement(By.name("password")).sendKeys("123456789"); 	
	driver.findElement(By.cssSelector("button[type='submit']")).click();
	}

}
