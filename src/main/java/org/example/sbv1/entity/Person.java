/**
 * @Autor GapSerg
 * @Create 2022-07-09.07.2022 10:16
 **/

package org.example.sbv1.entity;

import lombok.Data;
import org.hibernate.FetchMode;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
public class Person {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;
    private String address;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pasport_id")
    private Passport passport;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private List<Phone> phones;


    public Person() {
    }

    public Person(String firstName, String lastName, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public Person(int id, String firstName, String lastName, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    @Override
    public String toString() {
        return "\nPerson{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +

                '}';
    }
}
