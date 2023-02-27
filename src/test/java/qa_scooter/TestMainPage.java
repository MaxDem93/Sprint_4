package qa_scooter;

import pages.MainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Parameterized.class)
public class TestMainPage  {
    WebDriver driver;

    private final String result;
    private final String accordionLocator;



    public TestMainPage(String result, String accordionLocator) {
        this.result = result;
        this.accordionLocator = accordionLocator;
    }

    @Parameterized.Parameters// добавили аннотацию
    public static Object[][] data() {
        return new Object[][]{
                { "Сутки — 400 рублей. Оплата курьеру — наличными или картой.", "//div[@id='accordion__heading-0']" },
                {"Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", "//div[@id='accordion__heading-1']"},
                {"Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", "//div[@id='accordion__heading-2']"},
                {"Только начиная с завтрашнего дня. Но скоро станем расторопнее.", "//div[@id='accordion__heading-3']", },
                {"Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", "//div[@id='accordion__heading-4']"},
                {"Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", "//div[@id='accordion__heading-5']"},
                {"Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", "//div[@id='accordion__heading-6']"},
                {"Да, обязательно. Всем самокатов! И Москве, и Московской области.", "//div[@id='accordion__heading-7']"},
        };
    }

    @Before
    public void startDriver () {
        //Драйвер
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        // Разернули окно
        driver.manage().window().maximize();
        // Переход на главную страницу
        driver.get("https://qa-scooter.praktikum-services.ru/");

        // создать объект класса главной страницы
        MainPage objMainPage = new MainPage(driver);
        // Закрытьокно про куки
        objMainPage.clickSignInButton();
    }

    @Test
    public void testMainPage()  throws InterruptedException {
        // создать объект класса главной страницы
        MainPage objMainPage = new MainPage(driver);
        // Скролл до Вопросы о важном
        objMainPage.scrollToMainQwestion();

        driver.findElement(By.xpath(accordionLocator)).click();
        Thread.sleep(500);
        //String zeroText = objMainPage.getOpenAnswerText();
        String answerText = objMainPage.getOpenAnswerText();
        Assert.assertEquals("Текст не совпал!",result, answerText );
    }
    // Закрыть браузер
    @After
    public void quit() {
        driver.quit();
    }
}

