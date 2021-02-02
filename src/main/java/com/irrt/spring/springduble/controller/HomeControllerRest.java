package com.irrt.spring.springduble.controller;

import com.irrt.spring.springduble.model.Book;
import com.irrt.spring.springduble.repo.BookRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = {"/api"}, produces = "application/json")
public class HomeControllerRest {
    private BookRepository bookRepository;

    public HomeControllerRest(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping//метод выводит в браузер API index.html
    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")//метод выводит в браузер API только ID из index.html
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long id) {
        Optional<Book> bookMaybe = bookRepository.findById(id);
        if (bookMaybe.isPresent()) {
            return new ResponseEntity<>(bookMaybe.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(bookMaybe.get(), HttpStatus.NOT_FOUND);
    }

    @PostMapping(consumes = "application/json")
    public Book postBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    //удаление по ID
    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteBookId(@PathVariable("id") Long id) {
        try {
            bookRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
        }
    }

    //обновление строки по ID
    @PutMapping("/{id")
    public Book putBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }
    //изменение строки с проверкой каждого значения на предмет Null
    @PatchMapping(path = "/{id", consumes = "application/json")
    public Book putchBook(@PathVariable("id") Long id, @RequestBody Book bookPath){
        Book bookRefresh = bookRepository.findById(id).get();
        if (bookPath.getAuthor()!=null){
            bookRefresh.setAuthor(bookPath.getAuthor());
        }
        if (bookPath.getName()!=null){
            bookRefresh.setName(bookPath.getName());
        }
        return bookRepository.save(bookRefresh);
    }

}
