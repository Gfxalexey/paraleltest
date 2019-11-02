import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class paraleltest1 extends BaseTest{
//    public AppiumDriver<MobileElement> driver;
//    @Parameters({"device","appiumServer"})
//    @BeforeClass
//    public void setup(String device,String appiumServer) throws MalformedURLException {
//        DesiredCapabilities cap = new DesiredCapabilities();
//        cap.setCapability(MobileCapabilityType.DEVICE_NAME,device);
//        cap.setCapability(MobileCapabilityType.UDID,device);
//        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
//        cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.ideomobile.discount");
//        cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.discount.ui.DiscountSplashActivity");
//        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
//        cap.setCapability(MobileCapabilityType.VERSION,9);
//        URL url = new URL(appiumServer);
//        driver = new AppiumDriver<MobileElement>(url,cap);
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//    }

@Test
public void login() throws InterruptedException {
    LoginPage loginPage = new LoginPage(driver);
    loginPage.EnterButton.click();
    Thread.sleep(1000);
    loginPage.loginsucces("320555683","1q1q1q","1q1q1q");

}
    @AfterClass
    public void teardown(){
        driver.closeApp();
    }
}