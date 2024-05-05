package saucedemo;


import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.ui.Button;
import net.serenitybdd.screenplay.ui.InputField;
import net.serenitybdd.screenplay.ui.PageElement;
import org.htmlunit.javascript.host.html.HTMLSpanElement;
import org.junit.jupiter.api.extension.ExtendWith;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.annotations.CastMember;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.Enter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import net.serenitybdd.screenplay.questions.Text;
import static org.assertj.core.api.Assertions.assertThat;

// Import the Constants class
import static saucedemo.Constants.*;

@ExtendWith(SerenityJUnit5Extension.class)
class WhenOrderingClothesFromSwagLabs {


    @CastMember(name = "Melinda")
    Actor melinda;

    @CastMember(name = "Bill")
    Actor bill;

    @Test
    @DisplayName("Login with standard username and buy a jacket")
    void loginAndBuyJacket() {
        melinda.attemptsTo(
                Open.url(URL),
                Enter.theValue(STANDARD_USER_USERNAME).into("#user-name"),
                Enter.theValue(PASSWORD).into("#password"),
                Click.on(Button.withNameOrId("login-button")),
                Ensure.that(PageElement.withNameOrId("title")).hasTextContent("Products")
        );

        melinda.attemptsTo(
                Click.on(Button.withNameOrId("add-to-cart-sauce-labs-fleece-jacket")),
                Ensure.that(PageElement.withNameOrId("shopping-cart-badge")).hasTextContent("1")
        );

        melinda.attemptsTo(
                Click.on(PageElement.withNameOrId("shopping-cart-link")),
                Click.on(Button.withNameOrId("checkout")),
                Enter.theValue(FIRST_NAME).into("#first-name"),
                Enter.theValue(LAST_NAME).into("#last-name"),
                Enter.theValue(POSTAL_CODE).into("#postal-code"),
                Click.on(Button.withNameOrId("continue")),
                Click.on(Button.withNameOrId("finish")),
                Click.on(Button.withNameOrId("back-to-products"))

        );

    }

    @Test
    @DisplayName("Attempt to login with locked out username")
    void attemptLoginWithLockedOutUsername() {
        bill.attemptsTo(
                Open.url(URL),
                Enter.theValue(LOCKED_OUT_USER_USERNAME).into("#user-name"),
                Enter.theValue(PASSWORD).into("#password"),
                Click.on(Button.withNameOrId("login-button")),
                Ensure.that(Button.withNameOrId("login-button")).isDisplayed()
        );
    }
}



//
//    @Test
//    @DisplayName("Add shirts and jacket to cart")
//    void AddShirtsAndJacketToCart() {
//        melinda.attemptsTo(
//                Open.url("https://www.saucedemo.com/inventory.html"),
//                Click.on(Button.withNameOrId("add-to-cart-sauce-labs-fleece-jacket")),
////                Click.on(Button.withNameOrId("add-to-cart-sauce-labs-bolt-t-shirt")),
////                Click.on(Button.withNameOrId("add-to-cart-test\\.allthethings\\(\\)-t-shirt-\\(red\\)")),
//                Ensure.that(PageElement.withNameOrId("shopping-cart-badge")).hasTextContent("1"),
//                Ensure.that(PageElement.withNameOrId("title")).hasTextContent("Products")
//
//        );




