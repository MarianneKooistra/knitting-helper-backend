package nl.miwgroningen.ch11.marianne.knitting.SummerVacationKnitting.repository;

import nl.miwgroningen.ch11.marianne.knitting.SummerVacationKnitting.model.KnittingCounter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KnittingCounterRepository extends JpaRepository<KnittingCounter, Long> {
}
