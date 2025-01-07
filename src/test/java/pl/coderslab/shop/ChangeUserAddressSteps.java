package pl.coderslab.shop;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ChangeUserAddressSteps {
    UserAddressPage userAddressPage;
    WebDriver driver;

    @Given("^I'm logged in to My Store shop$")
    public void ImLoggedInToMyStoreShop() {
        System.setProperty("webdriver.chrome.driver", "/Users/luiza/Desktop/WebDrivers/chromedriver");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("nhpetpkjzraodylvuw@nbmbb.com", "test123");
    }

    @When("^I go to UserAddressPage$")
    public void IGoToUserAddressPage() {
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=addresses");
        userAddressPage = new UserAddressPage(driver);
    }

    @And("^I click create new address$")
    public void IClickCreateNewAddress() {
        userAddressPage.createNewAddress();
    }

    @And("I enter {string} alias {string} address {string} city {string} postalCode {string} phone")
    public void IEnterAliasAddressCityPostalCodePhone(String alias, String address, String city, String postalCode, String phone) {
        userAddressPage.setAlias(alias);
        userAddressPage.setAddress1(address);
        userAddressPage.setCity(city);
        userAddressPage.setPostalCode(postalCode);
        userAddressPage.setPhone(phone);
    }

    @And("^I save all data$")
    public void ISaveAllData() {
        userAddressPage.submitAddress();
    }

    @Then("^I can see success message \"([^\"]*)\"$")
    public void ICanSeeSuccessMessage(String message) {
        Assert.assertEquals(message, userAddressPage.getUpdateInformation());
    }

    @And("^close browser$")
    public void closeBrowser() {
        driver.quit();
    }
}


