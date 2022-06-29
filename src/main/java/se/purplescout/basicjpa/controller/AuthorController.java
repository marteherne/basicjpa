package se.purplescout.basicjpa.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.purplescout.basicjpa.model.Author;
import se.purplescout.basicjpa.repository.AuthorRepository;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.Optional;

@RestController
@RequestMapping(path = "author")
@Transactional
public class AuthorController implements Controller<Author> {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author getById(Long id) {
        Optional<Author> a = authorRepository.findById(id);
        if(a.isEmpty())
            throw new NoResultException();

        return a.get();
    }

    @Override
    public void persist(Author author) {
        authorRepository.save(author);
    }
}
