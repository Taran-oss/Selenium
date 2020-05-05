package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProductListPage extends BasePage {

    SelenideElement productPrice = $("div.base-price");
    SelenideElement addToBasketButon = $("icon-new-citrus-cart el-tooltip item");

    public ProductListPage clickOnProductByName(String productName) {
        $x("//div[@class='product-card__name']/../../..").click();

        return this;
    }

    public String getProductPrice() {
        return productPrice.getText();
    }

    public ProductListPage clickFirstAdToBasketProduct() {
        return null;
    }
}
