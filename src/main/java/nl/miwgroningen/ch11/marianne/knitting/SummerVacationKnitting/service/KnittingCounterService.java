package nl.miwgroningen.ch11.marianne.knitting.SummerVacationKnitting.service;

import nl.miwgroningen.ch11.marianne.knitting.SummerVacationKnitting.model.KnittingCounter;

import java.util.Collection;

/**
 * Gemaakt door Marianne Kooistra (me.kooistra@st.hanze.nl) op 13/08/2023
 */
public interface KnittingCounterService {
    KnittingCounter deleteAndCreate(Long counterId, KnittingCounter counter);
    Collection<KnittingCounter> getAllCounters();
    KnittingCounter getById(Long counterId);
}
