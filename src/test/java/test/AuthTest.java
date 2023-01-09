package test;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import model.AuthPage;
import model.ForgotPassword;
import model.MainPage;
import model.RegisterPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.RandomString;

public class AuthTest {

    RegisterPage registerPage = new RegisterPage();
    AuthPage authPage = new AuthPage();
    MainPage mainPage = new MainPage();
    ForgotPassword forgotPassword = new ForgotPassword();
    RandomString generate = new RandomString();

    String name = generate.getRandomString(5);
    String email = generate.getRandomEmail();
    String password = generate.getRandomString(6);

    @Before
    public void Register() {
        registerPage.openPage();
        registerPage.register(name, email, password);
    }

    @After
    public void clearBrowser() {
        authPage.logOut();
        Selenide.clearBrowserLocalStorage();
    }


    @Test
    @DisplayName("Авторизация позитивный тест через кнопку Войти в аккаунт")
    @Description("Авторизация позитивный тест через кнопку Войти в аккаунт на главной странице")
    public void checkAuthButtonAuthInAccount() {
        mainPage.openPage();
        mainPage.buttonAuthInAccountClick();

        authPage.auth(email, password)
                .checkAuthSuccess(name, email, password);

    }

    @Test
    @DisplayName("Авторизация позитивный тест через лейбл Личный кабинет")
    @Description("Авторизация позитивный тест через лейбл Личный кабинет")
    public void checkAuthLabelMyProfile() {
        mainPage.openPage();
        mainPage.buttonPersonalAccountClick();

        authPage.auth(email, password)
                .checkAuthSuccess(name, email, password);


    }

    @Test
    @DisplayName("Авторизация позитивный тест через кнопку на странице регистрация")
    @Description("Авторизация позитивный тест через кнопку на странице регистрация")
    public void checkAuthButtonRegisterPage() {
        registerPage.openPage()
                .buttonAuthClick();

        authPage.auth(email, password)
                .checkAuthSuccess(name, email, password);

    }

    @Test
    @DisplayName("Авторизация позитивный тест через кнопку в форме восстановления пароля")
    @Description("Авторизация позитивный тест через кнопку в форме восстановления пароля")
    public void checkAuthButtonForgotPasswordPage() {
        forgotPassword.openPage()
                .buttonAuthClick();

        authPage.auth(email, password)
                .checkAuthSuccess(name, email, password);

    }


}

