package saucedemo;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;

import static saucedemo.Constants.*;


public class LoginActions extends UIInteractionSteps {
    public static Performable loginAsAStandardUser() {
        return Task.where(
                "{0} logs in as " + STANDARD_USER_USERNAME,
                Open.url(URL),
                Enter.theValue().into("#user-name"),
                Enter.theValue(PASSWORD).into("#password"),
                Click.on("#login-button")
        );
    }
    }