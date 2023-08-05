package nl.miwgroningen.ch11.marianne.knitting.SummerVacationKnitting.repository;

import nl.miwgroningen.ch11.marianne.knitting.SummerVacationKnitting.model.KnittingWork;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KnittingWorkRepository extends JpaRepository<KnittingWork, Long> {
}
