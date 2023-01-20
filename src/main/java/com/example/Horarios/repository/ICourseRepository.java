package com.example.Horarios.repository;

import com.example.Horarios.repository.entity.Course;
import org.springframework.data.repository.CrudRepository;

public interface ICourseRepository extends CrudRepository<Course, Integer> {
}
