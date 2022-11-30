package com.example.restservice;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.example.restservice.entities.Author;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthorsController {

	private final LinkedList<Author> authors = new LinkedList<>();
	private final AtomicLong counter = new AtomicLong();


	@GetMapping("/authors")
	public List<Author> getAllAuthors() {
		return authors;
	}

	@PutMapping("/authors")
	public Author createAuthor(@RequestParam String name) {
		Author a = new Author(counter.incrementAndGet(), name);
		authors.add(a);
		return a;
	}

	/* public List<Author> getAllAuthors(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}*/
}
