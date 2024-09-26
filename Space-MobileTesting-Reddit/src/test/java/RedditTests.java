import org.junit.Before;
import org.junit.Test;
import pages.MobileMainScreen;
import pages.RedditHomePage;
import pages.RedditPostPage;
import pages.RedditSearchResultPage;

import java.net.MalformedURLException;

public class RedditTests extends BaseTest{
    MobileMainScreen mainScreen;
    RedditHomePage homePage;
    RedditSearchResultPage resultPage;
    RedditPostPage postPage;

    @Before
    public void setUpTest() throws MalformedURLException {
        setUp();

        mainScreen = new MobileMainScreen(driver);
        homePage = new RedditHomePage(driver);
        resultPage = new RedditSearchResultPage(driver);
        postPage = new RedditPostPage(driver);
    }

    @Test
    public void testRedditApp(){
        mainScreen.openRedditApp();
        homePage.clickSearchBar()
                .searchBanking();
        resultPage.clickSortButton()
                .selectHotRadioButton()
                .pickMostVotedPost();
        postPage.printUserName()
                .printWhenPostWasPublic()
                .printCommentAmount();
    }
}
