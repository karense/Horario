package com.example.Horarios.repository.entity;

import com.example.Horarios.dto.StudentDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Entity
public class Student {

    @Id
    private Integer id;
    private String name;

    private String lastname;
    private LocalDate birthday;

    @ManyToOne()
    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    @JsonBackReference
    @JsonIgnore
    private Course course;

    @Column(name = "course_id")
    @JsonIgnore
    private Integer courseId;

    @OneToOne
    @JoinColumn(name = "grade_id", insertable = false, updatable = false)
    private Grade grade;

    public Student() {
    }

    public Student(Integer id, String name, String lastname, LocalDate birthday, Course course, Integer courseId, Grade grade) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.birthday = birthday;
        this.course = course;
        this.courseId = courseId;
        this.grade = grade;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
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
