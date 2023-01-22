package com.example.Horarios.service.Imple;

import com.example.Horarios.dto.TeacherDTO;
import com.example.Horarios.repository.ITeacherRepository;
import com.example.Horarios.repository.entity.Teacher;
import com.example.Horarios.service.ITeacherService;
import com.example.Horarios.utils.mapper.TeacherMapper;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements ITeacherService {

    private final ITeacherRepository repository;
    private final TeacherMapper teacherMapper;

    public TeacherServiceImpl(ITeacherRepository repository, TeacherMapper teacherMapper) {
        this.repository = repository;
        this.teacherMapper = teacherMapper;
    }


    @Override
    public List<TeacherDTO> getAll() {
         List<Teacher> list = (List<Teacher>) repository.findAll();
        return list.stream()
                .map(teacherMapper::toTeacherDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TeacherDTO getById(Integer id) {
        Optional<Teacher> value = repository.findById(id);

        if(value.isEmpty()){
            throw new NoSuchElementException("No se econtró un profesor con esta cédula.");
        }

        return teacherMapper.toTeacherDTO(value.get());

    }

    @Override
    public TeacherDTO save(TeacherDTO teacherDTO) throws DuplicateKeyException {
        Optional<Teacher> value = repository.findById(teacherDTO.getId());
        if (value.isPresent()){
            throw new DuplicateKeyException("Ya existe un profesor con esta cédula.");
        }
        repository.save(teacherMapper.toTeacher(teacherDTO));
        return teacherDTO;
    }

    @Override
    public String update(TeacherDTO teacherDTO) {
         Optional<Teacher> value = repository.findById(teacherDTO.getId());
        if(value.isEmpty()){
            throw new NoSuchElementException("No se econtró un profesor con esta cédula");
        }
        repository.save(teacherMapper.toTeacher(teacherDTO));
        return "Update";
    }
}
