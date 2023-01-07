package test;

import model.RegisterPage;
import org.junit.Test;

public class RegisterTests {
    RegisterPage registerPage=new RegisterPage();

    String name ="Lena";
    //добавить описние для отчетов алюра
    //добавить генерацию тестовый данных
    //удалять новый аккаунт

    @Test
    public void checkRegister() {
        registerPage.openPage()
                .inputName(name)
                .inputEmail("lena@yan.ru")
                .inputPassword("password")
                .buttonRegisterClick();

        //авторизация
        //проверка заголовка Личный кабинет
        //удаление пользователя
    }

    //тест для некорректных паролей
/*Ошибку для некорректного пароля. Минимальный пароль — шесть символов.*/


}
