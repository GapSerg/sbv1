/**
 * @Autor GapSerg
 * @Create 2022-07-09.07.2022 23:06
 **/

package org.example.sbv1;


import org.example.sbv1.entity.Person;
import org.example.sbv1.repository.PersonRepository;
import org.hibernate.LazyInitializationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RelationsTest {

    @Autowired
    PersonRepository personRepository;

    @Test(expected = LazyInitializationException.class)
    public void lazyLoadingException() throws Exception {
        List<Person> anna = personRepository.findByFirstName("Anna");
        System.out.println(anna.get(0).getPhones());
    }

    @Test
    @Transactional
    public void lazyLoadingTransaction() throws Exception {
        List<Person> anna = personRepository.findByFirstName("Bella");

        System.out.println(anna.get(0).getPhones());
    }

    @Test
    @Transactional
    public void NplusOneIssue() throws Exception {
        List<Person> people = personRepository.findAll();
        for (Person p : people
        ) {
            System.out.println(p.getPhones());
        }
    }

    @Test
    public void NplusOneIssueSolve() throws Exception {
        List<Person> people = personRepository.findAllWithPhones();
        for (Person p : people
        ) {
            System.out.println(p.getPhones());

        }

    }
}
