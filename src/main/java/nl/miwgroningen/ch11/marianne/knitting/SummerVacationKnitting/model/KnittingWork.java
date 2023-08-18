package nl.miwgroningen.ch11.marianne.knitting.SummerVacationKnitting.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * KnittingWork is the knitting project (or piece, or WIP/work in progress).
 *
 * Gemaakt door Marianne Kooistra (me.kooistra@st.hanze.nl) op 05/08/2023
 */

@Entity
@Getter @Setter
@Data
@AllArgsConstructor @NoArgsConstructor
public class KnittingWork {
    @Id
    @GeneratedValue
    private Long workId;

    //ToDo: This is what I started with, but working with the counter model was easier to start with.
    // (will probably have use for it later.)
//    private String name;
//
//    @Column(nullable = false)
//    private Integer rows;
//    private String rowPattern;
//
//    private Integer stitchesNumber;
//    private String stitchPattern;
}
