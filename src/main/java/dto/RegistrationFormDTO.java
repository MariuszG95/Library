package dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.HashMap;
import java.util.Objects;

public class RegistrationFormDTO {

    @Size(min = 3, max = 20, message = "Długość powinna mieć od 3 do 20 znaków!")
    @NotEmpty(message = "Pole nie może być puste!")
    private String login;
    @Size(min = 3, max = 30, message = "Długość powinna mieć od 3 do 30 znaków!")
    private String firstName;
    @Size(min = 3, max = 30, message = "Długość powinna mieć od 3 do 30 znaków!")
    private String lastName;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistrationFormDTO that = (RegistrationFormDTO) o;
        return Objects.equals(login, that.login) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(password, that.password) &&
                Objects.equals(repeatedPassword, that.repeatedPassword) &&
                Objects.equals(errors, that.errors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, firstName, lastName, password, repeatedPassword, errors);
    }

    @Override
    public String toString() {
        return "RegistrationFormDTO{" +
                "login='" + login + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", repeatedPassword='" + repeatedPassword + '\'' +
                ", errors=" + errors +
                '}';
    }
}
