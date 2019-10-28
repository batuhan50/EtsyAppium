package com.etsy.step_definitions;

import com.etsy.utils.Driver;
import org.junit.After;
import org.junit.Before;

import java.util.concurrent.TimeUnit;

public class Hook {


    @Before
    public void setUp(){
        Driver.setupDriver();
        Driver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @After
    public void tearDown(){
        Driver.closeDriver();
    }


}
