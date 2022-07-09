/**
 * @Autor GapSerg
 * @Create 2022-07-09.07.2022 14:38
 **/

package org.example.sbv1.repository;

import org.example.sbv1.entity.Passport;
import org.example.sbv1.entity.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonRepositoryTest {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PassportRepository passportRepository;

    @Test
    public void findByFirstName() throws Exception {

        List<Person> people = personRepository.findByFirstName("Anna");

        assertThat(people).hasSize(1);
        assertThat(people.get(0).getLastName()).isEqualTo("Andreeva");

    }

    @Test
    public void findAllOrderedByFirstName() throws Exception {
        List<Person> people = personRepository.findAllOrderedByFirstName();

        assertThat(people).hasSize(3);
        assertThat(people.get(2).getFirstName()).isEqualTo("Olesya");
        assertThat(people.get(1).getFirstName()).isEqualTo("Anna");

    }

    @Test
    public void deletePassport() throws Exception {
       Passport passport = passportRepository.findByNumber("B111111");


       passportRepository.delete(passport);

        List<Person> people = personRepository.findAll();
        assertThat(people).hasSize(2);

        List<Passport> passports = passportRepository.findAll();
        assertThat(passports).hasSize(2);

    }
}
