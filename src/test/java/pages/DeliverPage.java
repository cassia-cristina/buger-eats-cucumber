package pages;

import core.Driver;
import maps.DeliverMap;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeliverPage {
    DeliverMap deliverMap;
    private WebDriverWait wait;

    public DeliverPage() {
        deliverMap = new DeliverMap();
        PageFactory.initElements(Driver.getDriver(), deliverMap);
    }

    public void setInputName(String nome) {
        deliverMap.name.sendKeys(nome);
    }

    public void setInputCpf(String cpf) {
        deliverMap.cpf.sendKeys(cpf);
    }

    public void setInputEmail(String email) {
        deliverMap.email.sendKeys(email);
    }

    public void setInputWhatsapp(String whatsapp) {
        deliverMap.whatsapp.sendKeys(whatsapp);
    }

    public void setInputPostalCode(String postalcode) {
        deliverMap.postalcode.sendKeys(postalcode);
    }

    public void setInputNumber(String number) {
        deliverMap.number.sendKeys(number);
    }

    public void setInputAddressDetails(String addressDetails) {
        deliverMap.addressDetails.sendKeys(addressDetails);
    }

    public void setDeliveryMethod(String deliveryMethod) {
        deliverMap.deliveryMethod(deliveryMethod).click();
    }

    public void clickBtnCep() {
        deliverMap.btnCep.click();
    }

    public void uploadCnh() {
        deliverMap.cnh.sendKeys("buger-eats-cucumber/src/test/resources/images/cnh-digital.jpg");
    }

    public String getAddress() {
        Driver.attToBeNotEmpty(deliverMap.address);
        return deliverMap.address.getAttribute("value");
    }

    public String getBairro() {
        Driver.attToBeNotEmpty(deliverMap.bairro);
        return deliverMap.bairro.getAttribute("value");
    }

    public String getCidadeUf() {
        Driver.attToBeNotEmpty(deliverMap.cidade);
        return deliverMap.cidade.getAttribute("value");
    }

    public void clickBtnCadastreSe() {
        deliverMap.btnCadastreSe.click();
    }

    public String getMessageModal() {
        return deliverMap.msgModal.getText();
    }

    public String getAlertError() {
        Driver.visibilityElement(deliverMap.msgAlertError);
        return deliverMap.msgAlertError.getText();
    }

    public String getAlertField(String field) {

        if (field.equalsIgnoreCase("method")) {
            Driver.visibilityElement(deliverMap.msgAlertMethod);
            return deliverMap.msgAlertMethod.getText();
        } else if (field.equalsIgnoreCase("cnh")) {
            Driver.visibilityElement(deliverMap.msgAlertCnh);
            return deliverMap.msgAlertCnh.getText();
        } else {
            Driver.visibilityElement(deliverMap.msgAlertField(field));
            return deliverMap.msgAlertField(field).getText();
        }
    }
}
