/**
 * @Autor GapSerg
 * @Create 2022-07-09.07.2022 13:48
 **/

package org.example.sbv1.entity;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class Passport {
    @Id
    @GeneratedValue
    private int id;
    @Column(unique = true,nullable = false)
    private String number;

    @OneToOne(mappedBy = "passport", cascade = CascadeType.ALL)
    private Person person;

    public Passport() {
    }

    public Passport(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "\nPassport{" +
                "id=" + id +
                ", number='" + number + '\'' +

                '}';
    }
}
