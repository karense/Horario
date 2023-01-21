package com.example.Horarios.repository.entity;

import com.example.Horarios.dto.CourseDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
    private List<Student> studentList;
    @ManyToOne()
    @JoinColumn(name = "teacher_id")
    @JsonBackReference
    private Teacher teacher;
    private String schedule;
    private String topic;

    public Course() {
    }

    public Course(Integer id, List<Student> studentList, Teacher teacher, String schedule, String topic) {
        this.id = id;
        this.studentList = studentList;
        this.teacher = teacher;
        this.schedule = schedule;
        this.topic = topic;
    }

    public Course(CourseDTO courseDTO) {
        this.id = courseDTO.getId();
        this.studentList = courseDTO.getStudentList();
        this.teacher = courseDTO.getTeacher();
        this.schedule = courseDTO.getSchedule();
        this.topic = courseDTO.getTopic();
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
