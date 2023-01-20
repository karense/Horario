package com.example.Horarios.controller;

import com.example.Horarios.dto.CourseDTO;
import com.example.Horarios.service.ICourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController {
    private final ICourseService iCourseService;

    public CourseController(ICourseService iCourseService) {
        this.iCourseService = iCourseService;
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
    public ResponseEntity<?> create(@RequestBody CourseDTO courseDTO){
        iCourseService.save(courseDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<?> update(@RequestBody CourseDTO courseDTO){
        return new ResponseEntity<>(iCourseService.update(courseDTO),HttpStatus.OK);
    }
}
