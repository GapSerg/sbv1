/**
 * @Autor GapSerg
 * @Create 2022-07-09.07.2022 10:10
 **/

package org.example.sbv1;

import org.example.sbv1.entity.Passport;
import org.example.sbv1.entity.Person;
import org.example.sbv1.repository.PassportRepository;
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
    @Autowired
    PassportRepository passportRepository;


    @Override
    public void run(String... args) throws Exception {

//        Person anna = new Person("Bella", "Andreeva", "Samara");
//        Person olesya = new Person("Olesya", "Andreeva", "Moscow");
//        Passport passportAnna =   new Passport("C111111");
//        Passport passportOlesya = new Passport("D222222");
//        anna.setPassport(passportAnna);
//        olesya.setPassport(passportOlesya);
//
//        List<Person> people = Arrays.asList(anna, olesya);
//
//        personRepository.saveAll(people);

        System.out.println("<<<<<<"+passportRepository.findAll());



    }
}
