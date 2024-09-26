package pages;

import common.CommonMethods;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RedditSearchResultPage {
    AndroidDriver driver;
    CommonMethods commonMethods;

    public RedditSearchResultPage(AndroidDriver driver){
        this.driver = driver;
        commonMethods = new CommonMethods(driver);
    }

    public RedditSearchResultPage clickSortButton(){
        WebElement sortButton = driver.findElement(By.xpath("//android.widget.TextView[@text='Relevance']"));
        sortButton.click();
        return this;
    }

    public RedditSearchResultPage selectHotRadioButton(){
        WebElement hotBtn = driver.findElement(By.xpath("//android.widget.RadioButton[@text='Hot']"));
        hotBtn.click();
        return this;
    }

//    find first 20 elements with resource-ids and click post with most upvotes
    public RedditSearchResultPage pickMostVotedPost(){
        List<WebElement> upvoteElements = driver.findElements(By.id("search_post_section"));
        commonMethods.selectPostWithMostUpVotes(upvoteElements).click();
        return this;
    }
}
