/**
 * @Autor GapSerg
 * @Create 2022-07-09.07.2022 10:10
 **/

package org.example.sbv1;
import org.example.sbv1.entity.Person;
import org.example.sbv1.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringdataJPAApplication implements CommandLineRunner {

        public static void main(String[] args) {
            SpringApplication.run(SpringdataJPAApplication.class, args);
        }

        @Autowired
        PersonRepository personRepository;

        @Override
        public void run(String... args) throws Exception {

//        Person anna = new Person("Anna", "Andreeva", "Samara");
//        Person olesya = new Person("Olesya", "Andreeva", "Moscow");
//        Person alex = new Person("Alex", "Andreev", "Omsk");
//
//        List<Person> people = Arrays.asList(anna, olesya, alex);

      //  personRepository.saveAll(people);

        System.out.println("<<<<<<<<" + personRepository.findByFirstName("Olesya"));
        }
}
