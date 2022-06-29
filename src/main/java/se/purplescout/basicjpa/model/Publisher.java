package se.purplescout.basicjpa.model;

import javax.persistence.*;

@Entity
public class Publisher implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "publisher_sequence")
    @SequenceGenerator(name = "publisher_sequence", sequenceName = "publisher_sequence")
    private Long id;

    @Version
    private int version;

    public int getVersion() {
        return version;
    }

    public Long getId() {
        return id;
    }
}
