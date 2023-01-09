package test;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import model.AuthPage;
import model.RegisterPage;
import org.junit.After;
import org.junit.Test;
import utils.RandomString;

public class RegisterTests {

    private static final String EXPECTED_MESSAGE_INCORRECT_PASSWORD = "Некорректный пароль";

    RegisterPage registerPage = new RegisterPage();
    AuthPage authPage = new AuthPage();
    RandomString generate = new RandomString();

    String name = generate.getRandomString(5);
    String email = generate.getRandomEmail();
    String password = generate.getRandomString(6);

    String shortPassword = generate.getRandomString(5);

    @After
    public void clearBrowser() {
        Selenide.clearBrowserLocalStorage();
    }

    @Test
    @DisplayName("Регистрация позитивный тест")
    @Description("Регистрация, проверка что после регистрации пользователь успешно авторизовывается")
    public void checkRegister() {
        registerPage.openPage();
        registerPage.register(name, email, password);
        authPage.openPage()
                .auth(email, password)
                .checkAuthSuccess(name, email, password);

        authPage.logOut();
    }

    @Test
    @DisplayName("Регистрация с некорректным паролем")
    @Description("Регистрация с некорректным паролем (меньше минимально длинны). Проверка, что возвращается ошибка и пользователь остается на странице регистрации")
    public void checkRegisterShortPassword() {
        registerPage.openPage();
        registerPage.register(name, email, shortPassword);

        registerPage.checkTextError(EXPECTED_MESSAGE_INCORRECT_PASSWORD)
                .checkPage();
    }


}
