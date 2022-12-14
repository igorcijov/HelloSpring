/*
 * Java Pro. lesson #29 Spring Data Part.2 JPA.
 *
 * @author Igor Cijov
 * @version 27 Okt 2022
 */

package spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.domain.Person;
import spring.service.PersonService;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("spring");
        context.refresh();

        PersonService personService = (PersonService) context.getBean("personService");
        //personService.add("Sidor", "Sidorov");
        List<Person> persons = personService.findByFirstname("Ivan");
        System.out.println(persons);

        context.close();
    }
}