package com.tyss.book.asg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tyss.book.asg.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

	// that's it ... no need to write any code LOL!
	
}
