package citrus;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductListPage;
import pages.ProductPage;

import static com.codeborne.selenide.Selenide.clearBrowserLocalStorage;
import static com.codeborne.selenide.Selenide.open;

public class BasketTest {
    HomePage homePage;
    ProductListPage productListPage;
    ProductPage productPage;
    String productName = "Apple iPhone 11 128Gb Black";


    @BeforeClass
    public void setup() {
        Configuration.baseUrl = "https://www.citrus.ua/";
        open("");
        homePage = new HomePage();
        productListPage = new ProductListPage();
        productPage = new ProductPage();
    }

    @BeforeMethod
    public void clearBasket(){
        clearBrowserLocalStorage();
    }


    @Test
        public void addProductToBasketToBasketViaMenu() {
        homePage.waitForPageToLoad()
                .closePopUp()
                .hoverManuLine("Смартфоны")
                .clickLinkMenu("Apple");
        productListPage.clickOnProductByName("Apple iPhone 11 128Gb Black");
        String productPrice = productPage.getProductPrice().replace("₴"," грн");
        productPage.clickAddToBasketButton();

        productPage.getBasket().shouldBe(Condition.visible);
        productPage.getProductNameFromBasket().shouldHaveSize(1);
        productPage.getProductNameFromBasket().get(0).shouldHave(Condition.text(productName));
        productPage.getBasketTotalPrice().shouldHave(Condition.text(productPrice));

    }

//    @Test
//    public void addProductToBasketViaProduct() {
//        homePage.waitForPageToLoad()
//                .closePopUp()
//                .searchPrduct(productName);
//        String productPrice = productListPage.getProductPrice();
//        productPage.clickAddToBasketButton();
//
//        productPage.getBasket().shouldBe(Condition.visible);
//        productPage.getProductNameFromBasket().shouldHaveSize(1);
//        productPage.getProductNameFromBasket().get(0).shouldHave(Condition.text(productName));
//        productPage.getBasketTotalPrice().shouldHave(Condition.text(productPrice));

//    }

}
