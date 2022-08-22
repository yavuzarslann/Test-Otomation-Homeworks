package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Data;
import org.openqa.selenium.support.PageFactory;
import testScenarios.ContactManager;

@Data
public class HomePage {

    public HomePage(){
        PageFactory.initElements(new AppiumFieldDecorator(ContactManager.Driver), this);

    }
    @AndroidFindBy(id = "addContactButton")
    private MobileElement addContactBtn;
}
