package dto;

import data.model.Book;
import data.model.Order;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class OrderDTO {

    private long id;
    private Date orderDate;
    private Set<BookDTO> bookSet = new HashSet<>();

    public OrderDTO convertToDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setOrderDate(order.getOrderDate());
        for (Book book : order.getBookSet()) {
            bookSet.add(new BookDTO().convertToDTO(book));
        }

        return orderDTO;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Set<BookDTO> getBookSet() {
        return bookSet;
    }

    public void setBookSet(Set<BookDTO> bookSet) {
        this.bookSet = bookSet;
    }
}
