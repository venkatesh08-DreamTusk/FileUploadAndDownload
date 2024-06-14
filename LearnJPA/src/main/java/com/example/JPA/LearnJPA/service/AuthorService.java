package com.example.JPA.LearnJPA.service;

import com.example.JPA.LearnJPA.enity.Author;

import java.util.List;

public interface AuthorService {
    public void addAuthor(Author author)throws Exception;
    public  List<Author> getAllAuthor();

    public  Author getBymailId(String mail);

    public List<Author> getBygender(String gender);
    public  List<Author> getByGenderandMark(String gender, Double mark);

    public List<Author> getorderByMark();

    public Integer getByGroup(String gender);
}
