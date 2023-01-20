package com.example.Horarios.service;

import com.example.Horarios.dto.StudentDTO;
import com.example.Horarios.dto.TeacherDTO;

import java.util.List;

public interface IStudentService {
    List<StudentDTO> getAll();
    StudentDTO getById(Integer id) throws Exception;

    void save(StudentDTO studentDTO);
    String update(StudentDTO studentDTO);
}
