package com.example.JPA.LearnJPA.repository;

import com.example.JPA.LearnJPA.enity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepo extends JpaRepository<Author,Long> {

    @Query(value = "SELECT s FROM Author s")
    public List<Author> getAllAuthor();

    public Author getByEmail(String email);
    public List<Author> findByGender(String gender);

    public  List<Author> findByGenderAndPercentageGreaterThan(String gender, Double mark);

    public  List<Author> OrderByPercentageAsc();

    public Integer countByGenderEquals(String gender);
}
