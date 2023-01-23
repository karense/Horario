package com.example.Horarios.service;

import com.example.Horarios.dto.GradeDTO;

import java.util.List;

public interface IGradeService {
    List<GradeDTO> getAll();
    GradeDTO getById(int id) throws Exception;

    void save(GradeDTO gradeDTO);
    String update(GradeDTO gradeDTO);

    void delete(int id);
}
