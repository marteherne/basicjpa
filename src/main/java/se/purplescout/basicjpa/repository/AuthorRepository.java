package se.purplescout.basicjpa.repository;

import org.springframework.data.repository.CrudRepository;
import se.purplescout.basicjpa.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
