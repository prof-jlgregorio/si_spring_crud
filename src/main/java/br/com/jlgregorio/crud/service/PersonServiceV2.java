package br.com.jlgregorio.crud.service;

import br.com.jlgregorio.crud.model.PersonModel;
import br.com.jlgregorio.crud.model.PersonModelV2;
import br.com.jlgregorio.crud.repository.PersonRepository;
import br.com.jlgregorio.crud.repository.PersonRepositoryV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceV2 {

    @Autowired
    private PersonRepositoryV2 repository;

    public PersonModelV2 findById(long id) throws Exception{
        return repository.findById(id).orElseThrow(() -> new Exception("Não Encontrado!"));
    }

    public List<PersonModelV2> findAll(){
        return  repository.findAll();
    }

    public PersonModelV2 save(PersonModelV2 person){
        return repository.save(person);
    }

    public PersonModelV2 update(PersonModelV2 person) throws Exception{
        PersonModelV2 p = findById(person.getId());
        p.setFirstName(person.getFirstName());
        p.setLastName(person.getLastName());
        p.setEmail(person.getEmail());
        //set the attribute profession
        p.setProfession(person.getProfession());
        return repository.save(p);
    }

    public void delete(long id) throws Exception{
        PersonModelV2 p = findById(id);
        repository.delete(p);
    }

}
