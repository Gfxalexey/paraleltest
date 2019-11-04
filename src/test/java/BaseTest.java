import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public AppiumDriver driver;

    public static ThreadLocal<AppiumDriver> tdriver = new ThreadLocal<AppiumDriver>();
        @Parameters({"device", "appiumServer","systemPort"})
        @BeforeTest (alwaysRun = true)

    public AppiumDriver setup(String device, String appiumServer, String systemPort) throws MalformedURLException {
            try {
        DesiredCapabilities cap = new DesiredCapabilities();
//        cap.setCapability(AutomationName.ANDROID_UIAUTOMATOR2,"uiautomator");
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT,systemPort);
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
        cap.setCapability(MobileCapabilityType.UDID, device);
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
        cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.ideomobile.discount");
        cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.discount.ui.DiscountSplashActivity");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
//        cap.setCapability(MobileCapabilityType.VERSION, 9);
        URL url = new URL(appiumServer);
        driver = new AppiumDriver<MobileElement>(url, cap);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            Assert.assertNotNull(driver);
            } catch (Exception exp) {
                System.out.println("Cause is  " + exp.getCause());
                System.out.println("Massage is  " + exp.getMessage());
                exp.printStackTrace();
            }
        tdriver.set(driver);
        return getDriver();
    }
    public static synchronized AppiumDriver getDriver() {
        return tdriver.get();
    }

@AfterMethod
    public void afterMethod() {
        System.out.println("afterMethod(): quit driver");
        try {
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }
