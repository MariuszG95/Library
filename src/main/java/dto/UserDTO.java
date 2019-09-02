package dto;

import data.model.Borrow;
import data.model.Order;
import data.model.User;

import java.util.HashSet;
import java.util.Set;

public class UserDTO {

    private long id;
    private String login;
    private String email;
    private String password;
    private boolean active;
    private Set<BorrowDTO> borrowSet = new HashSet<>();
    private Set<OrderDTO> orderSet = new HashSet<>();

    public UserDTO convertToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setLogin(user.getLogin());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setActive(user.isActive());
        for (Borrow borrow : user.getBorrowSet()) {
            borrowSet.add(new BorrowDTO().convertToDTO(borrow));
        }
        for (Order order : user.getOrderSet()) {
            orderSet.add(new OrderDTO().convertToDTO(order));
        }

        return userDTO;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Set<BorrowDTO> getBorrowSet() {
        return borrowSet;
    }

    public void setBorrowSet(Set<BorrowDTO> borrowSet) {
        this.borrowSet = borrowSet;
    }

    public Set<OrderDTO> getOrderSet() {
        return orderSet;
    }

    public void setOrderSet(Set<OrderDTO> orderSet) {
        this.orderSet = orderSet;
    }
}
