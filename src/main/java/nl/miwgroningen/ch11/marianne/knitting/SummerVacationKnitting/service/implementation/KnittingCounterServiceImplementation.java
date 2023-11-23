package nl.miwgroningen.ch11.marianne.knitting.SummerVacationKnitting.service.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.miwgroningen.ch11.marianne.knitting.SummerVacationKnitting.model.KnittingCounter;
import nl.miwgroningen.ch11.marianne.knitting.SummerVacationKnitting.repository.KnittingCounterRepository;
import nl.miwgroningen.ch11.marianne.knitting.SummerVacationKnitting.service.KnittingCounterService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

/**
 * Gemaakt door Marianne Kooistra (me.kooistra@st.hanze.nl) op 13/08/2023
 */

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class KnittingCounterServiceImplementation implements KnittingCounterService {
    private static final String COUNTER_NOT_FOUND = "Counter not found";
    private final KnittingCounterRepository counterRepository;

    @Override
    public Collection<KnittingCounter> getAllCounters() {
        log.info("Getting the collection of all the counters");
        return counterRepository.findAll();
    }

    @Override
    public KnittingCounter getById(Long counterId) {
        log.info("Getting counter with id: {}", counterId);
        return counterRepository.findById(counterId).get();
    }

    @Override
    public KnittingCounter create(KnittingCounter counter) {
        log.info("New counter: {}. id: {}",
                counter.getCounterNumber() + " of " + counter.getCounterTotal(), counter.getCounterId());
        return counterRepository.save(counter);
    }

    @Override
    public KnittingCounter count(Long counterId) {
        Optional<KnittingCounter> optionalCounter = counterRepository.findById(counterId);
        if (optionalCounter.isPresent()) {
            KnittingCounter counter = optionalCounter.get();

            if (counter.counterDone()) {
                counter.setCounterNumber(0);
                log.info("Counter is done and reset to 0");
            } else {
                int oldNumber = counter.getCounterNumber();
                int newNumber = oldNumber + 1;
                counter.setCounterNumber(newNumber);
                log.info("Counter {} (id: {}) from {}, to {} of {}",
                        counter.getCounterName(), counterId, oldNumber, newNumber, counter.getCounterTotal());
            }

            return counterRepository.save(counter);
        } throw new IllegalArgumentException(COUNTER_NOT_FOUND);
    }

    @Override
    public KnittingCounter minus(Long counterId) {
        Optional<KnittingCounter> optionalCounter = counterRepository.findById(counterId);
        if (optionalCounter.isPresent()) {
            KnittingCounter counter = optionalCounter.get();

            int oldNumber = counter.getCounterNumber();
            int newNumber = oldNumber - 1;
            counter.setCounterNumber(newNumber);
            log.info("Counter with id: {} has decreased from {}, to {} of {}",
                    counter.getCounterId(), oldNumber, counter.getCounterNumber(), counter.getCounterTotal());

            return counterRepository.save(counter);
        } throw new IllegalArgumentException(COUNTER_NOT_FOUND);
    }
}
