/**
 * @Autor GapSerg
 * @Create 2022-07-14.07.2022 13:34
 **/

package org.example.sbv1;

import org.example.sbv1.entity.Message;
import org.example.sbv1.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/start")
    public String startPage(@ModelAttribute("message") Message message,Model model) {
        model.addAttribute("messages", messageRepository.findAll());
        return "start";
    }

    @PostMapping("/start")
    public String newMessage(@ModelAttribute("message") Message message) {

        messageRepository.save(message);

       // model.addAttribute("messages", messageRepository.findAll());

        return "redirect:start";


    }


}
