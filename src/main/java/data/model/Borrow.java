package data.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "borrows")
public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "rental_date", nullable = false)
    private Date rentalDate;

    @Column(name = "return_date", nullable = false)
    private Date returnDate;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "borrows_books",
            joinColumns = @JoinColumn(name = "borrow_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private Set<Book> bookSet = new HashSet<>();

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

    public Set<Book> getBookSet() {
        return bookSet;
    }

    public void setBookSet(Set<Book> bookSet) {
        this.bookSet = bookSet;
    }
}
