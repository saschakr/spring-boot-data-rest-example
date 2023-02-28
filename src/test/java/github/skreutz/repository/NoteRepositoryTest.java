package github.skreutz.repository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import github.skreutz.SampleApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = SampleApplication.class)
@AutoConfigureMockMvc
@ActiveProfiles(profiles = "test")
class NoteRepositoryTest {

    @Autowired
    AuthorRepository repository;

    @Autowired
    NoteRepository jobConfigRepository;

    @Autowired
    MockMvc mvc;

    @Test
    void test_access_property_via_link_should_return_ok() throws Exception {

        mvc.perform(get("/notes/1/author")
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
    }
}