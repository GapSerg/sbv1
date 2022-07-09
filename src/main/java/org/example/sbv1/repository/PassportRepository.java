/**
 * @Autor GapSerg
 * @Create 2022-07-09.07.2022 13:59
 **/

package org.example.sbv1.repository;

import org.example.sbv1.entity.Passport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassportRepository extends JpaRepository<Passport,Integer> {
    Passport findByNumber(String number);
}
