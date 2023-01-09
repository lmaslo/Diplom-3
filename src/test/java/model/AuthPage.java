package model;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class AuthPage {

    MainPage mainPage = new MainPage();
    MyProfilePage myProfilePage = new MyProfilePage();

    //locators
    private SelenideElement inputEmail = $x("//input[@name='name']");
    private SelenideElement inputPassword = $x("//input[@name='Пароль']");
    private SelenideElement buttonAuth = $x(".//button[text()='Войти']");


    //actions
    public AuthPage openPage() {
        step("Открываем страницу авторизации stellar burgers", () -> {
            open("https://stellarburgers.nomoreparties.site/login");
        });
        return this;
    }

    public AuthPage buttonAuthClick() {
        step("Нажать на кнопку Войти", () -> {
            buttonAuth.click();
        });
        return this;
    }

    public AuthPage inputEmail(String email) {
        step("Заполнить поле Email", () -> {
            inputEmail.setValue(email);
        });
        return this;
    }

    public AuthPage inputPassword(String password) {
        step("Заполнить поле Пароль", () -> {
            inputPassword.setValue(password);
        });
        return this;
    }


    public AuthPage auth(String email, String password) {
        step("авторизация, заполнение данных, клик по кнопке Войти", () -> {
            inputEmail(email);
            inputPassword(password);
            buttonAuthClick();
        });
        return this;
    }

    public AuthPage checkAuthSuccess(String name, String email, String password) {
        step("Проверка успешной авторизации", () -> {
            mainPage.buttonPersonalAccountClick();
            myProfilePage.checkName(name)
                    .checkEmail(email);
        });
        return this;
    }

    public AuthPage logOut() {
        step("Выход из аккаунта", () -> {
            myProfilePage.buttonLogOutClick();
        });
        return this;
    }


}
