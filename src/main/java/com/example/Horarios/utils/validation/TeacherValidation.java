package com.example.Horarios.utils.validation;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class TeacherValidation {

    @NotNull(message = "id es requerido.")
    private Integer id;
    @Pattern(regexp = "[a-zA-z]+", message = "El campo: [name] solo debe contener letras.")
    @NotBlank
    private String name;
    @Pattern(regexp = "[a-zA-z\s]+", message = "El campo: [lastname] solo debe contener letras.")
    @NotBlank
    private String lastname;
    @Min(value = 1, message = "El campo: [age] debe ser mayor que o igual a 1")
    private Integer age;

    public TeacherValidation() {
    }

    public TeacherValidation(Integer id, String name, String lastname, Integer age) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
