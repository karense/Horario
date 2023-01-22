package com.example.Horarios.utils.mapper;

import com.example.Horarios.dto.GradeDTO;
import com.example.Horarios.repository.entity.Grade;
import com.example.Horarios.utils.validation.GradeValidation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface GradeMapper {
    GradeDTO toGradeDto(Grade grade);
    Grade toGrade(GradeDTO gradeDTO);

    GradeDTO validationToGradeDTO(GradeValidation gradeValidation);
}
