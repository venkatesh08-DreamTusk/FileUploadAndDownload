package com.example.JPA.LearnJPA.serviceImplementation ;


import com.example.JPA.LearnJPA.enity.Author;
import com.example.JPA.LearnJPA.repository.AuthorRepo;
import com.example.JPA.LearnJPA.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AuthorServiceImplement implements AuthorService {

    @Autowired
    private AuthorRepo authorRepo;

    @Override
    public void addAuthor(com.example.JPA.LearnJPA.enity.Author author) throws Exception {
        if(author.getEmail() != null && author.getName() != null){
            authorRepo.save(author);
        }else {
            throw new Exception("Give Proper Data");
        }
    }

    @Override
    public List<Author> getAllAuthor() {
        return authorRepo.getAllAuthor();
    }

    @Override
    public Author getBymailId(String mail) {
        return authorRepo.getByEmail(mail);
    }

    @Override
    public List<Author> getBygender(String gender) {
        return authorRepo.findByGender(gender);
    }

    @Override
    public List<Author> getByGenderandMark(String gender, Double mark) {
        return authorRepo.findByGenderAndPercentageGreaterThan(gender,mark);
    }

    @Override
    public List<Author> getorderByMark() {
        return authorRepo.OrderByPercentageAsc();
    }

    @Override
    public Integer getByGroup(String gender) {
        return authorRepo.countByGenderEquals(gender);
    }


}
