package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class AccountNavigationPage {
    private final Page page;

    public AccountNavigationPage(Page page) {
        this.page = page;
    }

    private static final String ACCOUNT_BTN = "button[data-lid='hdr_signin']";

    public void navigateTo(AccountEntries accountEntry) {
        page.locator(ACCOUNT_BTN).click();
        page.locator(".account-menu")
                .getByText(accountEntry.getDisplayName(), new Locator.GetByTextOptions().setExact(true))
                .click();
    }
}
