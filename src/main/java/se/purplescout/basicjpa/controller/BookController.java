package se.purplescout.basicjpa.controller;

import org.springframework.web.bind.annotation.*;
import se.purplescout.basicjpa.model.Book;
import se.purplescout.basicjpa.repository.BookRepository;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.Optional;
@RestController
@RequestMapping(path = "book")
@Transactional
public class BookController implements Controller<Book> {

    final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book getById(Long id) {
        Optional<Book> b = bookRepository.findById(id);
        if(b.isEmpty())
            throw new NoResultException();

        return b.get();
    }

    @Override
    public void persist(Book book) {
        bookRepository.save(book);
    }
}
