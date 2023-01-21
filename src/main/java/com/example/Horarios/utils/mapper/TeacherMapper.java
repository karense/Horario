package com.example.Horarios.utils.mapper;

import com.example.Horarios.dto.TeacherDTO;
import com.example.Horarios.repository.entity.Teacher;
import com.example.Horarios.utils.validation.TeacherValidation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface TeacherMapper {

    TeacherDTO toTeacherDTO(Teacher teacher);

    Teacher toTeacher(TeacherDTO teacherDTO);

    Teacher TeacherValidationToTeacher(TeacherValidation teacherValidation);

    TeacherDTO TeacherValidationToTeacherDTO(TeacherValidation teacherValidation);
}
