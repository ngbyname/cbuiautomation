import com.code.bull.commonutils.applicationutils.contants.ApplicationConstant;
import com.code.bull.driver.Driver;
import org.testng.annotations.Test;


public class LoginPageTest extends Driver {

    private static final String username = constants.getValue(ApplicationConstant.USER_NAME);
    private static final String pass = constants.getValue(ApplicationConstant.USER_PASS);
    private static final String invalidPass = constants.getValue(ApplicationConstant.USER_INVALID_PASS);

    @Test(priority = 1, description = "TO verify login into portal by entering correctUsername and invalid pass")
    public void loginWithInvalidPass() throws InterruptedException {
        String url = pages.getLoginPage().getUrl();
        assertCheck.append(actions.assertEqualsBoolean(url.contains("/login"), true, "Login url Matched", "Login url NOT Matched"));
        pages.getLoginPage().enterUserName(username);
        pages.getLoginPage().enterUserPass(invalidPass);
        actions.assertAllFoundFailedAssert(assertCheck);
    }

    @Test(priority = 2, description = "To verify login into portal by entering valid username and password")
    public void loginPortalTest() throws InterruptedException {
        String url = pages.getLoginPage().getUrl();
        assertCheck.append(actions.assertEqualsBoolean(url.contains("/login"), true, "Login url Matched", "Login url NOT Matched"));
        pages.getLoginPage().enterUserName(username);
        pages.getLoginPage().enterUserPass(pass);
        pages.getLoginPage().clickLoginBtn();
        String url1 = pages.getLoginPage().getUrl();
        assertCheck.append(actions.assertEqualsBoolean(url1.contains("/dashboard"), true, "After Login Dashboard url Matched", "After Login Dashboard url NOT Matched"));
        actions.assertAllFoundFailedAssert(assertCheck);
    }


}
