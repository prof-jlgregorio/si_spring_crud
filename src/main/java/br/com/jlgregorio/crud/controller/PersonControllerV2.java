package br.com.jlgregorio.crud.controller;

import br.com.jlgregorio.crud.model.PersonModel;
import br.com.jlgregorio.crud.model.PersonModelV2;
import br.com.jlgregorio.crud.service.PersonService;
import br.com.jlgregorio.crud.service.PersonServiceV2;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:8081", "http://www.jlgregorio.com.br"})
@Api(value = "This API manipulates Person", tags = {"Person", "CRUD", "REST"})
@RestController
@RequestMapping("/person/v2")
public class PersonControllerV2 {

    @Autowired
    private PersonServiceV2 service;


    @ApiOperation(value = "Retrieve a Person using an ID", produces = "JSON", response = PersonModel.class)
    @GetMapping(value = "/{id}", produces = {"application/json", "application/xml"})
    public PersonModelV2 findById(@ApiParam(name = "id", value = "An integer value", required = true)
                                      @PathVariable("id") long id) throws Exception{
        return service.findById(id);
    }


    @ApiOperation(value = "Return a list of People", produces = "JSON", response = PersonModel.class )
    @GetMapping
    public List<PersonModelV2> findAll(){
        return service.findAll();
    }

    @PostMapping(produces = {"application/xml", "application/json"}, consumes = {"application/xml", "application/json"})
    public PersonModelV2 save(@RequestBody PersonModelV2 personModel){
        return service.save(personModel);
    }

    @PutMapping
    public PersonModelV2 update(@RequestBody PersonModelV2 personModel) throws Exception{
        return service.update(personModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) throws Exception{
        service.delete(id);
        return ResponseEntity.ok().build();
    }


}
