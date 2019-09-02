package dto;

import data.model.Borrow;
import data.model.Order;
import data.model.User;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class LoggedUserDTO {

    private Long id;
    private String login;
    private String email;
    private String password;
    private boolean active;
    private Set<Borrow> borrowSet = new HashSet<>();
    private Set<Order> orderSet = new HashSet<>();

    public LoggedUserDTO() {}

    public LoggedUserDTO(User user) {
        this.id = user.getId();
        this.login = user.getLogin();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.active = user.isActive();
        this.borrowSet = user.getBorrowSet();
        this.orderSet = user.getOrderSet();
    }

    public User getUser() {
        User user = new User();
        user.setId(id);
        user.setLogin(login);
        user.setEmail(email);
        user.setPassword(password);
        user.setActive(active);
        user.setBorrowSet(borrowSet);
        user.setOrderSet(orderSet);

        return user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Borrow> getBorrowSet() {
        return borrowSet;
    }

    public void setBorrowSet(Set<Borrow> borrowSet) {
        this.borrowSet = borrowSet;
    }

    public Set<Order> getOrderSet() {
        return orderSet;
    }

    public void setOrderSet(Set<Order> orderSet) {
        this.orderSet = orderSet;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, login);
    }
}
