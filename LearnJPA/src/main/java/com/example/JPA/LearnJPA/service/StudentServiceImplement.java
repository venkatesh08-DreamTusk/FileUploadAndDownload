package com.example.JPA.LearnJPA.service;

import com.example.JPA.LearnJPA.enity.Student;
import com.example.JPA.LearnJPA.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImplement implements  StudentService{

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student uploadFile(Long id, String absolutePath) throws Exception {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            Student currentStudent = student.get();
            currentStudent.setPhoto(absolutePath);
          return studentRepository.save(currentStudent);
        } else {
            throw new Exception("Id Not Found");
        }

    }

    @Override
    public Student getStudentData(Long id) throws Exception {
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()){
            return student.get();
        }else {
            throw new Exception("Id Not Found");
        }
    }


}
