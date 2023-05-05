package github.skreutz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SampleApplication {

    public static void main(final String[] args) {
        SpringApplication.run(SampleApplication.class, args);
    }

// This should still work after removing this
//    @Autowired
//    void configureObjectMapper(final ObjectMapper mapper) {
//        Hibernate6Module hibernate6Module = new Hibernate6Module();
//        hibernate6Module.disable(Hibernate6Module.Feature.USE_TRANSIENT_ANNOTATION);
//        hibernate6Module.enable(Hibernate6Module.Feature.FORCE_LAZY_LOADING);
//        mapper.registerModule(hibernate6Module);
//    }
}
