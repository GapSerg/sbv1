/**
 * @Autor GapSerg
 * @Create 2022-07-14.07.2022 13:34
 **/

package org.example.sbv1.controllers;

import org.example.sbv1.entity.Message;
import org.example.sbv1.entity.Person;
import org.example.sbv1.entity.Role;
import org.example.sbv1.repository.MessageRepository;
import org.example.sbv1.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class MainController {
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/")
    public String greeting() {
        return "hello";
    }


    @GetMapping("/start")
    public String startPage(@ModelAttribute("message") Message message,Model model) {
        model.addAttribute("messages", messageRepository.findAll());
        return "start";
    }

    @PostMapping("/start")
    public String newMessage(
            @AuthenticationPrincipal Person person,
            @ModelAttribute("message") Message message) {

        message.setAuthor(person);
        messageRepository.save(message);


        return "redirect:start";


    }

    @GetMapping("/registration")
    public String registration(@ModelAttribute("person") Person person) {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("person") Person person, Model model) {

        Person personFromDb = personRepository.findByEmail(person.getEmail());

        if (personFromDb != null) {
            model.addAttribute("error", "User exists!");
            return "registration";
        }
        System.out.println(person.getEmail());
        person.setActive(true);
        person.setRoles(Collections.singleton(Role.USER));

        personRepository.save(person);

        return "redirect:/login";
    }


}
