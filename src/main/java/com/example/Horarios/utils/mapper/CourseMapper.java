package com.example.Horarios.utils.mapper;

import com.example.Horarios.dto.CourseDTO;
import com.example.Horarios.repository.entity.Course;
import com.example.Horarios.utils.validation.CourseValidation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    CourseDTO toCourseDTO(Course course);
    Course toCourse(CourseDTO courseDTO);
    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target="idTeacher", source="teacher_id"),
            @Mapping(target="schedule", source="schedule"),
            @Mapping(target="topic", source="topic"),
    })
    CourseDTO validationToDto(CourseValidation courseValidation);
}
