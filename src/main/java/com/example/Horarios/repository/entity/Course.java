package com.example.Horarios.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.List;

@Entity
public class Course {
    @Id
    private Integer id;

    @OneToMany
    private List<Student> studentList;
    @OneToOne
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
