package org.example;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

/**
 * Unit test for flipkart.
 */
@Slf4j
@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AppTest {

    //private ChromeDriver driver;
    //private FirefoxDriver driver;
    private EdgeDriver driver;

    /**
     * Initialize a driver.
     */
    @BeforeAll
    public void setup() {
        //System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
        //System.setProperty("webdriver.gecko.driver", "src/test/resources/driver/geckodriver.exe");
        System.setProperty("webdriver.edge.driver", "src/test/resources/driver/msedgedriver.exe");
        
        //driver = new FirefoxDriver();
       //driver = new ChromeDriver();
        driver = new EdgeDriver();
    }

    /**
     * Test load time of the website
     */
    @Test
    @Order(1)
    public void shouldOpenFlipkart() {
        long start = System.currentTimeMillis();
        driver.get("https://www.flipkart.com/");
        long finish = System.currentTimeMillis();
        long totalTime = (finish - start) / 1000;
        log.info("It took {} seconds to load the page", totalTime);
    }


    /**
     * Search iphone in flipkart search box
     */
    @Test
    @Order(2)
    public void shouldSearchIphone13() {
        driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("iphone 13");
        WebElement searchButton = driver.findElement(By.className("L0Z3Pu"));
        searchButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver -> driver.findElement(By.className("_2kHMtA")));
        List<WebElement> searchResults = driver.findElements(By.className("_2kHMtA"));
        log.info("Found {} results for iphone 13", searchResults.size());
        Assertions.assertEquals(24, searchResults.size());
    }

    /**
     * Check if search images are loaded.
     */
    @Test
    @Order(3)
    public void shouldCheckIfIphone13ImagesAreLoaded() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        List<WebElement> searchResults = driver.findElements(By.className("_2kHMtA"));
        Stream<WebElement> images = searchResults.stream().map(parent -> parent.findElement(By.xpath("//img[@class='_396cs4 _3exPp9']")));
        boolean unloadedImageExist = images
                .map(image -> (Boolean) ((JavascriptExecutor) driver)
                        .executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", image))
                .anyMatch(imageLoaded -> Boolean.FALSE == imageLoaded);
        if (unloadedImageExist) {
            Assertions.fail("Search images did not load");
        }
        log.info("All search result images are loaded");
    }


    /**
     * Scroll down to bottom.
     */
    @Test
    @Order(4)
    public void shouldCheckIfPageHasScrollAndScrollToTheBottom() {
        JavascriptExecutor j = (JavascriptExecutor) driver;
        Long start = (Long) j.executeScript("return window.pageYOffset;");
        log.info("Scroll position after launch: {}", start);
        // identify element
        WebElement pageEnd = driver.findElement(By.className("_2MImiq"));
        // Javascript executor to scroll to the element
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", pageEnd);
        // current scroll position with Javascript Executor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Double end = (Double) js.executeScript("return window.pageYOffset;");
        log.info("Scroll position after scrolling upto an element: {}", end);
    }
    
    /**
     * Navigate to the next page.
     */
    @Test
    @Order(5)
    public void shouldCheckIfNavigateToTheNextPage() {
    	//driver.findElement(By.xpath("//a[contains(.,'Next')]")).click();
    	
    }
    
    /**
     * Quit the driver.
     */
    @AfterAll
    public void tearDown() {
        //driver.quit();
    }
}
