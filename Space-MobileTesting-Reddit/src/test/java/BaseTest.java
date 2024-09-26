import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected AndroidDriver driver;

    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4 API 33");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Automation2");
        caps.setCapability("appPackage", "com.reddit.frontpage");
        caps.setCapability("appActivity", "com.reddit.frontpage.MainActivity");
        caps.setCapability(MobileCapabilityType.NO_RESET, true);


        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }

    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }
}
