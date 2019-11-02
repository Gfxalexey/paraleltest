import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import static java.time.Duration.ofSeconds;

public class LoginPage {
    public LoginPage(AppiumDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver, ofSeconds(8)), this);
    }

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"כניסה\"]\n")
    public MobileElement EnterButton;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"תעודת זהות\"]/android.widget.LinearLayout/android.widget.EditText\n")
    public MobileElement typeID;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"סיסמה\"]/android.widget.LinearLayout/android.widget.EditText\n")
    public MobileElement typePAS;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"קוד מזהה\"]/android.widget.LinearLayout/android.widget.EditText\n")
    public MobileElement typeCODE;

    public LoginPage loginsucces(String id, String pass, String code) {
        typeID.sendKeys(id);
        typePAS.sendKeys(pass);
        typeCODE.sendKeys(code);
        EnterButton.click();
        return this;
    }

}
