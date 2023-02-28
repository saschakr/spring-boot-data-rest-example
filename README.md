# Spring Boot Data Rest Example

Sample Project to show that accessing a property resource via link does not work when lazy loading is active.

GH Issue: [#2234](https://github.com/spring-projects/spring-data-rest/issues/2234)

## Configuration 

Note.java
```java
@Entity
public class Note {
    //.. id
    @ManyToOne(fetch = FetchType.LAZY)
    private Author author;
}
```

Author.java
```java
@Entity
public class Author  {
    //.. id
    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<Note> notes = new ArrayList<>();
}
```

## Test

See testcase NoteRepositoryTest#test_access_property_via_link_should_return_ok

> GET /notes/1
```json
{
  "title" : "Note#1",
  "text" : "Content#1",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/notes/1"
    },
    "note" : {
      "href" : "http://localhost:8080/notes/1"
    },
    "author" : {
      "href" : "http://localhost:8080/notes/1/author"
    }
  }
}
```

When executing `_links.notes.href` it will fail with HTTP 500.

> GET /notes/1/author
```
com.fasterxml.jackson.databind.exc.InvalidDefinitionException: No serializer found for class org.hibernate.proxy.pojo.bytebuddy.ByteBuddyInterceptor and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS) (through reference chain: org.springframework.data.rest.webmvc.json.PersistentEntityJackson2Module$PersistentEntityResourceSerializer$1["content"]->github.skreutz.model.Author$HibernateProxy$XZxIw8Hs["hibernateLazyInitializer"])
	at com.fasterxml.jackson.databind.exc.InvalidDefinitionException.from(InvalidDefinitionException.java:77) ~[jackson-databind-2.14.1.jar:2.14.1]
```
