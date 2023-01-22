package com.example.Horarios.service;

import com.example.Horarios.dto.TeacherDTO;
import com.example.Horarios.repository.entity.Teacher;
import org.springframework.dao.DuplicateKeyException;

import java.util.List;
import java.util.Optional;

public interface ITeacherService {
    List<TeacherDTO> getAll();
    TeacherDTO getById(Integer id) throws Exception;

    TeacherDTO save(TeacherDTO teacherDTO) throws DuplicateKeyException;
    String update(TeacherDTO teacherDTO);
}
