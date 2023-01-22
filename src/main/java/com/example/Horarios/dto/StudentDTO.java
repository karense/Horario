package com.example.Horarios.dto;

import com.example.Horarios.repository.entity.Course;
import com.example.Horarios.repository.entity.Student;

import java.time.LocalDate;
import java.util.Date;

public class StudentDTO {
    private Integer id;
    private String name;
    private String lastname;
    private LocalDate birthday;
    private Integer age;
    private Course course;

    private Integer courseId;

    private GradeDTO gradeDTO;

    public StudentDTO() {
    }

    public StudentDTO(Integer id, String name, String lastname, LocalDate birthday, Integer age, Course course, Integer courseId, GradeDTO gradeDTO) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.birthday = birthday;
        this.age = age;
        this.course = course;
        this.courseId = courseId;
        this.gradeDTO = gradeDTO;
    }

    public GradeDTO getGradeDTO() {
        return gradeDTO;
    }

    public void setGradeDTO(GradeDTO gradeDTO) {
        this.gradeDTO = gradeDTO;
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }
}
