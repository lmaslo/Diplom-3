package model;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class MainPage {
    //locators
    private SelenideElement buttonAuthInAccount = $x(".//button[text()='Войти в аккаунт']");
    private SelenideElement buttonPersonalAccount = $x(".//p[text()='Личный Кабинет']");
    private SelenideElement headingForm = $x(".//h2[text()='Вход']");

    private SelenideElement labelBread = $x(".//span[text()='Булки']");
    private SelenideElement labelSouse = $x(".//span[text()='Соусы']");
    private SelenideElement labelFilling = $x(".//span[text()='Начинки']");
    private SelenideElement blockIngredients = $(".BurgerIngredients_ingredients__menuContainer__Xu3Mo");



    //actions
    public MainPage openPage() {
        step("Открываем главную страницу  stellar burgers", () -> {
            open("https://stellarburgers.nomoreparties.site");
        });
        return this;
    }

    public MainPage buttonAuthInAccountClick() {
        step("Нажать на кнопку Войти", () -> {
            buttonAuthInAccount.click();
        });
        return this;
    }

    public MainPage buttonPersonalAccountClick() {
        step("Нажать на кнопку Личный кабинет", () -> {
            buttonPersonalAccount.click();
        });
        return this;
    }

    public MainPage checkUserLogOut() {
        step("Проврека, чо после перехода по лейбу Личный кабинет на старинице есть текст Вход", () -> {
            buttonPersonalAccountClick();
            headingForm.shouldHave(text("Вход"));
        });
        return this;
    }


    public MainPage labelBreadClick() {
        step("Нажать на Булки", () -> {
            labelBread.click();
        });
        return this;
    }

    public MainPage labelSouseClick() {
        step("Нажать на Соусы", () -> {
            labelSouse.click();
        });
        return this;
    }

    public MainPage labelFillingClick() {
        step("Нажать на Начинки", () -> {
            labelFilling.click();
        });
        return this;
    }

    public MainPage checkBlockIngredients(String nameIngredient) {
        step("Нажать на Булки", () -> {
            blockIngredients.shouldHave(text(nameIngredient));
        });
        return this;
    }
}
