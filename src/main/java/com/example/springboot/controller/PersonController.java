package com.example.springboot.controller;

import com.example.springboot.dto.PersonDTO;
import com.example.springboot.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService service;

    //CRUD
    @GetMapping
    public List<PersonDTO> getAll(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public PersonDTO getById(@PathVariable long id){
        return service.getById(id);
    }
    @PostMapping
    public PersonDTO save(@RequestBody PersonDTO dto){
        return service.save(dto);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id){
        service.deleteById(id);
    }

}
