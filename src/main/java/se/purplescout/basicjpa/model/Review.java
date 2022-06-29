package se.purplescout.basicjpa.model;

import javax.persistence.*;

@Entity
public class Review implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "review_sequence")
    @SequenceGenerator(name = "review_sequence", sequenceName = "review_sequence")
    private long id;

    private String text;

    @ManyToOne
    private Book book;

    @Version
    private int version;

    public int getVersion() {
        return version;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
