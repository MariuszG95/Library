package dto;

import data.model.Author;
import data.model.Book;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class BookDTO {

    private long id;
    private String title;
    private String category;
    private String publishingHouse;
    private Date publicationDate;
    private String edition;
    private String language;
    private String identifier;
    private Set<AuthorDTO> authorSet = new HashSet<>();

    public BookDTO convertToDTO(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setCategory(book.getCategory());
        bookDTO.setPublishingHouse(book.getPublishingHouse());
        bookDTO.setPublicationDate(book.getPublicationDate());
        bookDTO.setEdition(book.getEdition());
        bookDTO.setLanguage(book.getLanguage());
        bookDTO.setIdentifier(book.getIdentifier());
        for (Author author : book.getAuthorSet()) {
            authorSet.add(new AuthorDTO().convertToDTO(author));
        }

        return bookDTO;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Set<AuthorDTO> getAuthorSet() {
        return authorSet;
    }

    public void setAuthorSet(Set<AuthorDTO> authorSet) {
        this.authorSet = authorSet;
    }
}
