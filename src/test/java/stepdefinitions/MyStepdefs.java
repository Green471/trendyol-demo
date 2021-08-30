package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import org.junit.Assert;
import org.junit.Before;

import org.openqa.selenium.Keys;



import org.openqa.selenium.interactions.Actions;

import pages.TrendyolHomepage;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class MyStepdefs {
    TrendyolHomepage page = new TrendyolHomepage();
    Driver driver;


    @Before
    public void implisitlywait() {
        Driver.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
    }

    Actions actions = new Actions(Driver.getDriver());
    Faker faker = new Faker();

    @Given("Kullanıcı {string} anasayfasına gider")
    public void kullanıcıAnasayfasınaGider(String url) {
        Driver.getDriver().get(ConfigurationReader.getPropery(url));
        Driver.getDriver().manage().window().maximize();

    }

    @Then("imleci einlogen dropdown üzrine getirir")
    public void imleciEinlogenDropdownÜzrineGetirir() {
        actions.moveToElement(page.einlogenIcon).perform();
    }

    @Then("einmelden dropdown'a tiklar")
    public void einmeldenDropdownATiklar() {
        page.einmelden.click();
    }

    @Then("Kullanici {string} yazisini ekranda görmeli")
    public void kullaniciYazisiniEkrandaGörmeli(String text) {

        Assert.assertEquals(text, page.willcommenText.getText());

    }

    @Then("email text box gecerli e-mail girer")
    public void emailTextBoxGecerliEMailGirer() {
        // page.email.sendKeys(ConfigurationReader.getPropery("gecerli_email"));
        page.email.sendKeys(faker.name().username() + ConfigurationReader.getPropery("gecerli_email"));
    }

    @Then("password text box ına geçerli password girilir")
    public void password_text_box_ına_geçerli_password_girilir() {
        page.password.sendKeys(ConfigurationReader.getPropery("gecerli_password"));
    }

    @Then("the user Männlich butonuna tiklar")
    public void the_user_männlich_butonuna_tiklar() {
        page.gender.click();
    }

    @Then("kullanici checkbox'a tiklar")
    public void kullanici_checkbox_a_tiklar() {
        if (!page.checkbox.isSelected()) {
            page.checkbox.click();
        } else
            System.out.println("Checkbox secili");
    }


    @Then("kullanici registration butonuna tiklar")
    public void kullaniciRegistrationButonunaTiklar() throws InterruptedException {
        page.registerButton.click();

       // Driver.getDriver().manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        Driver.getDriver().manage().timeouts().pageLoadTimeout(3,TimeUnit.SECONDS).implicitlyWait(3,TimeUnit.SECONDS);

    }

    @Then("kullanici {string} yazisini görmeli")
    public void kullaniciYazisiniGörmeli(String konto) {
        Boolean isEnable = page.textKonto.isEnabled();

        Boolean isDisplayed = page.textKonto.isDisplayed();
        if (isEnable) {
            System.out.println("is enabled");
        } else
            System.out.println("is not enabled");


        if (isDisplayed) {
            System.out.println("is Displayed");
        } else
            System.out.println("is not Displayed");



    }

    @Then("kullanici searcbox'a {string} aramasi yapar")
    public void kullaniciSearcboxAAramasiYapar(String arama) throws InterruptedException {
        page.searcbox.sendKeys(arama, Keys.ENTER);
        Driver.getDriver().manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
    }

    @Then("kullanici begendigi ürünleri fav'a ekler")
    public void kullaniciBegendigiÜrünleriFavAEkler() throws InterruptedException {
     page.fav.click();




    }


    @Then("Kullanici yas araligini secer")
    public void kullaniciYasAraliginiSecer() throws InterruptedException {
        System.out.println("yas araligi secildi");
    }

    @Then("kullanici inden waren korb butonuna tiklar")
    public void kullaniciIndenWarenKorbButonunaTiklar() throws InterruptedException {
        Set<String> windowHandles = Driver.getDriver().getWindowHandles();
        List<String> ls=new ArrayList<>();
        ls.addAll(windowHandles);
        Driver.getDriver().switchTo().window(ls.get(1));
        System.out.println(ls.get(1));
        Thread.sleep(3000);
        page.sepet.click();

    }




    @Then("araba urun sepetine tiklar")
    public void arabaUrunSepetineTiklar() throws InterruptedException {
        page.urunSepeti.click();
        Thread.sleep(2000);
    }

    @Then("Kullanici cupon kodunu text box'a girer ve Zur Kasse butonuna tiklar")
    public void kullaniciCuponKodunuTextBoxAGirerVeZurKasseButonunaTiklar() throws InterruptedException {
        page.codeTextBox.click();
        page.codeTextBox.sendKeys(ConfigurationReader.getPropery("cupon_code"));
        page.kasse.click();

    }
}







