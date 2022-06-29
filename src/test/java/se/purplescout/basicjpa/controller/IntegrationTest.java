package se.purplescout.basicjpa.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import se.purplescout.basicjpa.model.Author;
import se.purplescout.basicjpa.model.Book;
import se.purplescout.basicjpa.model.Publisher;
import se.purplescout.basicjpa.model.Review;

import javax.persistence.NoResultException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD;

@SpringBootTest
@DirtiesContext(classMode = AFTER_EACH_TEST_METHOD)
public class IntegrationTest {

    @Autowired
    AuthorController authorController;

    @Autowired
    BookController bookController;

    @Autowired
    PublisherController publisherController;

    @Autowired
    ReviewController reviewController;

    @Test
    void getNotPresentShouldThrowNoResult() {
        getById1ShouldThrowNoResult(bookController);
        getById1ShouldThrowNoResult(publisherController);
        getById1ShouldThrowNoResult(authorController);
        getById1ShouldThrowNoResult(reviewController);
    }

    private void getById1ShouldThrowNoResult(Controller<?> controller) {
        assertThrows(NoResultException.class, () -> controller.getById(1L));
    }

    @Test
    void persistAllValues() {
        Book b = persistBook(persistAuthor(), persistPublisher());
        persistReview(b);
    }

    private Author persistAuthor() {
        Author a = new Author();
        a.setFirstName("Marten");
        a.setLastName("Hernebring");
        authorController.persist(a);
        Author pa = authorController.getById(a.getId());
        assertEquals("Marten", pa.getFirstName());
        assertEquals("Hernebring", pa.getLastName());
        assertEquals(0, pa.getVersion());
        return a;
    }

    private Publisher persistPublisher() {
        Publisher p = new Publisher();
        publisherController.persist(p);
        assertEquals(0, publisherController.getById(p.getId()).getVersion());
        return p;
    }

    private Book persistBook(Author a, Publisher p) {
        Book b = new Book();
        b.setTitle("My book");
        b.setAuthors(Set.of(a));
        b.setPublisher(p);
        bookController.persist(b);

        Book pb = bookController.getById(b.getId());
        assertEquals(b.getTitle(), pb.getTitle());
        assertEquals(0, pb.getVersion());
        assertEquals(b.hashCode(), pb.hashCode());
        assertNotNull(pb.getAuthors());
        assertNotNull(pb.getPublisher());
        return b;
    }

    private void persistReview(Book b) {
        Review r = new Review();
        r.setText("Very good");
        r.setBook(b);
        reviewController.persist(r);
        Review pr = reviewController.getById(r.getId());
        assertEquals(r.getText(), pr.getText());
        assertEquals(0, pr.getVersion());
        assertEquals(pr.getBook(), bookController.getById(b.getId()));
    }

}
