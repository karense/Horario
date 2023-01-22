package com.example.Horarios.utils.validation;

import com.example.Horarios.repository.entity.Course;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public class StudentValidation {
    @NotNull(message = "El campo [id] no debe ser nulo.")
    private Integer id;
    @Pattern(regexp = "[a-zA-z]+", message = "El campo: [name] solo debe contener letras.")
    @NotBlank(message = "El campo [name] es requerido.")
    private String name;
    @Pattern(regexp = "[a-zA-z\s]+", message = "El campo: [lastname] solo debe contener letras.")
    @NotBlank(message = "El campo [lastname] es requerido.")
    private String lastname;
    private LocalDate birthday;
    @Min(value = 1, message = "El campo: [age] debe ser mayor que o igual a 1.")
    private Integer age;
    @NotNull(message = "El campo [courseId] no debe ser nulo.")
    private Integer courseId;

    public StudentValidation() {
    }

    public StudentValidation(Integer id, String name, String lastname, LocalDate birthday, Integer age, Integer courseId) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.birthday = birthday;
        this.age = age;
        this.courseId = courseId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }
}
