/**
 * @Autor GapSerg
 * @Create 2022-07-14.07.2022 15:16
 **/

package org.example.sbv1.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String text;
    String tag;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    Person author;

    public Message(String text, String tag, Person author) {
        this.text = text;
        this.tag = tag;


    }

    public String getPerson(){
      return author != null ? author.getUsername() : "<none>";
    }


    public Message(String text) {
        this.text = text;
    }
}
