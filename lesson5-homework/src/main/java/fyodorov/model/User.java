package fyodorov.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Component
@Scope("prototype")
@Setter
@Getter
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = false)
    @NotBlank(message = "Name field cannot be empty")
    private String name;

    @OneToOne(mappedBy = "user",
            cascade = {CascadeType.ALL},
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private Cart cart;

    public User(String name) {
        this.name = name;
    }
}
