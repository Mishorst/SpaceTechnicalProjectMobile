package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RedditHomePage {
    AndroidDriver driver;

    public RedditHomePage(AndroidDriver driver) {
        this.driver = driver;
    }

    public RedditHomePage clickSearchBar(){
        WebElement searchBar = driver.findElement(By.id("com.reddit.frontpage:id/feed_control_search_icon"));
        searchBar.click();
        return this;
    }

    public RedditHomePage searchBanking(){
        WebElement searchField = driver.findElement(By.id("com.reddit.frontpage:id/search"));
        WebElement searchText = driver.findElement(By.id("query_prompt_text"));
        searchField.sendKeys("Banking");
        searchText.click();
        return this;
    }
}
