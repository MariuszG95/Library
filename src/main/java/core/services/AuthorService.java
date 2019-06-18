package core.services;

import data.model.Author;
import data.repositories.AuthorRepository;
import dto.AuthorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class AuthorService {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Set<AuthorDTO> searchByFirstNameAndLastName(String value) {
        Set<Author> matchingFirstName = authorRepository.getAuthorByFirstNameContains(value);
        Set<Author> matchingLastName = authorRepository.getAuthorByLastNameContains(value);
        Set<AuthorDTO> foundAuthors = new HashSet<>();
        for (Author author : matchingFirstName) {
            foundAuthors.add(new AuthorDTO(author));
        }
        for (Author author : matchingLastName) {
            foundAuthors.add(new AuthorDTO(author));
        }

        return foundAuthors;
    }
}
