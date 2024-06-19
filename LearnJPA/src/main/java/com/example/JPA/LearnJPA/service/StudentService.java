package com.example.JPA.LearnJPA.service;

import com.example.JPA.LearnJPA.enity.Student;

public interface StudentService {
    public Student addStudent(Student student);

    public  Student uploadFile(Long id, String absolutePath) throws Exception;

    public  Student getStudentData(Long id) throws Exception;
}
