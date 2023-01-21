package com.example.Horarios.controller;

import com.example.Horarios.dto.CourseDTO;
import com.example.Horarios.service.ICourseService;
import com.example.Horarios.utils.ErrorResponse.InvalidDataException;
import com.example.Horarios.utils.mapper.CourseMapper;
import com.example.Horarios.utils.mapper.TeacherMapper;
import com.example.Horarios.utils.validation.CourseValidation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController {
    private final ICourseService iCourseService;
    private final CourseMapper courseMapper;

    public CourseController(ICourseService iCourseService, CourseMapper courseMapper) {
        this.iCourseService = iCourseService;
        this.courseMapper = courseMapper;
    }

    @GetMapping(value = {"","/{id}"})
    public ResponseEntity<?> get(@PathVariable(name = "id", required = false) String id) throws Exception{
        if (id != null){
            return new ResponseEntity<>(iCourseService.getById(Integer.parseInt(id)), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(iCourseService.getAll(), HttpStatus.OK);
        }
    }

    @PostMapping()
    public ResponseEntity<?> create(@Valid @RequestBody CourseValidation courseValidation, BindingResult result){
        if(result.hasErrors()){
            throw new InvalidDataException(result);
        }
        CourseDTO convertToCourseDTO = courseMapper.validationToDto(courseValidation);
        iCourseService.save(convertToCourseDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<?> update(@Valid @RequestBody CourseValidation courseValidation, BindingResult result){
        if(result.hasErrors()){
            throw new InvalidDataException(result);
        }
        CourseDTO convertToCourseDTO = courseMapper.validationToDto(courseValidation);
        return new ResponseEntity<>(iCourseService.update(convertToCourseDTO),HttpStatus.OK);
    }
}
