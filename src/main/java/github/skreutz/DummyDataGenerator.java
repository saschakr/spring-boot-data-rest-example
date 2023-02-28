package github.skreutz;

import java.util.List;

import github.skreutz.model.Author;
import github.skreutz.model.Note;
import github.skreutz.repository.AuthorRepository;
import github.skreutz.repository.NoteRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class DummyDataGenerator  implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final NoteRepository noteRepository;

    @Override
    public void run(final String... args) {

        final Author author = authorRepository.save(new Author("Author#1"));
        noteRepository.saveAll(
            List.of(
                new Note("Note#1", "Content#1", author),
                new Note("Note#2", "Content#2", author),
                new Note("Note#3", "Content#3", author)
            ));
    }
}
