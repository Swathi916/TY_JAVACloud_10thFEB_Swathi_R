package com.tyss.book.asg.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.book.asg.entity.Book;
import com.tyss.book.asg.service.BookService;

@RestController
@RequestMapping("/api")
public class BookRestController {

	private BookService bookService;
	
	@Autowired
	public BookRestController(BookService theBookService) {
		bookService = theBookService;
	}
	
	
	@GetMapping("/books")
	public List<Book> findAll() {
		return bookService.findAll();
	}

	
	
	@GetMapping("/books/{bookId}")
	public Book getEmployee(@PathVariable int bookId) {
		
		Book theBook = bookService.findById(bookId);
		
		if (theBook == null) {
			throw new RuntimeException("id not found - " + bookId);
		}
		
		return theBook;
	}
	
	
	@PostMapping("/books")
	public Book addStudent(@RequestBody Book theStudent) {
		
		theStudent.setId(0);
		
		bookService.save(theStudent);
		
		return theStudent;
	}
	
	
	
	@PutMapping("/books")
	public Book updateStudent(@RequestBody Book theBook) {
		
		bookService.save(theBook);
		
		return theBook;
	}
	
	
	
	@DeleteMapping("/books/{bookId}")
	public String deleteStudent(@PathVariable int bookId) {
		
		Book tempBook = bookService.findById(bookId);
		
		
		
		if (tempBook == null) {
			throw new RuntimeException("id not found - " + bookId);
		}
		
		bookService.deleteById(bookId);
		
		return "Deleted  - " + bookId;
	}
	
}










