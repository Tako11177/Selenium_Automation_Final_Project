package org.example.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
    private WebDriver driver;

    @FindBy(xpath = "//input[@id='search_input']")
    WebElement searchBox;

    @FindBy(xpath = "//button[@class='ty-search-magnifier']")
    WebElement searchButton;


    // ავტორიზაციის ელემენტები
    @FindBy(xpath = "//input[@id='login_main_login']")
    WebElement usernameInput;

    @FindBy(xpath  = "//input[@id='psw_main_login']")
    WebElement passwordInput;

    @FindBy(xpath = "//form[@class='cm-processed-form']//button[@type='submit']")
    WebElement loginButton;



    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void searchProduct(String productName) {
        searchBox.sendKeys(productName);
        searchButton.click();
    }

    public void clearSearchBox() {
        searchBox.clear();
    }

    // ავტორიზაციისმეთოდი
    public void loginUser(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);

        // ავტირუზაციის ღილაკის დაჭერამდე 2 წამით მოცდა რომ საიტი კარგად ჩაიტვირთოს და დავინახოთ იუზრნეიმის და პაროლის ჩაწერის პროცესი
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        loginButton.click();
    }
}
