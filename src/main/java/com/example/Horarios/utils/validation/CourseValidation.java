package com.example.Horarios.utils.validation;

import com.example.Horarios.repository.entity.Student;
import com.example.Horarios.repository.entity.Teacher;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.List;

public class CourseValidation {
    @NotNull()
    private Integer teacher_id;
    @NotBlank
    private String schedule;
    @NotBlank
    @Max(200)
    @Pattern(regexp = "[0-9Aa-zZ]")
    private String topic;
}
