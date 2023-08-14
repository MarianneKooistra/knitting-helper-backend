package nl.miwgroningen.ch11.marianne.knitting.SummerVacationKnitting.controllerRest;

import lombok.RequiredArgsConstructor;
import nl.miwgroningen.ch11.marianne.knitting.SummerVacationKnitting.model.KnittingCounter;
import nl.miwgroningen.ch11.marianne.knitting.SummerVacationKnitting.service.implementation.KnittingCounterServiceImplementation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * URL mappings that handel interactions with the counter model/entity.
 *
 * Gemaakt door Marianne Kooistra (me.kooistra@st.hanze.nl) op 13/08/2023
 */

@RestController
@RequestMapping("/counter")
@RequiredArgsConstructor
public class KnittingCounterRestController {
    //I will need:
    //get the counterNumber
    //save a total
    //a method that deletes current and makes a new one.

    private final KnittingCounterServiceImplementation counterServiceImplementation;

    @GetMapping("/get/{counterId}")
    public KnittingCounter findCounterById(@PathVariable("counterId") Long counterId) {
        return counterServiceImplementation.get(counterId);
    }
}
