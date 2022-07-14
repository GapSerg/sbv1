/**
 * @Autor GapSerg
 * @Create 2022-07-14.07.2022 15:19
 **/

package org.example.sbv1.repository;

import org.example.sbv1.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {
}
