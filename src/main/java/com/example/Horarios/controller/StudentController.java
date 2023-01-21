package com.example.Horarios.controller;

import com.example.Horarios.dto.CourseDTO;
import com.example.Horarios.dto.StudentDTO;
import com.example.Horarios.dto.TeacherDTO;
import com.example.Horarios.service.Imple.StudentServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentServiceImpl studentService;

    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = {"","/{id}"})
    public ResponseEntity<?> get(@PathVariable(name = "id", required = false) String id) throws Exception {
        if (id != null){
            return new ResponseEntity<>(studentService.getById(Integer.parseInt(id)), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(studentService.getAll(), HttpStatus.OK);
        }
    }

    @PostMapping()
    public ResponseEntity<?>
    save(@RequestBody StudentDTO studentDTO){
        studentService.save(studentDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<?> update(@RequestBody StudentDTO studentDTO){
        return new ResponseEntity<>(studentService.update(studentDTO),HttpStatus.OK);
    }

    @DeleteMapping(value = {"/{id}"})
    public ResponseEntity<?> delete(@PathVariable(name = "id", required = true) String id) throws Exception {
            studentService.delete(Integer.parseInt(id));
            return new ResponseEntity<>( HttpStatus.OK);

    }


}
