package com.example.springboot.mapper;

import com.example.springboot.dto.PersonDTO;
import com.example.springboot.entity.PersonEntity;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {
    public PersonEntity from(final PersonDTO dto){
        return new PersonEntity(dto.getId(), dto.getName());
    }

    public PersonDTO to(final PersonEntity entity){
        return new PersonDTO(entity.getId(), entity.getName());
    }

}
