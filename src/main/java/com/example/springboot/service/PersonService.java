package com.example.springboot.service;

import com.example.springboot.dto.PersonDTO;
import com.example.springboot.entity.PersonEntity;
import com.example.springboot.exception.ItemNotFoundException;
import com.example.springboot.mapper.PersonMapper;
import com.example.springboot.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository repository;
    private final PersonMapper mapper;

    public List<PersonDTO> getAll() {
        return repository.findAll().stream().map(entity -> mapper.to(entity)).collect(Collectors.toList());
    }


    public PersonDTO getById(long id) {
        return repository.findById(id).map(mapper::to).orElseThrow(ItemNotFoundException::new);
    }

    public PersonDTO save(PersonDTO dto) {
        final PersonEntity entity = mapper.from(dto);
        final PersonEntity saved = repository.save(entity);
        return mapper.to(saved);
    }

    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
