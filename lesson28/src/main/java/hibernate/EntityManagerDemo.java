package hibernate;

import hibernate.domain.Person;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class EntityManagerDemo {
    public static void main(String[] args) {
        // Получаем фабрику менеджеров сущностей
        EntityManagerFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        // Из фабрики создаем EntityManager
        EntityManager em = factory.createEntityManager();

        List<Person> persons = em.createNamedQuery("SELECT p FROM Person p WHERE p.firstName='Ivan'", Person.class).getResultList();
        System.out.println(persons);

//        add(em, "Sidor", "Sidorov");
//        Person person = em.find(Person.class, 1);
//        System.out.println(person);
//
//        person.setLastName("Petrov");
//        update(em, person);
//
//        Person person = em.find(Person.class, 1);
//        System.out.println(person);
//
//        person = em.find(Person.class, 3);
//        System.out.println(person);
//
//        remove(em, person);
    }

    static void add(EntityManager em, String firstName, String lastName) {
        // Добавление записи
        Person person = new Person(firstName, lastName);

        // Открываем транзакцию
        em.getTransaction().begin();
        // Create (сохраняем в базе данных, и благодаря этому сущность
        // становится управляемой Hibernate и заносится в контекст постоянства)
        em.persist(person);
        // Подтверждаем транзакцию
        em.getTransaction().commit();
    }

    static Person find(EntityManager em, int id) {
        return em.find(Person.class, 1);
    }

    static void update(EntityManager em, Person person) {
        em.getTransaction().begin();
        em.merge(person);
        em.getTransaction().commit();
    }

    static void remove(EntityManager em, Person person) {
        em.getTransaction().begin();
        em.remove(person);
        em.getTransaction().commit();
    }
}