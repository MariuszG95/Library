package data.repositories;

import data.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    Set<Author> getAuthorByFirstNameContains(String value);

    Set<Author> getAuthorByLastNameContains(String value);
}
