package nl.miwgroningen.ch11.marianne.knitting.SummerVacationKnitting.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * Gemaakt door Marianne Kooistra (me.kooistra@st.hanze.nl) op 23/11/2023
 */

@Data
@Builder
@JsonInclude(NON_NULL)
public class Response {
    protected LocalDateTime timestamp;
    protected int statusCode;
    protected HttpStatus status;
    protected String message;
    protected Map<?, ?> data;
}
