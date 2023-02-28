package github.skreutz.repository;

import github.skreutz.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface NoteRepository extends JpaRepository<Note, Long> {

}
