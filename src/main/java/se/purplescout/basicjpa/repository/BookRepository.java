package se.purplescout.basicjpa.repository;

import org.springframework.data.repository.CrudRepository;
import se.purplescout.basicjpa.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
