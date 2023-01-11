package test;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import model.MainPage;
import org.junit.Test;

public class ConstructorTest {

    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Переход к разделу Булки")
    @Description("Переход к разделу Булки")
    public void moveToBread() {
        mainPage.openPage()
                .labelSouseClick()
                .labelBreadClick()
                .checkBlockIngredients("Булки");
    }

    @Test
    @DisplayName("Переход к разделу Соусы")
    @Description("Переход к разделу Соусы")
    public void moveToSouse() {
        mainPage.openPage()
                .labelSouseClick()
                .checkBlockIngredients("Соусы");
    }

    @Test
    @DisplayName("Переход к разделу Начинки")
    @Description("Переход к разделу Начинки")
    public void moveToFilling() {
        mainPage.openPage()
                .labelFillingClick()
                .checkBlockIngredients("Начинки");
    }


}
