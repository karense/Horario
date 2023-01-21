package com.example.Horarios.dto;

import com.example.Horarios.repository.entity.Course;
import com.example.Horarios.repository.entity.Student;
import com.example.Horarios.repository.entity.Teacher;

import java.util.List;

public class CourseDTO {
    private Integer id;

    private Integer idTeacher;
    private List<Student> studentList;
    private Teacher teacher;
    private String schedule;
    private String topic;

    public CourseDTO() {
    }

    public CourseDTO(Integer id, Integer idTeacher, List<Student> studentList, Teacher teacher, String schedule, String topic) {
        this.id = id;
        this.idTeacher = idTeacher;
        this.studentList = studentList;
        this.teacher = teacher;
        this.schedule = schedule;
        this.topic = topic;
    }

    public Integer getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(Integer idTeacher) {
        this.idTeacher = idTeacher;
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
