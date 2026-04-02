import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class FirstTest extends Runner{
    @Test
    public void firstTest() {
        page.navigate("https://www.bestbuy.com/?intl=nosplash");
        //store the locator definition
        Locator locator =  page.locator("//li//a[text()=\"Deal of the Day\"]");
        Locator menuItems = page.locator(".bottom-nav-left li a");
        for(int i =0; i < menuItems.count(); i++)
            System.out.println(menuItems.nth(i).textContent());
//            System.out.println(menuItems.allTextContents());
            //pass a filter to identify a certain element in the list
        page.locator("ul.bottom-nav-left li a", new Page.LocatorOptions().setHasText("Deal of the Day")).click();

        System.out.println();
    }
}
