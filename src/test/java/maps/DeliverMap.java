package maps;

import core.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeliverMap {

    @FindBy(css = "input[name='fullName']")
    public WebElement name;

    @FindBy(css = "input[name='cpf']")
    public WebElement cpf;

    @FindBy(css = "input[name='email']")
    public WebElement email;

    @FindBy(css = "input[name='whatsapp']")
    public WebElement whatsapp;

    @FindBy(css = "input[name='postalcode']")
    public WebElement postalcode;

    @FindBy(css = "input[name='address-number']")
    public WebElement number;

    @FindBy(css = "input[name='address-details']")
    public WebElement addressDetails;

    public WebElement deliveryMethod (String method) {
        WebElement delivery = Driver.getDriver().findElement(By.xpath("//ul[@class='delivery-method']//span[contains(.,'"+method+"')]/.."));
        return delivery;
    }

    @FindBy(css = "input[value='Buscar CEP']")
    public WebElement btnCep;

    @FindBy(css = "input[accept^='image']")
    public WebElement cnh;

    @FindBy(css = "input[name='address']")
    public WebElement address;

    @FindBy(css = "input[name='district']")
    public WebElement bairro;

    @FindBy(css = "input[name='city-uf']")
    public WebElement cidade;

    @FindBy(css = "button[type='submit'][class='button-success']")
    public WebElement btnCadastreSe;

    @FindBy(css = ".swal2-popup .swal2-html-container")
    public WebElement msgModal;

    @FindBy(css = "span[class='alert-error']")
    public WebElement msgAlertError;

    public WebElement msgAlertField (String field) {
        WebElement alert = Driver.getDriver().findElement(By.cssSelector("input[name='"+field+"'] ~ span"));
        return alert;
    }

    @FindBy(css = "ul[class='delivery-method'] ~ span")
    public WebElement msgAlertMethod;

    @FindBy(xpath = "//input[contains(@accept,'image')]/../following-sibling::span[1]")
    public WebElement msgAlertCnh;

}
