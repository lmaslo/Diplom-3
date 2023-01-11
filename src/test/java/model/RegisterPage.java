package model;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class RegisterPage {

    //locators
    private SelenideElement inputName = $x("//fieldset[1]//input");
    private SelenideElement inputEmail = $x("//fieldset[2]//input");
    private SelenideElement inputPassword = $x("//fieldset[3]//input");
    private SelenideElement buttonRegister = $x(".//button[text()='Зарегистрироваться']");
    private SelenideElement buttonAuth = $x(".//a[text()='Войти']");

    private SelenideElement errorPasswordText = $x("//fieldset[3]//p");


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

    public RegisterPage buttonAuthClick() {
        step("Нажать на кнопку войти", () -> {
            buttonAuth.click();
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

    public RegisterPage checkTextError(String error) {
        step("Проверка текста ошибки под полем пароль", () -> {
            errorPasswordText.shouldHave(text(error));
        });
        return this;
    }

    public RegisterPage checkPage() {
        step("Проверка, что после ошибки не произошла переадресация на другую страницу и кнопка регистрации активна", () -> {
            buttonRegister.should(Condition.visible);
        });
        return this;
    }


    public RegisterPage register(String name, String email, String password) {
        step("Ввод имени, пароля, email и нажать на кнопку Регистрация", () -> {
            inputName(name);
            inputEmail(email);
            inputPassword(password);
            buttonRegisterClick();
        });
        return this;
    }


}
