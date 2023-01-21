package com.example.Horarios.utils.validation;

import com.example.Horarios.repository.entity.Student;
import com.example.Horarios.repository.entity.Teacher;
import jakarta.validation.constraints.*;

import java.util.List;

public class CourseValidation {
    @NotNull()
    private Integer teacher_id;
    @NotBlank
    private String schedule;
    @NotBlank
    @Size(max = 200)
    //@Pattern(regexp = "[0-9A-Za-z]+")
    private String topic;

    public CourseValidation() {
    }

    public CourseValidation(Integer teacher_id, String schedule, String topic) {
        this.teacher_id = teacher_id;
        this.schedule = schedule;
        this.topic = topic;
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
