package com.example.Horarios.service.Imple;

import com.example.Horarios.dto.CourseDTO;
import com.example.Horarios.dto.TeacherDTO;
import com.example.Horarios.repository.ITeacherRepository;
import com.example.Horarios.repository.entity.Teacher;
import com.example.Horarios.service.ITeacherService;
import com.example.Horarios.utils.mapper.TeacherMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
    public TeacherDTO getById(Integer id) throws Exception {
        Optional<Teacher> value = repository.findById(id);
        if(value.isPresent()){

            TeacherDTO teacherDTO =new TeacherDTO(value.get());
            List<CourseDTO> course =  new ArrayList<>();

            return teacherDTO;
        }else{
            throw new Exception("No se econtró un profesor con esa cédula");
        }

    }

    @Override
    public TeacherDTO save(TeacherDTO teacherDTO) {
        repository.save(teacherMapper.toTeacher(teacherDTO));
        return teacherDTO;
    }

    @Override
    public String update(TeacherDTO teacherDTO) {
         Optional<Teacher> value = repository.findById(teacherDTO.getId());
        if(value.isPresent()){
            repository.save(teacherMapper.toTeacher(teacherDTO));
            return "Update";
        }else{
            return "NO exist";
        }
    }
}
