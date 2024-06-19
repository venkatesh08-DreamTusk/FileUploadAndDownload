package com.example.JPA.LearnJPA.repository;

import com.example.JPA.LearnJPA.enity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
}
