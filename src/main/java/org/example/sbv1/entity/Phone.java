/**
 * @Autor GapSerg
 * @Create 2022-07-09.07.2022 23:03
 **/

package org.example.sbv1.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Phone {
    @Id
    @GeneratedValue
    private int id;

    private String number;

    public Phone() {
    }

    public Phone(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "\nPhone{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }
}
