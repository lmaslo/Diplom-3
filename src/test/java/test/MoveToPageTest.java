package test;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import model.AuthPage;
import model.MainPage;
import model.MyProfilePage;
import model.RegisterPage;
import org.junit.After;
import org.junit.Test;
import utils.RandomString;

public class MoveToPageTest {

    MainPage mainPage = new MainPage();
    AuthPage authPage = new AuthPage();
    RandomString generate = new RandomString();
    RegisterPage registerPage = new RegisterPage();
    MyProfilePage myProfilePage = new MyProfilePage();


    String name = generate.getRandomString(5);
    String email = generate.getRandomEmail();
    String password = generate.getRandomString(6);

    @After
    public void clearBrowser() {
        Selenide.clearBrowserLocalStorage();
    }

    @Test
    @DisplayName("Переход по лейблу Личный кабинет без Авторизации")
    @Description("Переход по лейблу Личный кабинет без Авторизации, проверка что на странице появляется заголовок Вход")
    public void moveToPersonalAccountWithOutAuth() {
        mainPage.openPage()
                .buttonPersonalAccountClick();

        authPage.shouldBeTextLogin();
    }

    @Test
    @DisplayName("Переход по лейблу Личный кабинет  для авторизованного пользователя")
    @Description("Переход по лейблу Личный кабинет  для авторизованного пользователя, проверка что на странице появляется заголовок Профиль")
    public void moveToPersonalAccountWithAuth() {
        registerPage.openPage();
        registerPage.register(name, email, password);
        authPage.openPage()
                .auth(email, password)
                .checkAuthSuccess(name, email, password);

        mainPage.buttonPersonalAccountClick();

        myProfilePage.shouldBeTextProfile();

        myProfilePage.buttonLogOutClick();
    }

    @Test
    @DisplayName("Переход по лейблу Конструктор без Авторизации")
    @Description("Переход по лейблу Конструктор без Авторизации, проверка что на странице появляется заголовок Собери бургер")
    public void moveToConstructorFromAuthPage() {
        mainPage.openPage()
                .buttonPersonalAccountClick()
                .labelConstructorClick();
        mainPage.checkTextCollectToBurger();
    }

    @Test
    @DisplayName("Переход по stellar burger без Авторизации")
    @Description("Переход по logo stellar burger без Авторизации, проверка что на странице появляется заголовок Собери бургер")
    public void moveToStellarBurgersFromAuthPage() {
        mainPage.openPage()
                .buttonPersonalAccountClick()
                .logoStellarBurgersClick();
        mainPage.checkTextCollectToBurger();
    }

}
