package com.example.Horarios.controller;

import com.example.Horarios.service.Imple.StudentServiceImpl;
import com.example.Horarios.utils.ErrorResponse.InvalidDataException;
import com.example.Horarios.utils.mapper.StudentMapper;
import com.example.Horarios.utils.validation.StudentValidation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentServiceImpl studentService;
    private  final StudentMapper studentMapper;

    public StudentController(StudentServiceImpl studentService, StudentMapper studentMapper) {
        this.studentService = studentService;
        this.studentMapper = studentMapper;
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
    public ResponseEntity<?>save(@Valid @RequestBody StudentValidation studentValidation, BindingResult result){

        if(result.hasErrors()){
            throw new InvalidDataException(result);
        }
        studentService.save(studentMapper.validationToStudentDTO(studentValidation));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<?> update(@Valid @RequestBody StudentValidation studentValidation, BindingResult result){
        if(result.hasErrors()){
            throw new InvalidDataException(result);
        }
        return new ResponseEntity<>(studentService.update(studentMapper.validationToStudentDTO(studentValidation)),HttpStatus.OK);
    }

    @DeleteMapping(value = {"/{id}"})
    public ResponseEntity<?> delete(@PathVariable(name = "id", required = true) String id) {
            studentService.delete(Integer.parseInt(id));
            return new ResponseEntity<>( HttpStatus.OK);
    }


}
