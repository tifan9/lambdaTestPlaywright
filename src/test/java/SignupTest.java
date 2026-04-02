import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.LocatorAssertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SignupTest extends Runner{
    @Test
    public void signupTest(){
        page.navigate("https://www.bestbuy.com/?intl=nosplash");
        page.locator("button[data-lid='hdr_signin']").click();
        page.locator("//button//span[text()='Create Account']").click();
        createAccountPage.createAccount();
        System.out.println();
    }
}
