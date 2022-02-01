package pages;

import core.Driver;
import maps.HomeMap;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    HomeMap homeMap;

    public HomePage() {
        homeMap = new HomeMap();
        PageFactory.initElements(Driver.getDriver(), homeMap);
    }

    public String getTitulo() {
        return homeMap.titulo.getText();
    }

    public void clickBtnCadastreSe() {
        homeMap.btnCadastreSe.click();
    }

}
