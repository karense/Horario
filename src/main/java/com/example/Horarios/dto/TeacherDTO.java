package com.example.Horarios.dto;

import com.example.Horarios.repository.entity.Course;
import com.example.Horarios.repository.entity.Teacher;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TeacherDTO {
    private Integer id;
    private String name;

    private String lastname;

    private Integer age;

    private List<CourseDTO> course;

    public TeacherDTO(Integer id, String name, String lastname, Integer age, List<CourseDTO> course) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.course = course;
    }

    public TeacherDTO() {
    }


    public TeacherDTO(Teacher teacher) {
        this.id = teacher.getId();
        this.name = teacher.getName();
        this.lastname = teacher.getLastname();
        this.age = teacher.getAge();
        this.course=teacher.getCourse().stream().map(CourseDTO::new).collect(Collectors.toList());
    }

    public List<CourseDTO> getCourse() {
        return course;
    }

    public void setCourse(List<CourseDTO> course) {
        this.course = course;
    }

    public void setAge(Integer age) {
        this.age = age;
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

}
