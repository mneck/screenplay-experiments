package agecheck;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.annotations.CastMember;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenCheckingAge {

        @CastMember(name = "Aster")
        Actor aster;

        int age = 20;

        @Test
        @DisplayName("Check Aster's age is 20")
        void checkAstersAge() {
            aster.attemptsTo(
                    Ensure.that(age).isEqualTo(20)
            );
        }

    }
