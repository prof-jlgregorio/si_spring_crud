package br.com.jlgregorio.crud.controller;

import br.com.jlgregorio.crud.model.PersonModel;
import br.com.jlgregorio.crud.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person/v1")
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping("/{id}")
    public PersonModel findById(@PathVariable("id") long id) throws Exception{
        return service.findById(id);
    }

    @GetMapping
    public List<PersonModel> findAll(){
        return service.findAll();
    }

    @PostMapping
    public PersonModel save(@RequestBody PersonModel personModel){
        return service.save(personModel);
    }

    @PutMapping
    public PersonModel update(@RequestBody PersonModel personModel) throws Exception{
        return service.update(personModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) throws Exception{
        service.delete(id);
        return ResponseEntity.ok().build();
    }


}
