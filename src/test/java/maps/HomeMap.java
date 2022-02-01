package maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeMap {

    @FindBy(css = "#page-home main h1")
    public WebElement titulo;

    @FindBy(css = "a[href='/deliver']")
    public WebElement btnCadastreSe;
}
