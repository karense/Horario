package com.example.Horarios.service.Imple;

import com.example.Horarios.dto.StudentDTO;
import com.example.Horarios.dto.TeacherDTO;
import com.example.Horarios.repository.IStudentRepository;
import com.example.Horarios.repository.entity.Student;
import com.example.Horarios.repository.entity.Teacher;
import com.example.Horarios.service.IStudentService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StudentServiceImpl implements IStudentService {

    private final IStudentRepository repository;

    public StudentServiceImpl(IStudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<StudentDTO> getAll() {
        List<Student> list = (List<Student>) repository.findAll();
        return list.stream()
                .map(StudentDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO getById(Integer id) throws Exception {
        Optional<Student> value = repository.findById(id);
        if(value.isPresent()){
            return new StudentDTO(value.get());
        }else{
            throw new Exception("No se econtró un estudiante con este id");
        }
    }

    @Override
    public void save(StudentDTO studentDTO) {

    }

    @Override
    public String update(StudentDTO studentDTO) {
        return null;
    }
}
