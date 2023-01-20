package com.example.Horarios.repository;

import com.example.Horarios.repository.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface IStudentRepository extends CrudRepository<Student, Integer> {
}
