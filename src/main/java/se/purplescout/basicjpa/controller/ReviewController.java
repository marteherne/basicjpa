package se.purplescout.basicjpa.controller;

import org.springframework.web.bind.annotation.*;
import se.purplescout.basicjpa.model.Review;
import se.purplescout.basicjpa.repository.ReviewRepository;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.Optional;

@RestController
@RequestMapping(path = "review")
@Transactional
public class ReviewController implements Controller<Review>{

    final ReviewRepository reviewRepository;

    public ReviewController(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review getById(Long id) {
        Optional<Review> r = reviewRepository.findById(id);
        if(r.isEmpty())
            throw new NoResultException();

        return r.get();
    }

    @Override
    public void persist(Review review) {
        reviewRepository.save(review);
    }
}
