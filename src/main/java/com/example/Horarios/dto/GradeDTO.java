package com.example.Horarios.dto;

import com.example.Horarios.repository.entity.Course;
import com.example.Horarios.repository.entity.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

public class GradeDTO {

    private Integer id;


    private Integer studentId;


    private Student student;


    private Integer courseId;


    private Course course;

    private Integer grade;

    public GradeDTO() {
    }

    public GradeDTO(Integer id, Integer studentId, Student student, Integer courseId, Course course, Integer grade) {
        this.id = id;
        this.studentId = studentId;
        this.student = student;
        this.courseId = courseId;
        this.course = course;
        this.grade = grade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}
