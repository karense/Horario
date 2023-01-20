package com.example.Horarios.controller;

import com.example.Horarios.dto.TeacherDTO;
import com.example.Horarios.service.ITeacherService;
import com.example.Horarios.service.Imple.TeacherServiceImpl;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherServiceImpl teacherServiceImpl;

    public TeacherController(TeacherServiceImpl iTeacherService){
        this.teacherServiceImpl = iTeacherService;
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
    save(@RequestBody TeacherDTO teacher){
        teacherServiceImpl.save(teacher);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<?>
    update(@RequestBody TeacherDTO teacher){
        return new ResponseEntity<>(teacherServiceImpl.update(teacher), HttpStatus.OK);
    }
}
