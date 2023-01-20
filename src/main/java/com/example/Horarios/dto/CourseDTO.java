package com.example.Horarios.dto;

import com.example.Horarios.repository.entity.Course;
import com.example.Horarios.repository.entity.Student;
import com.example.Horarios.repository.entity.Teacher;

import java.util.List;

public class CourseDTO {
    private Integer id;

    private List<Student> studentList;
    private Teacher teacher;
    private String schedule;
    private String topic;

    public CourseDTO() {
    }

    public CourseDTO(Integer id, List<Student> studentList, Teacher teacher, String schedule, String topic) {
        this.id = id;
        this.studentList = studentList;
        this.teacher = teacher;
        this.schedule = schedule;
        this.topic = topic;
    }

    public CourseDTO(Course course){
        this.id = course.getId();
        this.studentList = course.getStudentList();
        this.teacher = course.getTeacher();
        this.schedule = course.getSchedule();
        this.topic = course.getTopic();
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
