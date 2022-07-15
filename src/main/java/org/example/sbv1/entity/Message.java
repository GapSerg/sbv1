/**
 * @Autor GapSerg
 * @Create 2022-07-14.07.2022 15:16
 **/

package org.example.sbv1.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String text;
    String tag;

    public Message(String text, String tag) {
        this.text = text;
        this.tag = tag;
    }

    public Message(String text) {
        this.text = text;
    }
}
