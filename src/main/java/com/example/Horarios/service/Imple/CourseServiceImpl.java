package com.example.Horarios.service.Imple;

import com.example.Horarios.dto.CourseDTO;
import com.example.Horarios.repository.ICourseRepository;
import com.example.Horarios.repository.entity.Course;
import com.example.Horarios.service.ICourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements ICourseService {

    private final ICourseRepository repository;

    public CourseServiceImpl(ICourseRepository iCourseRepository) {
        this.repository = iCourseRepository;
    }

    @Override
    public List<CourseDTO> getAll() {
        List<Course> list = (List<Course>) repository.findAll();
        return list.stream()
                .map(CourseDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public CourseDTO getById(int id) throws Exception {
        Optional<Course> value = repository.findById(id);
        if(value.isPresent()){
            return new CourseDTO(value.get());
        }else{
            throw new Exception("No se econtró un curso con este id");
        }
    }

    @Override
    public void save(CourseDTO courseDTO) {
        repository.save(new Course(courseDTO));
    }

    @Override
    public String update(CourseDTO courseDTO) {
        Optional<Course> value = repository.findById(courseDTO.getId());
        if(value.isPresent()){
            repository.save(new Course(courseDTO));
            return "Update";
        }else{
            return "NO exist";
        }
    }
}
