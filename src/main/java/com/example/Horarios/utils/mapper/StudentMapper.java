package com.example.Horarios.utils.mapper;

import com.example.Horarios.dto.StudentDTO;
import com.example.Horarios.repository.entity.Student;
import com.example.Horarios.utils.validation.StudentValidation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    Student toStudent(StudentDTO studentDTO);

    StudentDTO toStudentDTO(Student student);

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target="name", source="name"),
            @Mapping(target="lastname", source="lastname"),
            @Mapping(target="birthday", source="birthday", dateFormat = "yyyy-MM-dd"),
            @Mapping(target="courseId", source="courseId"),
    })
    StudentDTO validationToStudentDTO(StudentValidation studentValidation);
}
