package br.com.tony.springaoplogging.controller;

import br.com.tony.springaoplogging.domain.Person;
import br.com.tony.springaoplogging.dto.PersonDTO;
import br.com.tony.springaoplogging.log.Log;
import br.com.tony.springaoplogging.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);

    private PersonRepository personRepository;

    public Controller(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Log
    @PostMapping
    public ResponseEntity<Object> create(@RequestBody PersonDTO personDTO) {

        LOGGER.info("Salvando usuário {}", personDTO.getName());

        Person person = this.personRepository.save(new Person(personDTO.getName()));

        PersonDTO saved = new PersonDTO();
        personDTO.setId(person.getId());
        saved.setName(person.getName());

        LOGGER.info("Usuário {} salvo com sucesso. Id: {}", saved.getName(), saved.getId());
        return ResponseEntity.ok(saved);
    }
}
