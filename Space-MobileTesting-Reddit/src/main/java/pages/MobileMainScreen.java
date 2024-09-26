package pages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class MobileMainScreen {
    AndroidDriver driver;

    public MobileMainScreen(AndroidDriver driver) {
        this.driver = driver;
    }

    public void openRedditApp() {
        WebElement redditApp = driver.findElement(By.id("Reddit"));
        try {
            redditApp.click();
            System.out.println("Reddit app is on main screen, opening...");
        } catch (Exception e) {
            System.out.println("Reddit app isn't on main screen, search in app drawer and open...");
            swipeUp();
            redditApp.click();
        }
    }

    public void swipeUp() {
        try {
            Dimension size = driver.manage().window().getSize();
            int startX = size.width / 2;
            int startY = (int) (size.height * 0.9);
            int endY = (int) (size.height * 0.2);

            System.out.println("Swiping up from (" + startX + ", " + startY + ") to (" + startX + ", " + endY + ")");
            new TouchAction<>(driver)
                    .press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                    .moveTo(PointOption.point(startX, endY))
                    .release()
                    .perform();

            System.out.println("Swipe completed successfully");
        } catch (Exception e) {
            System.err.println("Error during swipe operation: " + e.getMessage());
        }
    }
}
