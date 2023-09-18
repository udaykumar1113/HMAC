package com.skb.course.apis.authorsws.author;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/v1/authors")
public class AuthorController {

    @PostMapping
    public ResponseEntity<?> addAuthor(@RequestBody Author author) {

        author.setAuthorId(UUID.randomUUID().toString());
        return new ResponseEntity<>(author, HttpStatus.CREATED);
    }

    @PostMapping(path = "/{authorId}")
    public ResponseEntity<Author> getAuthorById(@PathVariable String authorId) {

        Author author = new Author(authorId, "Sanjay", "Bharatiya",
                "sanjay.bharatiya@email.com");

        return new ResponseEntity<>(author, HttpStatus.OK);
    }
}
