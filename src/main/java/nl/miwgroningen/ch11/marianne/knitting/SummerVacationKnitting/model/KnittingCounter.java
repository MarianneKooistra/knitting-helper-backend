package nl.miwgroningen.ch11.marianne.knitting.SummerVacationKnitting.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * The KnittingCounter keeps track of how many rows (or other things) have been completed out of the total.
 *
 * Gemaakt door Marianne Kooistra (me.kooistra@st.hanze.nl) op 13/08/2023
 */

@Entity
@Getter @Setter
@Data
@AllArgsConstructor @NoArgsConstructor
public class KnittingCounter {
    @Id
    @GeneratedValue
    private Long counterId;

    private String counterName = "No name given";
    private Integer counterNumber = 0;
    private Integer counterTotal = 0;

    public Integer numberLeft() {
        return counterTotal - counterNumber;
    }
}
