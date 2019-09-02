package dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.HashMap;

public class RegistrationFormDTO {

    @Size(min = 3, max = 20, message = "Długość powinna mieć od 3 do 20 znaków!")
    @NotEmpty(message = "Pole nie może być puste!")
    private String login;
    @NotEmpty(message = "Pole nie może być puste!")
    private String email;
    @NotEmpty(message = "Pole nie może być puste!")
    private String password;
    @NotEmpty(message = "Pole nie może być puste!")
    private String repeatedPassword;
    private HashMap<String, String> errors = new HashMap<>();

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatedPassword() {
        return repeatedPassword;
    }

    public void setRepeatedPassword(String repeatedPassword) {
        this.repeatedPassword = repeatedPassword;
    }

    public HashMap<String, String> getErrors() {
        return errors;
    }

    public void setErrors(HashMap<String, String> errors) {
        this.errors = errors;
    }
}
