package FirstAppiumTest;

import com.etsy.utils.ConfigurationReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class TestOne {

    public AppiumDriver driver;
    @Test
    public void test1() throws  Exception{

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName","Pixel_2_API_24");
        desiredCapabilities.setCapability("platform","Android");
        desiredCapabilities.setCapability("platformVersion","7.0");
        desiredCapabilities.setCapability("app", ConfigurationReader.getProperty("android.app.path"));
      //  desiredCapabilities.setCapability("testobject_api_key","BE48AE715EB14E77AE15A5FBD232FEF3");

        try {
            driver= new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),desiredCapabilities);
        }catch (Exception e){
            System.out.println("yov");
        }
        driver.findElement(By.xpath("//*[@text='Search']")).click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId("Clothing Button")));
        driver.findElementByAccessibilityId("Clothing Button").click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.xpath("//*[@text='All']")));
        driver.findElement(By.xpath("//*[@text='All']")).click();


       // if(driver.findElements(MobileBy.id("com.etsy.android:id/tooltip_background")).size()>0){
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.etsy.android:id/tooltip_x")));
            driver.findElement(MobileBy.id("com.etsy.android:id/tooltip_x")).click();
        //}
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.etsy.android:id/search_src_text")));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(MobileBy.id("com.etsy.android:id/search_src_text")));

        WebElement inputBox = driver.findElement(MobileBy.id("com.etsy.android:id/search_src_text"));
        inputBox.click();
        inputBox.sendKeys("wooden spoon");
        wait.until(ExpectedConditions.textToBe(MobileBy.id("com.etsy.android:id/search_src_text"),"wooden spoon"));
        driver.getKeyboard().pressKey(Keys.ENTER);
        //wait for first search result
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.etsy.android:id/listing_image")));
        WebElement firstResult = driver.findElement(MobileBy.id("com.etsy.android:id/listing_image"));
        wait.until(ExpectedConditions.visibilityOf(firstResult));

        TouchAction action = new TouchAction(driver);
        action.tap(new TapOptions().withElement(new ElementOption().withElement(firstResult))).perform();





    }


    @Test
    public void test2() throws  Exception{

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName","Samsung Galaxy S6");
        desiredCapabilities.setCapability("platform","Android");
        desiredCapabilities.setCapability("platformVersion","7.0");
        desiredCapabilities.setCapability("app",ConfigurationReader.getProperty("android.app.path"));
        desiredCapabilities.setCapability("adbExectTimeout","2000");
        desiredCapabilities.setCapability("testobject_api_key","BE48AE715EB14E77AE15A5FBD232FEF3");

        try {
            driver= new AndroidDriver(new URL("https://us1-manual.app.testobject.com/wd/hub"),desiredCapabilities);
        }catch (Exception e){
            System.out.println("yov");
        }
        driver.findElement(By.xpath("//*[@text='Search']")).click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.AccessibilityId("Clothing Button")));
        driver.findElementByAccessibilityId("Clothing Button").click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.xpath("//*[@text='All']")));
        driver.findElement(By.xpath("//*[@text='All']")).click();


        // if(driver.findElements(MobileBy.id("com.etsy.android:id/tooltip_background")).size()>0){
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.etsy.android:id/tooltip_x")));
        driver.findElement(MobileBy.id("com.etsy.android:id/tooltip_x")).click();
        //}
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.etsy.android:id/search_src_text")));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(MobileBy.id("com.etsy.android:id/search_src_text")));

        WebElement inputBox = driver.findElement(MobileBy.id("com.etsy.android:id/search_src_text"));
        inputBox.click();
        inputBox.sendKeys("wooden spoon");
        wait.until(ExpectedConditions.textToBe(MobileBy.id("com.etsy.android:id/search_src_text"),"wooden spoon"));
        driver.getKeyboard().pressKey(Keys.ENTER);
        //wait for first search result
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.etsy.android:id/listing_image")));
        WebElement firstResult = driver.findElement(MobileBy.id("com.etsy.android:id/listing_image"));
        wait.until(ExpectedConditions.visibilityOf(firstResult));

        TouchAction action = new TouchAction(driver);
        action.tap(new TapOptions().withElement(new ElementOption().withElement(firstResult))).perform();





    }
}
