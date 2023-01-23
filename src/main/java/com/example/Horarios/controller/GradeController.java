package com.example.Horarios.controller;

import com.example.Horarios.dto.GradeDTO;
import com.example.Horarios.service.Imple.GradeServiceImpl;
import com.example.Horarios.utils.ErrorResponse.InvalidDataException;
import com.example.Horarios.utils.mapper.GradeMapper;
import com.example.Horarios.utils.validation.GradeValidation;
import com.example.Horarios.utils.validation.StudentValidation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/grade")
public class GradeController {

    private final GradeServiceImpl gradeService;
    private final GradeMapper gradeMapper;

    public GradeController(GradeServiceImpl gradeService, GradeMapper gradeMapper) {
        this.gradeService = gradeService;
        this.gradeMapper = gradeMapper;
    }

    @GetMapping(value = {"","/{id}"})
    public ResponseEntity<?> get(@PathVariable(name = "id", required = false) String id) throws Exception {
        if (id != null){
            return new ResponseEntity<>(gradeService.getById(Integer.parseInt(id)), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(gradeService.getAll(), HttpStatus.OK);
        }
    }

    @PostMapping()
    public ResponseEntity<?>save(@Valid @RequestBody GradeValidation gradeValidation, BindingResult result){
        if(result.hasErrors()){
            throw new InvalidDataException(result);
        }
        gradeService.save(gradeMapper.validationToGradeDTO(gradeValidation));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<?> update(@Valid @RequestBody GradeValidation gradeValidation, BindingResult result){
        if(result.hasErrors()){
            throw new InvalidDataException(result);
        }
        return new ResponseEntity<>(gradeService.update(gradeMapper.validationToGradeDTO(gradeValidation)),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id){
        gradeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
