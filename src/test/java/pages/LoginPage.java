package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginPage {
    private AppiumDriver<MobileElement> appiumDriver;

    private By txt_username = By.id("quocviet.com.vn.qrrm:id/txt_login_username");
    private By txt_password = By.id("quocviet.com.vn.qrrm:id/txt_login_password");
    private By btn_login = By.id("quocviet.com.vn.qrrm:id/btn_login");
    private By tv_message_notify_description = By.id("quocviet.com.vn.qrrm:id/tv_message_notify_description");
    private By btn_message_notify_submit = By.id("quocviet.com.vn.qrrm:id/btn_message_notify_submit");
    public LoginPage(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;

    }
    // Sau khi thực hiện click Submit thì khởi tạo trang DashboardPage
    public void Login(String username, String password) throws Exception {

        enter_txt_username(username);
        enter_txt_password(password);
        clickLogin();
    }

    public void enter_txt_username(String txt_username_string) {
        MobileElement txt_username_element = appiumDriver.findElement(txt_username);
        if (txt_username_element.isDisplayed())
            txt_username_element.sendKeys(txt_username_string);
    }
    public void enter_txt_password(String txt_password_string) {
        MobileElement txt_password_element = appiumDriver.findElement(txt_password);
        if (txt_password_element.isDisplayed())
            txt_password_element.sendKeys(txt_password_string);
    }
    public void clickLogin(){
        MobileElement btn_login_element = appiumDriver.findElement(btn_login);
        if (btn_login_element.isDisplayed())
            btn_login_element.click();
    }
    public void  click_btn_message_notify_submit (){
        MobileElement btn_message_notify_submit_element = appiumDriver.findElement(btn_message_notify_submit);
        if (btn_message_notify_submit_element.isDisplayed())
            btn_message_notify_submit_element.click();
    }

    public String getErrorMessage() {
        String strErrorMsg = null;
        MobileElement errorMsg = appiumDriver.findElement(tv_message_notify_description);
        if (errorMsg.isDisplayed() && errorMsg.isEnabled())
            strErrorMsg = errorMsg.getText();
        return strErrorMsg;
    }
}
