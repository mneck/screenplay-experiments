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

    @Test
    @DisplayName("Login with standard username and password")
    void loginWithUsernameAndPassword() {
        melinda.attemptsTo(
                Open.url(URL),
                Enter.theValue(STANDARD_USER_USERNAME).into("#user-name").thenHit(Keys.RETURN),
                Enter.theValue(PASSWORD).into("#password").thenHit(Keys.RETURN),
                Click.on(Button.withNameOrId("login-button")),
                Ensure.that(PageElement.withNameOrId("title")).hasTextContent("Products")
        );

    }

}
