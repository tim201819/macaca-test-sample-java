package macaca.client;
import com.alibaba.fastjson.JSONObject;
import macaca.client.commands.Element;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.containsString;

// API doc https://macacajs.github.io/wd.java/

public class Train_001 {

    MacacaClient driver = new MacacaClient();

    @Before public void setUp() throws Exception {

		/*
           Desired Capabilities are used to configure webdriver when initiating the session.
           Document URL: https://macacajs.github.io/desired-caps.html
         */
        JSONObject porps = new JSONObject();
        porps.put("browserName", "electron"); // electron
        porps.put("platformName", "desktop");
        JSONObject desiredCapabilities = new JSONObject();
        desiredCapabilities.put("desiredCapabilities", porps);
        //desiredCapabilities.put("host", "127.0.0.1"); // custom remote host
        //desiredCapabilities.put("port", 3456);        // custom remote port
        driver.initDriver(desiredCapabilities).setWindowSize(1280, 800)
                .get("http://www.ly.com/huochepiao/");
    }

    @Test public void test_case_1() throws Exception {
        
        driver.elementById("txtArriveCity").sendKeys("…œ∫£");
        driver.sleep(3000);
        driver.elementById("txtLeaveCity").sendKeys("À’÷›");
        driver.sleep(1000);
        
        driver.elementById("trainSearchSubmit").click();
        
        String html = driver.source();
        Assert.assertThat(html, containsString("<html>"));

        driver.elementByXPath("//*[@id=\"kw\"]").sendKeys(" elementByXPath");
        driver.elementById("su").click();
        driver.takeScreenshot();
        
    }



  

    @After public void tearDown() throws Exception {
        driver.quit();
    }
}
