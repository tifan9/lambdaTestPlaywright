import org.junit.jupiter.api.Test;
import pages.AccountEntries;
public class SignupTest extends Runner{
    @Test
    public void signupTest(){
        page.navigate(getProperty("url"));
        accountNavigationPage.navigateTo(AccountEntries.CREATE_ACCOUNT);
        createAccountPage.createAccount();
        System.out.println();
    }
}
