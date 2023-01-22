package com.example.Horarios.repository.entity;

import com.example.Horarios.dto.TeacherDTO;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Teacher {
    @Id
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String lastname;

    private Integer age;

    @OneToMany(mappedBy = "teacher")
    @JsonManagedReference
    @JsonIgnore
    @Column(insertable = false, updatable = false)
    private List<Course> course;

    public List<Course> getCourse() {
        return course;
    }

    public void setCourse(List<Course> course) {
        this.course = course;
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

    public void setAge(Integer age) {
        this.age = age;
    }

    public Teacher(Integer id, String name, String lastname, Integer age) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
    }

    public Teacher() {
    }

    public Teacher(TeacherDTO teacherDTO) {
        this.id = teacherDTO.getId();
        this.name = teacherDTO.getName();
        this.lastname = teacherDTO.getLastname();
        this.age = teacherDTO.getAge();
    }
}
