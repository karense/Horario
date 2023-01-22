package com.example.Horarios.utils.validation;

import com.example.Horarios.repository.entity.Student;
import com.example.Horarios.repository.entity.Teacher;
import jakarta.validation.constraints.*;

import java.util.List;

public class CourseValidation {


    private Integer id;
    @NotNull(message = "El campo [teacher_id] no debe de ser nulo.")
    private Integer teacher_id;
    @NotBlank
    private String schedule;
    @NotBlank
    @Size(max = 200)
    @Pattern(regexp = "[A-Za-z0-9\s]+", message = "El campo [topic] no debe contener caracteres especiales.")
    private String topic;

    public CourseValidation() {
    }

    public CourseValidation(Integer id, Integer teacher_id, String schedule, String topic) {
        this.id = id;
        this.teacher_id = teacher_id;
        this.schedule = schedule;
        this.topic = topic;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Integer teacher_id) {
        this.teacher_id = teacher_id;
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
