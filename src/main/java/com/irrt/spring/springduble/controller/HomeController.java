package com.irrt.spring.springduble.controller;

import com.irrt.spring.springduble.model.Book;
import com.irrt.spring.springduble.repo.BookRepository;
import com.irrt.spring.springduble.service.SoundAnimals;
import net.bytebuddy.build.Plugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    private BookRepository bookRepository;
    private SoundAnimals soundAnimals;

    @Autowired
    public HomeController(BookRepository bookRepository, //@Qualifier("catSound")
            SoundAnimals soundAnimals) {
        this.bookRepository = bookRepository;
        this.soundAnimals = soundAnimals;
    }


@GetMapping
    public String getIndex(Model model){
    System.out.println("From Controler: " + soundAnimals.sound());
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
