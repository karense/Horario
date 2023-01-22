package com.example.Horarios.utils.validation;

import jakarta.validation.constraints.*;
import org.springframework.format.annotation.NumberFormat;

public class GradeValidation {

    @NotNull(message = "EL campo [grade] es requerido.")
    @Min(value = 0, message = "EL campo [grade] debe ser mayor o igual a 0.")
    @Max(value = 5, message = "EL campo [grade] debe ser menor o igual a 5")
    private Integer grade;
    @NotNull(message = "EL campo [courseId] es requerido.")
    private Integer courseId;
    @NotNull(message = "EL campo [studentId] es requerido.")
    private Integer studentId;

    public GradeValidation() {
    }

    public GradeValidation(Integer grade, Integer courseId, Integer studentId) {
        this.grade = grade;
        this.courseId = courseId;
        this.studentId = studentId;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
}
