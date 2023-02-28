package github.skreutz.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@RequiredArgsConstructor
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Author author;

    public Note(final String title, final String text, final Author author) {
        this.title = title;
        this.text = text;
        this.author = author;
    }
}
