package com.example.JPA.LearnJPA.enity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "Author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String gender;
    private Integer age;
    private Double percentage;
    private Boolean present;

    public  Author(){}
    public Author(Long id, String name,String email,String gender, Integer age, Double percentage, Boolean present){
        this.id = id;
        this.name = name;
        this.email =  email;
        this.gender = gender;
        this.age =age;
        this.percentage =percentage;
        this.present =present;
    }
    public String getEmail() {
        return email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }



    public Integer getAge() {
        return age;
    }


    public String getGender() {
        return gender;
    }


    public Double getPercentage() {
        return percentage;
    }


    public Boolean getPresent() {
        return present;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public void setPresent(Boolean present) {
        this.present = present;
    }
}
