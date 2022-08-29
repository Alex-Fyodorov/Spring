package fyodorov.persist;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class User {
    private Long id;

    @NotBlank(message = "Cannot be empty!")
    private String username;

    @Email(message = "Invalid format!")
    private String email;

    @Pattern(regexp = "^(?=.*?[0-9])(?=.*?[A-Z]).{8,}$", message = "Password too simple.")
    private String password;

    private String matchingPassword;

    public User(String username) {
        this.username = username;
    }
}