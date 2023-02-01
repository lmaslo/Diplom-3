# Дипломный проект по автоматизации тестирования для Stellarburgers. 
<a target="_blank" href="https://stellarburgers.nomoreparties.site/">Веб сайт Stellarburgers</a>


## :memo: Содержание:

- [Реализованные проверки](#boom-Реализованные-проверки)
- [Технологии](#classical_building-Технологии)
- [Запуск из терминала](#electron-Запуск-тестов-из-терминала)
- [Allure отчет](#bar_chart-Allure-отчет)


## :boom: Реализованные проверки

#### Регистрация
- ✓ Успешная регистрация
- ✓ Ошибку для некорректного пароля
#### Вход 
- ✓ вход по кнопке «Войти в аккаунт» на главной,
- ✓ вход через кнопку «Личный кабинет»,
- ✓ вход через кнопку в форме регистрации,
- ✓ вход через кнопку в форме восстановления пароля.
#### Переходы по страницам 
- ✓ Переход по клику на «Личный кабинет».
- ✓ Переход из личного кабинета в конструктор 
- ✓ Переход по клику на «Конструктор» и на логотип Stellar Burgers.
- ✓ Переходы к разделам: «Булки», «Соусы», «Начинки».
#### Выход из аккаунта
- ✓ Проверь выход по кнопке «Выйти» в личном кабинете.

## :classical_building: Технологии
<p align="center">
<img width="6%" title="Idea" src="/image/logo/Idea.svg">
<img width="6%" title="Java" src="image/logo/Java.svg">
<img width="6%" title="Selenide" src="image/logo/Selenide.svg">
<img width="6%" title="Allure Report" src="image/logo/Allure.svg">
<img width="6%" title="Maven" src="image/logo/maven.png">
<img width="6%" title="JUnit4" src="image/logo/junit.png">
<img width="6%" title="GitHub" src="image/logo/GitHub.svg">
</p>


## :electron: Запуск тестов из терминала

```
mvn clean test
```

## :bar_chart: Allure-отчет
<img width="60%" title="Allure" src="image/logo/allure/allure1.PNG">
