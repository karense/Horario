package com.example.Horarios.service;

import com.example.Horarios.dto.TeacherDTO;

import java.util.List;

public interface ITeacherService {
    List<TeacherDTO> getAll();
    TeacherDTO getById(Integer id) throws Exception;

    void save(TeacherDTO teacherDTO);
    String update(TeacherDTO teacherDTO);
}
