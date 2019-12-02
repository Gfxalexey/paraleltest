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
            cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
            cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
            cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
            cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
            cap.setCapability(MobileCapabilityType.UDID, device);
            cap.setCapability("xcodeOrgId", "com.discountalex.WebDriverAgentRunner");
            cap.setCapability("xcodeSigningId", "iPhone Developer");
            cap.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "ngsoft.il.co.discountbank.discountbank");
            cap.setCapability(IOSMobileCapabilityType.USE_NEW_WDA, "true");
            cap.setCapability(IOSMobileCapabilityType.WDA_LOCAL_PORT, systemPort);
            URL url = new URL(appiumServer);
            AppiumDriver driver = new AppiumDriver<>(url, cap);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
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
