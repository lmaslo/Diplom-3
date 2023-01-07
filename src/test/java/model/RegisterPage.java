package model;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class RegisterPage {

    //locators
    private SelenideElement inputName = $x("//fieldset[1]//input");
    private SelenideElement inputEmail = $x("//fieldset[2]//input");
    private SelenideElement inputPassword = $("[type=password]");
    private SelenideElement buttonRegister = $x(".//button[text()='Зарегистрироваться']");


    //actions
    public RegisterPage openPage() {
        step("Открываем страницу регистрации stellar burgers", () -> {
            open("https://stellarburgers.nomoreparties.site/register");
        });
        return this;
    }


    public RegisterPage buttonRegisterClick() {
        step("Нажать на кнопку регистрация", () -> {
            buttonRegister.click();
        });
        return this;
    }

    public RegisterPage inputName(String name) {
        step("Заполнить поле Имя", () -> {
            inputName.setValue(name);
        });
        return this;
    }

    public RegisterPage inputEmail(String email) {
        step("Заполнить поле Email", () -> {
            inputEmail.setValue(email);
        });
        return this;
    }

    public RegisterPage inputPassword(String password) {
        step("Заполнить поле Пароль", () -> {
            inputPassword.setValue(password);
        });
        return this;
    }



}
