package br.com.jlgregorio.crud.service;

import br.com.jlgregorio.crud.model.PersonModel;
import br.com.jlgregorio.crud.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public PersonModel findById(long id) throws Exception{
        return repository.findById(id).orElseThrow(() -> new Exception("Não Encontrado!"));
    }

    public List<PersonModel> findAll(){
        return  repository.findAll();
    }

    public PersonModel save(PersonModel person){
        return repository.save(person);
    }

    public PersonModel update(PersonModel person) throws Exception{
        PersonModel p = findById(person.getId());
        p.setFirstName(person.getFirstName());
        p.setLastName(person.getLastName());
        p.setEmail(person.getEmail());
        return repository.save(p);
    }

    public void delete(long id) throws Exception{
        PersonModel p = findById(id);
        repository.delete(p);
    }




}
