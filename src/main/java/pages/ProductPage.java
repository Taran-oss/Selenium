package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class ProductPage extends BasePage {

    SelenideElement productPrice = $x("//div[@class='price']/span");
    SelenideElement buyButton = $(".normal .btn");
    SelenideElement backerPopPu = $("el-dialog el-dialog--medium");
    ElementsCollection productNames = $$("ctrs-basket-product__name");
    SelenideElement basketTotalPrice = $("ctrs-basket-footer__new-price");

    public String getProductPrice() {
        return productPrice.getText();

    }

    public ProductPage clickAddToBasketButton() {
        buyButton.click();

        return this;
    }

    public SelenideElement getBasket() {
        return backerPopPu;
    }

    public ElementsCollection getProductNameFromBasket() {
        return productNames;
    }

    public SelenideElement getBasketTotalPrice() {
        return basketTotalPrice;
    }
}
