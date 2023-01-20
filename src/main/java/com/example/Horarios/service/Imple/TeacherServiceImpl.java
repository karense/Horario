package com.example.Horarios.service.Imple;

import com.example.Horarios.dto.CourseDTO;
import com.example.Horarios.dto.TeacherDTO;
import com.example.Horarios.repository.ITeacherRepository;
import com.example.Horarios.repository.entity.Teacher;
import com.example.Horarios.service.ITeacherService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements ITeacherService {

    private final ITeacherRepository repository;

    public TeacherServiceImpl(ITeacherRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<TeacherDTO> getAll() {
         List<Teacher> list = (List<Teacher>) repository.findAll();
        return list.stream()
                .map(TeacherDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public TeacherDTO getById(Integer id) throws Exception {
        Optional<Teacher> value = repository.findById(id);
        if(value.isPresent()){

            TeacherDTO teacherDTO =new TeacherDTO(value.get());
            List<CourseDTO> course =  new ArrayList<>();
           // course.add(new )
            //teacherDTO.setCourse();
            return teacherDTO;
        }else{
            throw new Exception("No se econtró un profesor con esa cédula");
        }

    }

    @Override
    public void save(TeacherDTO teacherDTO) {
        repository.save(new Teacher(teacherDTO));
    }

    @Override
    public String update(TeacherDTO teacherDTO) {
         Optional<Teacher> value = repository.findById(teacherDTO.getId());

        if(value.isPresent()){
            return "Update";
        }else{
            return "NO exist";
        }
    }
}
