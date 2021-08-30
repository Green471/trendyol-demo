package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TrendyolHomepage {
    public TrendyolHomepage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

        @FindBy(xpath = "(//div[@class='icon-container'])[1]")
        public WebElement einlogenIcon;

        @FindBy(xpath = "//div[@class='signup-button']")
        public WebElement einmelden;

        @FindBy(xpath = "//*[text()='Hallo/Willkommen']")
        public WebElement willcommenText;

        @FindBy(id = "register-email")
        public WebElement email;

        @FindBy(id = "register-password-input")
        public WebElement password;

        @FindBy(xpath = "//*[text()='Männlich']")
        public WebElement gender;

        @FindBy (xpath = "(//label[@class='q-label'])[3]")
        public WebElement checkbox;

        @FindBy(xpath = "//button[@type='submit']")
        public WebElement registerButton;

        @FindBy(xpath = "(//p[@class='link-text'])[1]")
        public WebElement textKonto;

        @FindBy(xpath = "//input[@class='search-box']")
        public WebElement searcbox;

        @FindBy(xpath = "(//img[@class='p-card-img'])[2]")
        public WebElement fav;

        @FindBy(xpath = "//div[@class='sp-itm']")
        public WebElement age;

        @FindBy(xpath = "//*[text()='In den Warenkorb']")
        public WebElement sepet;

        @FindBy(xpath = "//div[@class='code']")
        public WebElement indirimCode;

        @FindBy(xpath = "//input[@id='Kod']")
        public WebElement codeTextBox;


        @FindBy(xpath = "(//*[text()='Zur Kasse'])[2]")
        public WebElement kasse;

        @FindBy(xpath = "(//*[text()='Warenkorb'])[1]")
        public WebElement urunSepeti;









}
