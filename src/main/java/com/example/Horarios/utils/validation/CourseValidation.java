package com.example.Horarios.utils.validation;

import jakarta.validation.constraints.*;


public class CourseValidation {

    private Integer id;
    @NotNull(message = "El campo [teacherId] es requerido.")
    private Integer teacherId;
    @Pattern(regexp = "^(([01][0-9]|2[0-3]):[0-5][0-9]-([01][0-9]|2[0-3]):[0-5][0-9])$", message = "El formato debe de ser HH:MM-HH:MM.")
    @NotBlank(message = "El campo [schedule] es requerido.")
    @Size(min = 11, max = 14, message = "El campo [schedule] no puede ser menor a 11 ni mayor a 14 caracteres.")
    private String schedule;
    @NotBlank
    @Size(max = 200)
    @Pattern(regexp = "[A-Za-z0-9\s]+", message = "El campo [topic] no debe contener caracteres especiales.")
    private String topic;

    public CourseValidation() {
    }

    public CourseValidation(Integer id, Integer teacherId, String schedule, String topic) {
        this.id = id;
        this.teacherId = teacherId;
        this.schedule = schedule;
        this.topic = topic;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
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
