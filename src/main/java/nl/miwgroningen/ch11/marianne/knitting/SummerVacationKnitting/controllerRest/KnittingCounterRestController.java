package nl.miwgroningen.ch11.marianne.knitting.SummerVacationKnitting.controllerRest;

import lombok.RequiredArgsConstructor;
import nl.miwgroningen.ch11.marianne.knitting.SummerVacationKnitting.model.KnittingCounter;
import nl.miwgroningen.ch11.marianne.knitting.SummerVacationKnitting.model.Response;
import nl.miwgroningen.ch11.marianne.knitting.SummerVacationKnitting.service.implementation.KnittingCounterServiceImplementation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;

import static java.time.LocalDateTime.now;

/**
 * URL mappings that handel interactions with the counter model/entity.
 *
 * Gemaakt door Marianne Kooistra (me.kooistra@st.hanze.nl) op 13/08/2023
 */

@RestController
@RequestMapping("api/counter")
@RequiredArgsConstructor
public class KnittingCounterRestController {
    private final KnittingCounterServiceImplementation counterServiceImplementation;

    @GetMapping("/")
    public ResponseEntity<Response> allCounters() {
        return ResponseEntity.ok(Response.builder()
                .timestamp(now())
                .statusCode(HttpStatus.OK.value())
                .status(HttpStatus.OK)
                .message("All counters retrieved")
                .data(Map.of("counters", counterServiceImplementation.getAllCounters()))
                .build());
    }

    @GetMapping("/get/{counterId}")
    public ResponseEntity<Response> findCounterById(@PathVariable("counterId") Long counterId) {
        return ResponseEntity.ok(Response.builder()
                .timestamp(now())
                .statusCode(HttpStatus.OK.value())
                .status(HttpStatus.OK)
                .message("Counter with id " + counterId + " retrieved")
                .data(Map.of("counter", counterServiceImplementation.getById(counterId)))
                .build());
    }

    @PostMapping("/save")
    public ResponseEntity<Response> createCounter(@RequestBody @Valid KnittingCounter counter) {
        return ResponseEntity.ok(Response.builder()
                .timestamp(now())
                .statusCode(HttpStatus.OK.value())
                .status(HttpStatus.OK)
                .message("Counter has been created or updated")
                .data(Map.of("counter", counterServiceImplementation.create(counter)))
                .build());
    }

    @PostMapping("/add/{counterId}")
    public ResponseEntity<Response> addNumber(@PathVariable("counterId") Long counterId) {
        return ResponseEntity.ok(Response.builder()
                .timestamp(now())
                .statusCode(HttpStatus.OK.value())
                .status(HttpStatus.OK)
                .message("Counter with id " + counterId + " has been increased by 1")
                .data(Map.of("counter", counterServiceImplementation.count(counterId)))
                .build());
    }

    @PostMapping("/subtract/{counterId}")
    public ResponseEntity<Response> subtractNumber(@PathVariable("counterId") Long counterId) {
        return ResponseEntity.ok(Response.builder()
                .timestamp(now())
                .statusCode(HttpStatus.OK.value())
                .status(HttpStatus.OK)
                .message("Counter with id " + counterId + " has been decreased by 1")
                .data(Map.of("counter", counterServiceImplementation.minus(counterId)))
                .build());
    }
}
