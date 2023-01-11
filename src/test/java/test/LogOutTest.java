package test;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import model.AuthPage;
import model.MainPage;
import model.RegisterPage;
import org.junit.After;
import org.junit.Test;
import utils.RandomString;

public class LogOutTest {
    RegisterPage registerPage = new RegisterPage();
    AuthPage authPage = new AuthPage();
    MainPage mainPage = new MainPage();
    RandomString generate = new RandomString();

    String name = generate.getRandomString(5);
    String email = generate.getRandomEmail();
    String password = generate.getRandomString(6);


    @After
    public void clearBrowser() {
        Selenide.clearBrowserLocalStorage();
    }


    @Test
    @DisplayName("Выход из акаунта")
    @Description("Выход из аккаунта")
    public void checkLogOutSuccess() {
        registerPage.openPage()
                .register(name, email, password);
        authPage.openPage()
                .auth(email, password)
                .checkAuthSuccess(name, email, password)
                .logOut();

        mainPage.checkUserLogOut();
    }

}

