package se.purplescout.basicjpa.repository;

import org.springframework.data.repository.CrudRepository;
import se.purplescout.basicjpa.model.Review;

public interface ReviewRepository extends CrudRepository<Review, Long> {
}
