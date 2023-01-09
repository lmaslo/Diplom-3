package model;

import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class MyProfilePage {

    //locators
    private SelenideElement labelName = $x("//li[@class='Profile_profileListItem__2th0t mb-6'][1]//input");
    private SelenideElement labelLogin = $x("//li[@class='Profile_profileListItem__2th0t mb-6'][2]//input");

    private SelenideElement buttonLogOut = $x("//li[@class='Account_listItem__35dAP'][3]//button");


    //actions
    public MyProfilePage openPage() {
        step("Открываем страницу профиля", () -> {
            open("https://stellarburgers.nomoreparties.site/account/profile");
        });
        return this;
    }

    public MyProfilePage buttonLogOutClick() {
        step("Нажать на кнопку Выйти", () -> {
            buttonLogOut.click();
        });
        return this;
    }

    public String getNameProfile() {
        return labelName.getValue();
    }

    public String getEmailProfile() {
        return labelLogin.getValue();
    }

    public MyProfilePage checkName(String name) {
        step("Проверка имени пользователя", () -> {
            Assert.assertEquals(name.toLowerCase(), getNameProfile().toLowerCase());
        });
        return this;
    }

    public MyProfilePage checkEmail(String email) {
        step("Проверка имени пользователя", () -> {
            Assert.assertEquals(email.toLowerCase(), getEmailProfile().toLowerCase());
        });
        return this;
    }

}
