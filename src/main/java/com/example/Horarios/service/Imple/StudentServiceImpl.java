package com.example.Horarios.service.Imple;

import com.example.Horarios.dto.StudentDTO;
import com.example.Horarios.repository.IStudentRepository;
import com.example.Horarios.repository.entity.Student;
import com.example.Horarios.service.IStudentService;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
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
    public StudentDTO getById(int id) throws Exception {
        Optional<Student> value = repository.findById(id);
        if(value.isEmpty()) throw new NoSuchElementException("No se econtró un estudiante con este id.");

        return new StudentDTO(value.get());
    }

    @Override
    public void save(StudentDTO studentDTO) {
        Optional<Student> value = repository.findById(studentDTO.getId());
        if (value.isPresent()) throw new DuplicateKeyException("Ya existe un estudiante con esta cédula.");

        repository.save(new Student(studentDTO));
    }

    @Override
    public String update(StudentDTO studentDTO) {
        Optional<Student> value = repository.findById(studentDTO.getId());
        if (value.isEmpty()) throw new NoSuchElementException("No se econtró un estudiante con este id.");
        repository.save(new Student(studentDTO));
        return "Updated";
    }

    @Override
    public void delete(int id) {
        Optional<Student> value = repository.findById( id);
        if (value.isEmpty()) throw new NoSuchElementException("No se econtró un estudiante con este id.");
            repository.deleteById(id);
    }
}
