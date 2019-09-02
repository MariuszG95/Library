package dto;

import data.model.Book;
import data.model.Borrow;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class BorrowDTO {

    private long id;
    private Date rentalDate;
    private Date returnDate;
    private Set<BookDTO> bookSet = new HashSet<>();

    public BorrowDTO convertToDTO(Borrow borrow) {
        BorrowDTO borrowDTO = new BorrowDTO();
        borrowDTO.setId(borrow.getId());
        borrowDTO.setRentalDate(borrow.getRentalDate());
        borrowDTO.setReturnDate(borrow.getReturnDate());
        for (Book book : borrow.getBookSet()) {
            bookSet.add(new BookDTO().convertToDTO(book));
        }

        return borrowDTO;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Set<BookDTO> getBookSet() {
        return bookSet;
    }

    public void setBookSet(Set<BookDTO> bookSet) {
        this.bookSet = bookSet;
    }
}
