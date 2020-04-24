package Package;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.Test;


import static com.codeborne.selenide.Selenide.*;

public class Tiket {

    @Test
    public void SerchWizzair() {

        Configuration.timeout = 4000;

        open("https://wizzair.com/");
        $("#search-departure-station").setValue("Vienna");
        $x("//mark[contains(text(),'Vienna')]").click();
        $("#search-arrival-station").setValue("Kyiv");
        $x("//mark[contains(text(),'Kyiv')]").click();
        $("#search-departure-date").click();
        $x("//button[@data-pika-year='2020'][@data-pika-month='5'][@data-pika-day='8']").click();
        $x("//button[@data-pika-year='2020'][@data-pika-month='5'][@data-pika-day='11']").click();
        $x("//button[@data-test='calendar-shrinkable-ok-button']").click();
        $("#search-passenger").click();
        $x("//button[@data-test='services-flight-search-increment']").click();
        $x("//button[@data-test='flight-search-hide-panel']").click();
        $x("//span[contains(text(),'Search')]").click();
        switchTo().window(1);
        $$x("//div[@class='flight-select__fare-selector transition-fade-in transition-zoom-in transition-fade-in-enter transition-zoom-in-enter']").shouldHaveSize(2);
        $x("//time[@class='flight-select__flight-info__day']").shouldHave(Condition.text("8 Jun 2020"));
        $x("//time[@class='flight-select__flight-info__day'][2]").shouldHave(Condition.text("11 Jun 2020"));

    }
    @Test
    public void SerchTicketRianAir() {
        Configuration.timeout = 2000;

        open("https://www.ryanair.com/");
        $("#input-button__destination").setValue("VVienna");
        $x("//button[@class='flight-search-widget__start-search ry-button--gradient-yellow ng-trigger ng-trigger-collapseExpandCta']").click();
        $x("//div[@class='input-button__input ng-star-inserted input-button__display-value--error']").click();
        $x("//div[@data-id='2020-05-08']").click();
        $x("//div[@data-id='2020-05-11']").click();
        $x("//div[@class='counter__button-wrapper--enabled']").click();
        $x("//button[@class='flight-search-widget__start-search ry-button--gradient-yellow ng-trigger ng-trigger-collapseExpandCta']").click();
        $x("//button[@class='pillar-tab__button pillar-tab__button--desktop ng-star-inserted']").click();
        $$x("//div[@class='app-container ng-tns-c0-0 ng-star-inserted']").shouldHaveSize(1);
        $x("//div[@class='date-item__date b2 date-item__date--selected']").shouldHave(Condition.text("08 трав."));
        $x("//div[@class='date-item__date b2 date-item__date--selected'][2]").shouldHave(Condition.text("11 трав."));
    }
    @Test
    public void SerchTicketFlyuia() {
        Configuration.timeout = 2000;

        open("https://www.flyuia.com/");
        $x("//input[@placeholder='Отправление']").setValue("КИЕВ").pressEnter();
        $x("//input[@placeholder='Прибытие']").setValue("ВЕНА").pressEnter();
        $x("//*[@id=\"1\"]/div/sw-root/sw-search-flights/div[2]/form/div[3]/div[1]/sw-form-control-datepicker[1]/div[1]/div[2]/div").click();
        $x("//*[@id=\"1\"]/div/sw-root/sw-search-flights/div[2]/div[1]/div[2]/div[2]/div[2]/span[3]/button").click();
        $x("//*[@id=\"1\"]/div/sw-root/sw-search-flights/div[2]/div[1]/div[2]/div[2]/div[3]/div[2]/div[12]").click();
        $x("//*[@id=\"1\"]/div/sw-root/sw-search-flights/div[2]/form/div[3]/div[1]/sw-form-control-datepicker[2]/div[1]").click();
        $x("//*[@id=\"1\"]/div/sw-root/sw-search-flights/div[2]/div[1]/div[2]/div[2]/div[3]/div[2]/div[15]").click();
        $x("//*[@id=\"1\"]/div/sw-root/sw-search-flights/div[2]/form/div[4]/div[1]/sw-form-control-passengers/div[1]").click();
        $x("//*[@id=\"1\"]/div/sw-root/sw-search-flights/div[2]/div[1]/div[3]/div/div[3]/div[1]/button[2]").click();
        $("#SEARCH_WIDGET_FORM_BUTTONS_SEARCH_FLIGHTS").click();

    }
}