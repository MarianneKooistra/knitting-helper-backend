package nl.miwgroningen.ch11.marianne.knitting.SummerVacationKnitting.service.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.miwgroningen.ch11.marianne.knitting.SummerVacationKnitting.model.KnittingCounter;
import nl.miwgroningen.ch11.marianne.knitting.SummerVacationKnitting.repository.KnittingCounterRepository;
import nl.miwgroningen.ch11.marianne.knitting.SummerVacationKnitting.service.KnittingCounterService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

/**
 * Gemaakt door Marianne Kooistra (me.kooistra@st.hanze.nl) op 13/08/2023
 */

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class KnittingCounterServiceImplementation implements KnittingCounterService {
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
    public KnittingCounter count(KnittingCounter counter) {
        if (counter.counterDone()) {
            counter.setCounterNumber(0);
            log.info("Counter is done and reset to 0");
        } else {
            counter.setCounterNumber(counter.getCounterNumber() + 1);
            log.info("{} (id: {}) from {}, to {} of {}",
                    counter.getCounterName(), counter.getCounterId(), counter.getCounterNumber(), counter.getCounterNumber(), counter.getCounterTotal());
        }

        return counterRepository.save(counter);
    }

    @Override
    public Boolean delete(Long counterId) {
        log.info("Counter with id: {} has been removed.", counterId);
        counterRepository.deleteById(counterId);
        return Boolean.TRUE;
    }
}
