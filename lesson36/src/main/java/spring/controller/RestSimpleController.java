package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.domain.Person;
import spring.service.PersonService;

@RestController
@RequestMapping("/api")
public class RestSimpleController implements GetApi{

    @Autowired
    PersonService personService;

    @Override
    public ResponseEntity<Person> get(Integer id) {
        return null;
    }

//    public ResponseEntity<Person> get(@PathVariable("id") Integer id) {
//        Person person = personService.findById(id);
//        if (person != null) {
//            return ResponseEntity.ok(person);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
}
