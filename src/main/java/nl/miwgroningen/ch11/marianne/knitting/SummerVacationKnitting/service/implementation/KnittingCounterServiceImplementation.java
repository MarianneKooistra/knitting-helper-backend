package nl.miwgroningen.ch11.marianne.knitting.SummerVacationKnitting.service.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.miwgroningen.ch11.marianne.knitting.SummerVacationKnitting.model.KnittingCounter;
import nl.miwgroningen.ch11.marianne.knitting.SummerVacationKnitting.repository.KnittingCounterRepository;
import nl.miwgroningen.ch11.marianne.knitting.SummerVacationKnitting.service.KnittingCounterService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
    public KnittingCounter deleteAndCreate(Long counterId, KnittingCounter counter) {
        //Find current counter and delete it.
        counterRepository.deleteById(counterId);

        //Create a new counter and save it.
        log.info("Counter with id: {} has been removed. New counter: {}. id: {}",
                counterId, counter.getCounterNumber() + " of " + counter.getCounterTotal(), counter.getCounterId());
        return counterRepository.save(counter);
    }

    @Override
    public KnittingCounter get(Long counterId) {
        log.info("Getting counter with id: {}", counterId);
        return counterRepository.findById(counterId).get();
    }
}
