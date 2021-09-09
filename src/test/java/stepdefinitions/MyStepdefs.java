package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.TrendyolHomepage;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class MyStepdefs {

    TrendyolHomepage page= new TrendyolHomepage();
    Actions actions= new Actions(Driver.getDriver());

    Faker faker= new Faker();
    @Given("Kullanıcı {string} anasayfasına gider")
    public void kullanıcıAnasayfasınaGider(String url) {
        Driver.getDriver().get(ConfigurationReader.getPropery(url));
    }



    @Then("Imleci einlogen dropdown üzrine getirir")
    public void imleciEinlogenDropdownÜzrineGetirir()  {
        Driver.waitForVisibility(page.einlogenIcon,5);
        actions.moveToElement(page.einlogenIcon).build().perform();

    }

    @Then("Einmelden dropdown'a tiklar")
    public void einmeldenDropdownATiklar()  {
        Driver.waitForVisibility(page.einlogenIcon,5);
        page.anmelden.click();

    }

    @Then("Kullanici {string} yazisini ekranda görmeli")
    public void kullaniciYazisiniEkrandaGörmeli(String str) {


        System.out.println(str);
        Assert.assertEquals("Hallo/Willkommen,",str);
    }

    @Then("E-mail text box'na gecerli e-mail girer")
    public void eMailTextBoxNaGecerliEMailGirer()  {

        page.email.sendKeys(faker.name().username()+ConfigurationReader.getPropery("gecerli_email"));
    }

    @Then("Password text box'ına geçerli password girilir")
    public void passwordTextBoxInaGeçerliPasswordGirilir() {
        page.password.sendKeys(ConfigurationReader.getPropery("gecerli_pass"));
    }

    @Then("Kullanici Männlich butonuna tiklar")
    public void kullaniciMännlichButonunaTiklar() throws InterruptedException {

        page.gender.click();
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();

      //  Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @And("Kullanici checkbox'a tiklar")
    public void kullaniciCheckboxATiklar() throws InterruptedException {

       actions.moveToElement(page.checkbox).perform();
       page.checkbox.click();

       //actions.moveToElement(page.checkbox1).perform();
       // actions.moveToElement(driver.findElement(By.linkText("Scans"))).click().perform();
      //  actions.moveToElement(Driver.getDriver().findElement(By.xpath("//div[@name='personal-data-error']"))).perform();
      // page.checkbox1.click();
    }

    @Then("Kullanici registration butonuna tiklar")
    public void kullaniciRegistrationButonunaTiklar() {
        Driver.waitForVisibility(page.registerButton,5);
        page.registerButton.click();

    }

    @Then("Kullanici {string} yazisini görmeli")
    public void kullaniciYazisiniGörmeli(String konto) {

        Assert.assertTrue(konto,true);
    }

    @Then("Kullanici searcbox'a {string} aramasi yapar")
    public void kullaniciSearcboxAAramasiYapar(String kinder) {
        page.searcbox.sendKeys(kinder,Keys.ENTER);
    }

    @Then("Kullanici begendigi ürünleri fav'a ekler")
    public void kullaniciBegendigiÜrünleriFavAEkler() {
        page.fav01.click();
        page.fav02.click();
    }



    @Then("Kullanici begendigi ürüne tiklar")
    public void kullaniciBegendigiÜrüneTiklar() {
        page.kleid.click();
        Set<String > winHand=Driver.getDriver().getWindowHandles();
        List<String> list= new ArrayList<>();
        list.addAll(winHand);

        Driver.getDriver().switchTo().window(list.get(1));
    }

    @Then("Kullanici yas araligini secer")
    public void kullaniciYasAraliginiSecer() {
        page.age.click();
    }

    @Then("Kullanici inden waren korb butonuna tiklar")
    public void kullaniciIndenWarenKorbButonunaTiklar() {
        Driver.waitForVisibility(page.sepet,5);
        page.sepet.click();
    }

    @Then("Urun sepetine tiklar")
    public void urunSepetineTiklar() {
        Driver.waitForVisibility(page.urunSepeti,5);
        page.urunSepeti.click();
    }

    @Then("Kullanici cupon kodunu text box'a girer ve Zur Kasse butonuna tiklar")
    public void kullaniciCuponKodunuTextBoxAGirerVeZurKasseButonunaTiklar() {
        page.codeTextBox.sendKeys(ConfigurationReader.getPropery("cupon_code"));
        Driver.waitForVisibility(page.kasse,5);
        page.kasse.click();
    }


}
