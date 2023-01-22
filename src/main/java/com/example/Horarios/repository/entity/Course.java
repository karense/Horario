package com.example.Horarios.repository.entity;

import com.example.Horarios.dto.CourseDTO;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "course")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany(mappedBy = "course")
    @JsonManagedReference
    @JsonIgnore
    private List<Student> studentList;

    @Column(name = "teacher_id")
    @JsonIgnore
    private Integer idTeacher;
    @ManyToOne()
    @JoinColumn(name = "teacher_id", insertable = false, updatable = false)
    @JsonBackReference
    @JsonIgnore
    private Teacher teacher;
    private String schedule;
    private String topic;

    public Course() {
    }



    public Course(Integer id, List<Student> studentList, Integer idTeacher, Teacher teacher, String schedule, String topic) {
        this.id = id;
        this.studentList = studentList;
        this.idTeacher = idTeacher;
        this.teacher = teacher;
        this.schedule = schedule;
        this.topic = topic;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public Integer getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(Integer idTeacher) {
        this.idTeacher = idTeacher;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
