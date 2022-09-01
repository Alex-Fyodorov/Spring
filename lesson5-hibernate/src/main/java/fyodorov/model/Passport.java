package fyodorov.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.time.Instant;

@Getter
@Setter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class Passport {
    private String number;
    private String serial;
    private String issuedBy;
    private Instant issuedDate;
}