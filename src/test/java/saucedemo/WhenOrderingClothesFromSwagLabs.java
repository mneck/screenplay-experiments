package saucedemo;


import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ui.Button;
import net.serenitybdd.screenplay.ui.InputField;
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
    @DisplayName("Add a todo item to an empty list")
    void addToEmptyList() {
        melinda.attemptsTo(
                Open.url("https://todomvc.com/examples/angular/dist/browser/#/all"),
//                Click.on(InputField.withNameOrId("username")),

                Enter.theValue(STANDARD_USER_USERNAME).into(".username").thenHit(Keys.RETURN),
                Enter.theValue(PASSWORD).into("password").thenHit(Keys.RETURN)
        );
//        var todos = melinda.asksFor(Text.ofEach(".todo-list li"));
//        assertThat(todos).containsExactly("Buy butter", "Buy eggs");
    }

}
