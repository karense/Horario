package com.example.Horarios.service.Imple;

import com.example.Horarios.dto.GradeDTO;
import com.example.Horarios.repository.IGradeRepository;
import com.example.Horarios.repository.entity.Grade;
import com.example.Horarios.service.IGradeService;
import com.example.Horarios.utils.mapper.GradeMapper;
import com.sun.jdi.request.DuplicateRequestException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GradeServiceImpl implements IGradeService {

    private final IGradeRepository repository;
    private final GradeMapper gradeMapper;

    public GradeServiceImpl(IGradeRepository repository, GradeMapper gradeMapper) {
        this.repository = repository;
        this.gradeMapper = gradeMapper;
    }

    @Override
    public List<GradeDTO> getAll() {
        List<Grade> list = (List<Grade>) repository.findAll();
        return list.stream().map(gradeMapper::toGradeDto).collect(Collectors.toList());
    }

    @Override
    public GradeDTO getById(int id) throws Exception {
        Optional<Grade> value = repository.findById(id);
        if (value.isEmpty()){
            throw new NoSuchElementException("No se encontró la nota con este id.");
        }
        return gradeMapper.toGradeDto(value.get());
    }

    @Override
    public void save(GradeDTO gradeDTO) {
        repository.save(gradeMapper.toGrade(gradeDTO));
    }

    @Override
    public String update(GradeDTO gradeDTO) {
        Optional<Grade> value = repository.findById(gradeDTO.getId());
        if (value.isEmpty()){
            throw new NoSuchElementException("No se encontró la nota con este id.");
        }

        repository.save(gradeMapper.toGrade(gradeDTO));
        return "Updated";
    }

    @Override
    public void delete(int id) {
        Optional<Grade> value = repository.findById(id);
        if (value.isEmpty()){
            throw new NoSuchElementException("No se encontró la nota con este id.");
        }

        repository.delete(value.get());
    }
}
