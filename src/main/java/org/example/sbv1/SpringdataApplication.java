/**
 * @Autor GapSerg
 * @Create 2022-07-09.07.2022 10:25
 **/

package org.example.sbv1;

import org.example.sbv1.entity.Person;
import org.example.sbv1.jdbc.PersonJdbcDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//@SpringBootApplication
public class SpringdataApplication implements CommandLineRunner{

    public static void main(String[] args) {
        SpringApplication.run(SpringdataApplication.class, args);
    }

    @Autowired
    PersonJdbcDao personJdbcDao;

    @Override
    public void run(String... args) throws Exception {

        Person anna = new Person(103, "Anna", "Andreeva", "Samara");
        Person olesya = new Person(104, "Olesya", "Andreeva", "Moscow");
        Person alex = new Person(105, "Alex", "Andreev", "Omsk");

        personJdbcDao.insert(anna);
        personJdbcDao.insert(olesya);
        personJdbcDao.insert(alex);

        System.out.println("<<<<<<<<"+personJdbcDao.findAll());
    }
}
