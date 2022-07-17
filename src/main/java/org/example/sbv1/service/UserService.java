/**
 * @Autor GapSerg
 * @Create 2022-07-15.07.2022 19:34
 **/

package org.example.sbv1.service;

import org.example.sbv1.repository.PersonRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    private final PersonRepository personRepository;

    public UserService(PersonRepository repository) {
        this.personRepository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return personRepository.findByEmail(email);
    }
}
