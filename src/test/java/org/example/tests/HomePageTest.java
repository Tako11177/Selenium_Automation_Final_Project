package org.example.tests;

import org.example.config.ConfigReader;
import org.testng.annotations.*;
import org.example.pages.HomePage;
import org.example.utils.DriverManager;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;



public class HomePageTest extends BaseTest {

    @BeforeMethod
    public void setup() {
        DriverManager.getDriver().get(ConfigReader.get("baseUrl"));
        test.info("ბრაუზერი ჩაირთო და გადავიდა მთავარ გვერდზე");  // პირველი ლოგი ExtentReport-სთვის
    }

    @Test
    public void testSearchProduct() {
        // ტესტ ქეისი 1 - მთავარ გვერდზე საძიებო ველში მოძებნოს პუფი
        test.info("პირველი პროდუქტის ძიების დაწყება");
        HomePage home = new HomePage(DriverManager.getDriver());
        home.searchProduct("პუფი");
        test.pass("პირველი პროდუქტის ძიება დამთავრებულია");

        test.info("მეორე ტესტ ქეისის დაწყებამდე 5 წამიანი პაუზა (Thread.sleep)");
        try {
            Thread.sleep(5000); // 2 seconds delay
        } catch (InterruptedException e) {
           e.printStackTrace();
        }


        // ტესტ ქეისი 2 - გაასუფთავოს საძიებო ველი და მოძებნოს სავარძელი
        test.info("მეორე პროდუქტის ძიების დაწყება");
        HomePage home1 = new HomePage(DriverManager.getDriver());
        home.clearSearchBox(); // გაასუფთავებს საძიებო ველს
        test.info("საძიებო ველის გასუფთავება დასრულებულია");
        home1.searchProduct("სავარძელი");
        test.pass("მეორე პროდუქტის ძიება დამთავრებულია");


        test.info("5 წამიანი პაუზა (Thread.sleep)");
        try {
            Thread.sleep(5000); // 2 seconds delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testLogin() {
        test.info("ავტორიზაციის დაწყება");

        // ტესტ ქეისი 3 - ავტორიზაციის ვებ-გვერდზე გადასვლა
        DriverManager.getDriver().get(ConfigReader.get("authUrl"));
        test.info("ავტორიზაციის ვებ-გვერდზე გადასვლა");

        // username-ის და password-ის წამოღება რესურსიდან
        String username = ConfigReader.get("username");
        String password = ConfigReader.get("password");

        // ლოგინის პროცესი
        HomePage home = new HomePage(DriverManager.getDriver());
        home.loginUser(username, password);
        test.pass("ავტორიზაციის ტესტი დასრულდა");

        // ტესტ ქეისი 4 - კატალოგის დათვალიერება
        String[] urls = {
                ConfigReader.get("msheneblobaUrl"),
                ConfigReader.get("ikeaUrl")
        };

        for (String url : urls) {
            test.info("გადასვლა კატალოგში: " + url);
            DriverManager.getDriver().get(url);

            // 2000 პიქსელი ქვემოთ
            ((org.openqa.selenium.JavascriptExecutor) DriverManager.getDriver())
                    .executeScript("window.scrollBy(0,2000)");
            test.info("გვერდის დათვალიერება - 2000 პიქსელით ქვემოთ");

            // მოკლე პაუზა რომ დავინახოთ სქროლის ეფექტი
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 2000 პიქსელი ზემოთ
            ((org.openqa.selenium.JavascriptExecutor) DriverManager.getDriver())
                    .executeScript("window.scrollBy(0,-2000)");
            test.info("გვერდის დათვალიერება - 2000 პიქსელით ზემოთ");

            // მოკლე პაუზა შემდეგ URL-ზე გადასვლისთვის
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // ტესტ ქეისი 5 - მომხმარებლის გამოსვლა
        String logoutUrl = ConfigReader.get("logoutUrl");
        test.info("მომხმარებლის გამოსვლა: " + logoutUrl);
        DriverManager.getDriver().get(logoutUrl);
        test.pass("მომხმარებელი გამოვიდა სისტემიდან წარმატებით");

        // მოკლე პაუზა, რომ გვერდი დამტვირთავი იყოს
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 1. იპოვეთ Account ელემენტი
        WebElement accountMenu = DriverManager.getDriver().findElement(
                By.xpath("//a[@class='ac-title' and contains(@href,'profiles-update')]"));

        // 2. Hover მაუსის გადაადგილება Account ელემენტზე
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(accountMenu).perform();

        // 3. "ავტორიზაცია" ელემენტის პოვნა
        WebElement authorizationBtn = DriverManager.getDriver().findElement(
                By.xpath("//div[@id='dropdown_68']/div[@class='ty-account-info__buttons buttons-container']/a[@class='cm-dialog-opener cm-dialog-auto-size ty-btn ty-btn__secondary']"));

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        // 4. Assertion რომ ელემენტი ჩანს
        try {
            Assert.assertTrue(authorizationBtn.isDisplayed(), "მომხმარებელი ვერ გამოვიდა სისტემიდან: ავტორიზაცია ვერ დაინახეს.");
            test.pass("Logout assertion შესრულდა: # ავტორიზაცია # ღილაკი ჩანს და მომხმარებელი ნამდვილად გამოსულია სისტემიდან");
        } catch (AssertionError e) {
            test.fail("Logout assertion ვერ შესრულდა: " + e.getMessage());
            throw e;
        }



    }


    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
        test.info("ბრაუზერის დახურვა");
    }
}


