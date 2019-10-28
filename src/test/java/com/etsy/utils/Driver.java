package com.etsy.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.swing.*;
import java.net.URL;

public class Driver {

    private static AppiumDriver driver;
    private  static DesiredCapabilities desiredCapabilities;
    private Driver(){

    }

    public static void setupDriver(){

        String platform = System.getProperty("platform");
        //
        if(platform==null){
            platform= ConfigurationReader.getProperty("platform");

        }
        platform = platform.toLowerCase();
        if (platform.equals("android")){

                DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities.setCapability("deviceName","Pixel_2_API_24");
                desiredCapabilities.setCapability("platform","Android");
                desiredCapabilities.setCapability("platformVersion","7.0");
                desiredCapabilities.setCapability("app",ConfigurationReader.getProperty("android.app.path"));
                desiredCapabilities.setCapability("adbExectTimeout","2000");

            try {
                driver= new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),desiredCapabilities);
            }catch (Exception e){
                System.out.println("yov");
            }
        }else if(platform.equals("android_sauce_labs")){
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
                e.printStackTrace();
            }

        }

    }

    public static AppiumDriver getDriver(){
        return driver;
    }
    public static void closeDriver(){
        if(driver != null){
            driver.quit();
            driver= null;
        }
        driver.quit();
    }
}
