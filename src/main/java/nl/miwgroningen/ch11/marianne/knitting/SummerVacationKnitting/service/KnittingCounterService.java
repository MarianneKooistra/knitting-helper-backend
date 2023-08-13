package nl.miwgroningen.ch11.marianne.knitting.SummerVacationKnitting.service;

import nl.miwgroningen.ch11.marianne.knitting.SummerVacationKnitting.model.KnittingCounter;

/**
 * Gemaakt door Marianne Kooistra (me.kooistra@st.hanze.nl) op 13/08/2023
 */
public interface KnittingCounterService {
    KnittingCounter deleteAndCreate(Long counterId, KnittingCounter counter);
    KnittingCounter get(Long counterId);
}
