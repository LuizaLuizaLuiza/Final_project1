package pl.coderslab.shop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserAddressPage {
    private static WebDriver driver;

    @FindBy(css = ".addresses-footer a[data-link-action='add-address']")
    WebElement createNewAddressButton;

    @FindBy(name = "alias")
    WebElement aliasInput;

    @FindBy(name = "address1")
    WebElement address1Input;

    @FindBy(name = "city")
    WebElement cityInput;

    @FindBy(name = "postcode")
    WebElement postalCodeInput;

    @FindBy(name = "phone")
    WebElement phoneInput;

    @FindBy(css = ".btn.btn-primary.form-control-submit")
    WebElement submitButton;

    @FindBy(css = ".alert.alert-success")
    WebElement successInformation;

    public UserAddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void createNewAddress() {
        createNewAddressButton.click();
    }

    public void setAlias(String alias) {
        aliasInput.click();
        aliasInput.clear();
        aliasInput.sendKeys(alias);
    }

    public void setAddress1(String address1) {
        address1Input.click();
        address1Input.clear();
        address1Input.sendKeys(address1);
    }

    public void setCity(String city) {
        cityInput.click();
        cityInput.clear();
        cityInput.sendKeys(city);
    }

    public void setPostalCode(String postalCode) {
        postalCodeInput.click();
        postalCodeInput.clear();
        postalCodeInput.sendKeys(postalCode);
    }

    public void setPhone(String phone) {
        phoneInput.click();
        phoneInput.clear();
        phoneInput.sendKeys(phone);
    }

    public void submitAddress() {
        submitButton.click();
    }

    public String getUpdateInformation() {
        return successInformation.getText();
    }

}
