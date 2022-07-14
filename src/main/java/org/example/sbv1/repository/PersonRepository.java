/**
 * @Autor GapSerg
 * @Create 2022-07-09.07.2022 10:15
 **/

package org.example.sbv1.repository;
import org.example.sbv1.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;
public interface PersonRepository extends JpaRepository<Person, Integer> {

    List<Person> findByFirstName(String firstName);

    @Query("select p from Person p order by firstName")
    List<Person> findAllOrderedByFirstName();

    @Query("select distinct p from Person p join fetch p.phones")
    List<Person> findAllWithPhones();
}
