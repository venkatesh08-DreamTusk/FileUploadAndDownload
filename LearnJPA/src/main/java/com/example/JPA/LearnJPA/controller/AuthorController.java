package com.example.JPA.LearnJPA.controller;

import com.example.JPA.LearnJPA.enity.Author;
import com.example.JPA.LearnJPA.serviceImplementation.AuthorServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/author")
public class AuthorController {

    @Autowired
    private AuthorServiceImplement authorService;

    @PostMapping
    public String addAuthor(@RequestBody com.example.JPA.LearnJPA.enity.Author author){
        try{
            authorService.addAuthor(author);
            return "Author Successfully Added";

        }catch (Exception e){
            return e.getMessage();
        }
    }

    @GetMapping
    public List<Author> getAllAuthor(){
        return authorService.getAllAuthor();
    }

    @GetMapping("/mail")
    public Author getByEmail(@RequestParam("mail") String mail){
        return authorService.getBymailId(mail);
    }

    @GetMapping("/gender")
    public List<Author> getByGender(@RequestParam("gender") String gender){
        return authorService.getBygender(gender);
    }

    @GetMapping("/gender-mark")
    public  List<Author> getByGenderAndPercentage(@RequestParam("gender") String gender, @RequestParam("mark") Double mark){
        return authorService.getByGenderandMark(gender,mark);
    }

    @GetMapping("/order-by-mark")
    public  List<Author> orderByMark(){
        return authorService.getorderByMark();
    }

    @GetMapping("/count-by")
    public Integer getGroupBy(@RequestParam("gender") String gender){
        Integer count =  authorService.getByGroup(gender);
        return count;
    }
 }
