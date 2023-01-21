package com.example.Horarios.controller;

import com.example.Horarios.dto.TeacherDTO;
import com.example.Horarios.service.Imple.TeacherServiceImpl;
import com.example.Horarios.utils.ErrorResponse.InvalidDataException;
import com.example.Horarios.utils.mapper.TeacherMapper;
import com.example.Horarios.utils.validation.TeacherValidation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherServiceImpl teacherServiceImpl;
    private  final TeacherMapper teacherMapper;

    public TeacherController(TeacherServiceImpl iTeacherService, TeacherMapper teacherMapper){
        this.teacherServiceImpl = iTeacherService;
        this.teacherMapper = teacherMapper;
    }

    @GetMapping(value = {"", "/{id}"})
    public ResponseEntity<?> get(@PathVariable(name = "id", required = false) String id) throws Exception {
        if(id != null){
            return new ResponseEntity<>(teacherServiceImpl.getById(Integer.parseInt(id)), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(teacherServiceImpl.getAll(), HttpStatus.OK);
        }

    }

    @PostMapping()
    public ResponseEntity<?>
    save(@Valid @RequestBody TeacherValidation teacher,  BindingResult result){
        if (result.hasErrors()){
            throw new InvalidDataException(result);
        }
        TeacherDTO teacherValidationToTeacherDTO = teacherMapper.TeacherValidationToTeacherDTO(teacher);
        TeacherDTO teacherSaved = teacherServiceImpl.save(teacherValidationToTeacherDTO);

        return new ResponseEntity<>(teacherSaved,HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<?>
    update(@Valid @RequestBody TeacherValidation teacher, BindingResult result){
        if(result.hasErrors()){
            throw  new InvalidDataException(result);
        }

        TeacherDTO teacherValidationToTeacherDTO = teacherMapper.TeacherValidationToTeacherDTO(teacher);

        return new ResponseEntity<>(teacherServiceImpl.update(teacherValidationToTeacherDTO), HttpStatus.OK);
    }
}
