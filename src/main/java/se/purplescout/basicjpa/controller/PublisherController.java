package se.purplescout.basicjpa.controller;

import org.springframework.web.bind.annotation.*;
import se.purplescout.basicjpa.model.Publisher;
import se.purplescout.basicjpa.repository.PublisherRepository;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.Optional;

@RestController
@RequestMapping(path = "publisher")
@Transactional
public class PublisherController implements Controller<Publisher> {

    final PublisherRepository publisherRepository;

    public PublisherController(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public Publisher getById(Long id) {
        Optional<Publisher> p = publisherRepository.findById(id);
        if(p.isEmpty())
            throw new NoResultException();

        return p.get();
    }

    @Override
    public void persist(Publisher publisher) {
        publisherRepository.save(publisher);
    }
}
