package nl.miwgroningen.ch11.marianne.knitting.SummerVacationKnitting.controllerRest;

import lombok.RequiredArgsConstructor;
import nl.miwgroningen.ch11.marianne.knitting.SummerVacationKnitting.model.KnittingCounter;
import nl.miwgroningen.ch11.marianne.knitting.SummerVacationKnitting.service.implementation.KnittingCounterServiceImplementation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

/**
 * URL mappings that handel interactions with the counter model/entity.
 *
 * Gemaakt door Marianne Kooistra (me.kooistra@st.hanze.nl) op 13/08/2023
 */

@RestController
@RequestMapping("/counter")
@RequiredArgsConstructor
public class KnittingCounterRestController {
    private final KnittingCounterServiceImplementation counterServiceImplementation;

    @GetMapping("/")
    public Collection<KnittingCounter> allCounters() {
        return counterServiceImplementation.getAllCounters();
    }

    @GetMapping("/get/{counterId}")
    public KnittingCounter findCounterById(@PathVariable("counterId") Long counterId) {
        return counterServiceImplementation.getById(counterId);
    }

    @PostMapping("/save")
    public KnittingCounter createCounter(@RequestBody @Valid KnittingCounter counter) {
        return this.counterServiceImplementation.create(counter);
    }

    @DeleteMapping("/delete/{counterId}")
    public Boolean deleteCounter(@PathVariable("counterId") Long counterId) {
        return counterServiceImplementation.delete(counterId);
    }
}
