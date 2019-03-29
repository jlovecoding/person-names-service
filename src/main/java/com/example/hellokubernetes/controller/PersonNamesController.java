package com.example.hellokubernetes.controller;

import com.example.hellokubernetes.model.PersonName;
import com.example.hellokubernetes.service.PersonNamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonNamesController {

    @Autowired
    private PersonNamesService personNamesService;

    @GetMapping("/personNames")
    public List<PersonName> getPersonNames() {
        return personNamesService.getPersonNames();
    }

    @GetMapping("/personNames/random")
    public List<PersonName> getRandomPersonNames() {
        return personNamesService.getRandomPersonNames();
    }

    @PostMapping("/personNames")
    public PersonName createPersonName(@RequestBody final PersonName personName) {
        return personNamesService.createPersonName(personName);
    }
}
