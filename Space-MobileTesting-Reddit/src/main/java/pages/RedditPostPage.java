package pages;

import common.CommonMethods;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RedditPostPage {
    AndroidDriver driver;
    CommonMethods commonMethods;

    public RedditPostPage(AndroidDriver driver){
        this.driver = driver;
        commonMethods = new CommonMethods(driver);
    }

    public RedditPostPage printUserName(){
        WebElement username = driver.findElement(By.id("com.reddit.frontpage:id/bottom_row_metadata_before_indicators"));
        System.out.println("Username " + username.getText());
        return this;
    }

    public RedditPostPage printWhenPostWasPublic(){
        WebElement time = driver.findElement(By.id("com.reddit.frontpage:id/bottom_row_metadata_after_indicators"));
        System.out.println("Post was published: " + commonMethods.parseDate(time.getText()));
        return this;
    }

    public RedditPostPage printCommentAmount(){
        WebElement commentAmount = driver.findElement(By.id("comments_count"));
        System.out.println("Post has " + commentAmount.getAttribute("contentDescription") + "comments");
        return this;
    }
}
