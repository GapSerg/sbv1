/**
 * @Autor GapSerg
 * @Create 2022-07-09.07.2022 10:10
 **/

package org.example.sbv1;

import org.example.sbv1.entity.Passport;
import org.example.sbv1.entity.Person;
import org.example.sbv1.entity.Phone;
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

        Person anna = new Person("Bella", "Andreeva", "Samara");
        Person olesya = new Person("Kolesya", "Andreeva", "Moscow");

        //passport
        Passport passportAnna =   new Passport("B111111");
        Passport passportOlesya = new Passport("O222222");

        anna.setPassport(passportAnna);
        olesya.setPassport(passportOlesya);

        //phones
        Phone phone1 = new Phone("123-123-123");
        Phone phone2 = new Phone("222-222-222");
        Phone phone3 = new Phone("333-333-333");
        Phone phone4 = new Phone("444-444-444");

        anna.setPassport(passportAnna);
        anna.setPhones(Arrays.asList(phone1, phone2));
       // anna.setAddresses(Arrays.asList(address1, address2));

        olesya.setPassport(passportOlesya);
        olesya.setPhones(Arrays.asList(phone3, phone4));
      //  olesya.setAddresses(Arrays.asList(address3, address4));

        List<Person> people = Arrays.asList(anna, olesya);

        personRepository.saveAll(people);




    }
}
