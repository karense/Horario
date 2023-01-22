package com.example.Horarios.service.Imple;

import com.example.Horarios.dto.CourseDTO;
import com.example.Horarios.repository.ICourseRepository;
import com.example.Horarios.repository.entity.Course;
import com.example.Horarios.service.ICourseService;
import com.example.Horarios.utils.mapper.CourseMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements ICourseService {

    private final ICourseRepository repository;
    private final CourseMapper courseMapper;

    public CourseServiceImpl(ICourseRepository iCourseRepository, CourseMapper courseMapper) {
        this.repository = iCourseRepository;
        this.courseMapper = courseMapper;
    }

    @Override
    public List<CourseDTO> getAll() {
        List<Course> list = (List<Course>) repository.findAll();
        return list.stream()
                .map(courseMapper::toCourseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CourseDTO getById(int id) throws Exception {
        Optional<Course> value = repository.findById(id);
        if(value.isEmpty()){
            throw new NoSuchElementException("No se econtró un curso con este id.");
        }
        return courseMapper.toCourseDTO(value.get());
    }

    @Override
    public void save(CourseDTO courseDTO) {
        repository.save(courseMapper.toCourse(courseDTO));
    }

    @Override
    public String update(CourseDTO courseDTO) {
        Optional<Course> value = repository.findById(courseDTO.getId());
        if(value.isEmpty()){
           throw new NoSuchElementException("No se econtró un curso con este id.");
        }
        repository.save(courseMapper.toCourse(courseDTO));
        return "Update";
    }
}
