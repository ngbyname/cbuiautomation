import com.code.bull.commonutils.applicationutils.contants.ApplicationConstant;
import com.code.bull.driver.Driver;
import org.testng.annotations.Test;


public class LoginPageTest extends Driver {

    private static final String username = constants.getValue(ApplicationConstant.USER_NAME);
    private static final String pass = constants.getValue(ApplicationConstant.USER_PASS);

    @Test
    public void loginPortalTest() throws InterruptedException {
        pages.getLoginPage().enterUserName(username);
        pages.getLoginPage().enterUserPass(pass);
    }
}
