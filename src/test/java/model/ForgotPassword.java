package model;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class ForgotPassword {
    //locators
    private SelenideElement buttonAuth = $(byText("Войти"));


    //actions
    public ForgotPassword openPage() {
        step("Открываем страницу восстановления пароля", () -> {
            open("https://stellarburgers.nomoreparties.site/forgot-password");
        });
        return this;
    }

    public ForgotPassword buttonAuthClick() {
        step("Нажать на кнопку Войти", () -> {
            buttonAuth.click();
        });
        return this;
    }
}
