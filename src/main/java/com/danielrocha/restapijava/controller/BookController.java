package com.danielrocha.restapijava.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.danielrocha.restapijava.domain.Book;
import com.danielrocha.restapijava.exception.BookNotFoundException;
import com.danielrocha.restapijava.repository.BookRepository;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;

	@GetMapping
	public List<Book> retrieveAllStudents() {
		return bookRepository.findAll();
	}

	@GetMapping("/{id}")
	public Book retrieveStudent(@PathVariable long id) {
		Optional<Book> student = bookRepository.findById(id);

		if (!student.isPresent())
			throw new BookNotFoundException("no found books | id-" + id);

		return student.get();
	}

	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable long id) {
		bookRepository.deleteById(id);
	}

	@PostMapping
	public ResponseEntity<Object> createStudent(@RequestBody Book book) {
		Book savedBook = bookRepository.save(book);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedBook.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateStudent(@RequestBody Book book, @PathVariable long id) {

		Optional<Book> studentOptional = bookRepository.findById(id);

		if (!studentOptional.isPresent())
			return ResponseEntity.notFound().build();

		book.setId(id);
		
		bookRepository.save(book);

		return ResponseEntity.noContent().build();
	}
	
	public void test() {
		System.out.println("Test..");
	}

}
