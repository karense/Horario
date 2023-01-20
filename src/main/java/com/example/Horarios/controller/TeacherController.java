package com.example.Horarios.controller;

import com.example.Horarios.dto.TeacherDTO;
import com.example.Horarios.service.ITeacherService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private final ITeacherService iTeacherService;

    public TeacherController(ITeacherService iTeacherService){
        this.iTeacherService = iTeacherService;
    }

    @GetMapping()
    public ResponseEntity<?> get(@PathVariable(required = false) Integer id) throws Exception {
        return new ResponseEntity<>(iTeacherService.getAll(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?>
    save(@RequestBody TeacherDTO teacher){
        iTeacherService.save(teacher);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<?>
    update(@RequestBody TeacherDTO teacher){
        System.out.println(teacher.getId());
        return new ResponseEntity<>(iTeacherService.update(teacher), HttpStatus.OK);
    }
}
