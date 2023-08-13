package nl.miwgroningen.ch11.marianne.knitting.SummerVacationKnitting.model;

import lombok.*;

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
    private Integer counterNumber;
    private Integer counterTotal;

    public Integer numberLeft() {
        return counterTotal - counterNumber;
    }
}
