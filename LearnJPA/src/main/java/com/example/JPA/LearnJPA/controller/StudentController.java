package com.example.JPA.LearnJPA.controller;

import com.example.JPA.LearnJPA.dto.StudentDto;
import com.example.JPA.LearnJPA.enity.Student;
import com.example.JPA.LearnJPA.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;

@RestController
@RequestMapping("/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public Student addStudentData(@RequestBody StudentDto studentDto){
        Student student = new Student();
        student.setName(studentDto.getName());
        student.setAge(studentDto.getAge());
      return studentService.addStudent(student);
    }

    @PostMapping("/upload/{id}")
    public String uploadFile(@PathVariable("id") Long id,@RequestParam("file")MultipartFile multipartFile) throws Exception {

        String fileName = multipartFile.getOriginalFilename();
        String basePath = "C:\\Users\\Venkatesh\\Desktop\\Student\\";
        String path =basePath+fileName;

        try {
            File file = new File(path);
            if(file.createNewFile()){
                  studentService.uploadFile(id,file.getAbsolutePath());
            }
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
          return "File Successfully Uploaded";
    }


    @GetMapping("/download/{id}")
    public ResponseEntity<Resource> downloadFile(@PathVariable("id") Long id) throws Exception {

        Student student = studentService.getStudentData(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,"student,filename=\""+student.getName())
                .body(new ByteArrayResource(student.getPhoto().getBytes()));
    }
}











