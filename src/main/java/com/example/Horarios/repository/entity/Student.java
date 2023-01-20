package com.example.Horarios.repository.entity;

import com.example.Horarios.dto.StudentDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

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

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    public Student() {
    }

    public Student(Integer id, String name, String lastname, LocalDate birthday, Course course) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.birthday = birthday;
        this.course = course;
    }

    public Student(StudentDTO studentDTO){
        this.id = studentDTO.getId();
        this.name = studentDTO.getName();
        this.lastname = studentDTO.getLastname();
        this.birthday = studentDTO.getBirthday();
        this.course = studentDTO.getCourse();
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

    public int getAge() {
        return (int) ChronoUnit.YEARS.between(LocalDate.now(),this.birthday);
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
