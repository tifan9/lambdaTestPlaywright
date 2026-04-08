import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.LocatorAssertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SignupTest extends Runner{
    @Test
    public void signupTest(){
        page.navigate("https://www.bestbuy.com/?intl=nosplash");
        accountNavigationPage.navigateTo("Create Account");
        createAccountPage.createAccount();
        System.out.println();
    }
}
