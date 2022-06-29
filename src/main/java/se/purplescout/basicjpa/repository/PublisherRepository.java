package se.purplescout.basicjpa.repository;

import org.springframework.data.repository.CrudRepository;
import se.purplescout.basicjpa.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
