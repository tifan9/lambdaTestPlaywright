package pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.LocatorAssertions;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CreateAccountPage {
    private final Page createAccountPage;
    private static final String FIRST_NAME= "input#firstName";
    private static final String LAST_NAME= "input#lastName";
    private static final String EMAIL= "input#email";
    private static final String PASSWORD= "input#fld-p1";
    private static final String CONFIRM_PASSWORD= "input#reenterPassword";
    private static final String PASSWORD_VALIDATION = "span.c-input-error-message";
    private static final String PHONE= "input#phone";
    private static final String CHECK= "input#is-recovery-phone";
    public static final String SUBMIT_BUTTON = "button[type='submit']";
    public CreateAccountPage(Page page) {
        this.createAccountPage = page;
    }
    public void createAccount(){
        createAccountPage.locator(FIRST_NAME).fill("FirstName");
        createAccountPage.locator(LAST_NAME).fill("LastName");
        createAccountPage.locator(EMAIL).fill("example@example.com");
        createAccountPage.locator(PASSWORD).fill("Password13323@4231");
        createAccountPage.locator(CONFIRM_PASSWORD).fill("Password13323@4231");
        assertThat(createAccountPage
                .locator(PASSWORD_VALIDATION))
                .containsText("Your passwords match!",new LocatorAssertions
                        .ContainsTextOptions().setTimeout(3000));
        createAccountPage.locator(PHONE).fill("480930238942");
        createAccountPage.locator(CHECK).check();
        assertThat(createAccountPage.locator("button.cia-form__controls__submit")).isEnabled();
//        createAccountPage.locator(SUBMIT_BUTTON).click();
    }
}
