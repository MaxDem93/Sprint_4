package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class FirstOrderPage {
    private final WebDriver driver;

    public FirstOrderPage(WebDriver driver) {

        this.driver = driver;
    }

    // Добавили поле *Имя
    public By firstNameField = By.xpath("//div/input[@placeholder='* Имя']");
    // Добавили поле *Фамилия
    public By secondNameField = By.xpath("//div/input[@placeholder='* Фамилия']");
    // Добавили поле *Куда привезти
    public By streetField = By.xpath("//div/input[@placeholder='* Адрес: куда привезти заказ']");
    // Добавили поле *Станция метро
    public By metroStationField = By.xpath("//div/input[@placeholder='* Станция метро']");
    // Добавили поле * Телефон: на него позвонит курьер
    public By phoneNumberField = By.xpath("//div/input[@placeholder='* Телефон: на него позвонит курьер']");
    //Добавили локатор кнопки Далее
    public By nextButton = By.xpath("//div/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");


    //  Добавили метод, который вносит Имя
    public void setFirstNameField(String firstName) {

        driver.findElement(firstNameField).sendKeys(firstName);
    }
    //  Добавили метод, который вносит Фамилию
    public void setSecondNameField(String secondName) {

        driver.findElement(secondNameField).sendKeys(secondName);
    }
    //  Добавили метод, который вносит Адрес
    public void setStreetField(String streetName) {

        driver.findElement(streetField).sendKeys(streetName);
    }
    //  Добавили метод, который вносит Метро
    public void setMetroStationField(String metroStation) {
        driver.findElement(metroStationField).sendKeys(metroStation, Keys.ARROW_DOWN, Keys.ENTER);
    }
    //  Добавили метод, который вносит номер телефона
    public void setPhoneNumberField(String phoneNumber) {

        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }
    //  Добавили метод, кликнуть по кнопке Далее
    public void setNextButton() {
        driver.findElement(nextButton).click();
    }
    // Создаем шаг Заполнение страницы 1
    public void fillFirstPage (String firstName, String secondName, String streetName, String metroStation, String phoneNumber) {
        setFirstNameField(firstName);
        setSecondNameField(secondName);
        setStreetField(streetName);
        setMetroStationField(metroStation);
        setPhoneNumberField(phoneNumber);
    }


}
