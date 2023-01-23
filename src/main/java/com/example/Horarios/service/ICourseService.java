package com.example.Horarios.service;

import com.example.Horarios.dto.CourseDTO;

import java.util.List;

public interface ICourseService {
    List<CourseDTO> getAll();
    CourseDTO getById(int id) throws Exception;

    void save(CourseDTO courseDTO);
    String update(CourseDTO courseDTO);

    void delete(int id);
}
