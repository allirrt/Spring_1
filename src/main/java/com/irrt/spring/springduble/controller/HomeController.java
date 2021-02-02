package com.irrt.spring.springduble.controller;

import com.irrt.spring.springduble.model.Book;
import com.irrt.spring.springduble.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    private BookRepository bookRepository;

    @Autowired
    public HomeController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

@GetMapping
    public String getIndex(Model model){
        model.addAttribute("books", bookRepository.findAll());
       model.addAttribute("newbook", new Book());
        return "index";
    }
    @PostMapping
public String createBook(Book book){
bookRepository.save(book);
        return"redirect:/";
    }
}
