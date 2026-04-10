import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.AccountNavigationPage;
import pages.CreateAccountPage;
import services.EnvironmentReaderService;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Objects;

public class Runner {
    protected Page page;
    protected BrowserContext browserContext;
    protected Browser browser;
    protected static Playwright playwright;
    protected CreateAccountPage createAccountPage;
    protected AccountNavigationPage accountNavigationPage;

    @BeforeAll
    public static void init(){
        playwright = Playwright.create();
    }
    @BeforeEach
    public void setUp(){
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        // this works as incognito mode to avoid having cookies in the browser
        browserContext = browser.newContext(new Browser.NewContextOptions().setPermissions(Arrays.asList("geolocation")));
        browserContext.setDefaultTimeout(40000);
        page = browserContext.newPage();
        page.setDefaultTimeout(40000);
        accountNavigationPage = new AccountNavigationPage(page);
        createAccountPage = new CreateAccountPage(page);
    }
//    private void initPage(Object object, Page page){
//        Class<?> clazz = object.getClass().getSuperclass();
//        for(Field field : clazz.getDeclaredFields()){
//            if (field.isAnnotationPresent(PlaywrightPage.class)){
//                Class<?>[] type = {Page.class};
//                try{
//                    field.set(this, field.getType().getConstructor(type).newInstance(page));
//                }catch (IllegalAccessException | InstantiationException | NoSuchMethodException |
//                        InvocationTargetException e){
//                    System.out.println("Error initializing page object: " + field.getName());
//            }
//        }
//    }
//    }
    @AfterEach
    public void tearDown(){
        browserContext.close();
        browser.close();
    }

    protected String getProperty(String key){
        return EnvironmentReaderService.getProperty(key);
    }
}
