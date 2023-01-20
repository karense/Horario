package com.example.Horarios.dto;

import com.example.Horarios.repository.entity.Teacher;
import jakarta.persistence.Id;

public class TeacherDTO {
    private Integer id;
    private String name;

    private String lastname;

    private Integer age;

    public TeacherDTO(Integer id, String name, String lastname, Integer age) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
    }

    public TeacherDTO(Teacher teacher){
        this.id = teacher.getId();
        this.name = teacher.getName();
        this.lastname = teacher.getLastname();
        this.age = teacher.getAge();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getAge() {
        return age;
    }

    public void setEdad(Integer age) {
        this.age = age;
    }
}
