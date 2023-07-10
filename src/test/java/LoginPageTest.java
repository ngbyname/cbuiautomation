import com.code.bull.commonutils.applicationutils.contants.ApplicationConstant;
import com.code.bull.driver.Driver;
import org.testng.annotations.Test;


public class LoginPageTest extends Driver {

    private static final String USER_NAME = constants.getValue(ApplicationConstant.USER_NAME);
    private static final String PASS = constants.getValue(ApplicationConstant.USER_PASS);
    private static final String INVALID_PASS = constants.getValue(ApplicationConstant.USER_INVALID_PASS);

    @Test(priority = 1, description = "To verify login into portal by entering correct Username and invalid pass")
    public void loginWithInvalidPass() throws InterruptedException {
        String url = pages.getLoginPage().getUrl();
        assertCheck.append(actions.assertEqualsBoolean(url.contains("/login"), true, "Login url Matched", "Login url NOT Matched"));
        pages.getLoginPage().enterUserName(USER_NAME);
        pages.getLoginPage().enterUserPass(INVALID_PASS);
        pages.getLoginPage().clickLoginBtn();
        assertCheck.append(actions.assertEqualsBoolean(pages.getLoginPage().isInvalidMsgVisible(), true, "Invalid msg is visible", "Invalid msg is NOT visible"));
        String invalidMsg = pages.getLoginPage().getInvalidMsg();
        assertCheck.append(actions.assertEqualsString(invalidMsg, "Invalid credentials", "Invalid msg Matched", "Invalid msg NOT Matched"));
        actions.assertAllFoundFailedAssert(assertCheck);
    }

    @Test(priority = 2, description = "To verify login into portal by entering valid username and password", alwaysRun = false)
    public void loginPortalTest() {
        String url = pages.getLoginPage().getUrl();
        assertCheck.append(actions.assertEqualsBoolean(url.contains("/login"), true, "Login url Matched", "Login url NOT Matched"));
        pages.getLoginPage().enterUserName(USER_NAME);
        pages.getLoginPage().enterUserPass(PASS);
        pages.getLoginPage().clickLoginBtn();
        String url1 = pages.getLoginPage().getUrl();
        assertCheck.append(actions.assertEqualsBoolean(url1.contains("/dashboard"), true, "After Login Dashboard url Matched", "After Login Dashboard url NOT Matched"));
        String headerText = pages.getDashboardPage().getHeaderText();
        assertCheck.append(actions.assertEqualsString(headerText, "Dashboard", "Dashboard Header text Matched", "Dashboard Header text NOT Matched" + headerText));
        actions.assertAllFoundFailedAssert(assertCheck);
    }

}
