package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage extends BasePage {
    SelenideElement popUpCloseButton = $("//button[@aria-label='Close']");
    SelenideElement searchInput = $("#search-input");
    SelenideElement serchButtonSubmit = $("button.global-search__submit");


    public HomePage hoverManuLine(String lineName) {
        $x("//span[contains(text(),'Смартфоны')]").hover();
        return this;
    }

    public HomePage clickLinkMenu(String linkText) {
        $x("//a[@href='/smartfony/brand-apple/']/span[contains(text(),'" + linkText + "')]").click();
        return this;
    }

    public HomePage closePopUp() {
        if (popUpCloseButton.isDisplayed()) {
            popUpCloseButton.click();
        }
                return this;
            }


            public HomePage waitForPageToLoad () {
                super.waitForPageToLoad();
                return this;
            }

    public HomePage searchPrduct(String productName) {
        searchInput.val(productName);
        return null;
    }
}

