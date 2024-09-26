package common;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class CommonMethods {
    AndroidDriver driver;
    TouchAction touchAction;

    public CommonMethods(AndroidDriver driver) {
        this.driver = driver;
        touchAction = new TouchAction(driver);
    }

    public WebElement selectPostWithMostUpVotes(List<WebElement> posts) {
        int maxScrolls = 5;
        int scrollAttempts = 0;

        WebElement mostUpVotedPost = null;
        int maxUpVotes = -1;
        int mostUpVotedIndex = -1;
        int processedPosts = 0;
        int scrollDownCount = 0;

        while (scrollAttempts < maxScrolls) {
            for (int i = processedPosts; i < posts.size() && processedPosts < 20; i++) {
                int upvoteCount = parseUpvoteCount(posts.get(i).getAttribute("contentDescription"));
                if (upvoteCount > maxUpVotes) {
                    maxUpVotes = upvoteCount;
                    mostUpVotedPost = posts.get(i);
                    mostUpVotedIndex = i;
                }
                processedPosts++;
            }
            if (processedPosts >= 20) {
                break;
            }

            scrollDown();
            scrollAttempts++;
            scrollDownCount++;
        }

        for (int i = 0; i < scrollDownCount; i++) {
            scrollUp();
        }

        return mostUpVotedPost;
    }

    private void scrollDown() {
        touchAction.press(PointOption.point(500, 1800))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(500, 400))
                .release()
                .perform();
    }

    private void scrollUp() {
        touchAction.press(PointOption.point(500, 400))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(500, 1800))
                .release()
                .perform();
    }

    private int parseUpvoteCount(String attributeText) {
        attributeText = attributeText.trim();

        String[] parts = attributeText.split(",");
        for (String part : parts) {
            part = part.trim();
            if (part.contains("upvotes")) {
                String[] upvoteParts = part.split(" ");
                for (int i = 0; i < upvoteParts.length; i++) {
                    if (upvoteParts[i].equals("upvotes")) {
                        try {
                            return Integer.parseInt(upvoteParts[i - 1]);
                        } catch (NumberFormatException e) {
                            return 0;
                        }
                    }
                }
            }
        }
        return 0;
    }

    public String parseDate(String text){
        text = text.trim();
        if (text.startsWith("•")) {
            text = text.substring(1).trim();
        }
        return text;
    }
}
