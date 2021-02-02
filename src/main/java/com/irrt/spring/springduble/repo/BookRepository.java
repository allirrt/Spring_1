package com.irrt.spring.springduble.repo;

import com.irrt.spring.springduble.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
