package fyodorov.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import fyodorov.persist.User;
import fyodorov.persist.UserRepository;

import java.util.List;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @GetMapping
    public String listPage(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "user";
    }

    @GetMapping("/{id}")
    public String form(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userRepository.findById(id));
        return "user_form";
    }

    @PostMapping("/update")
    public String saveUser(User user) {
        if (!user.getUsername().equals("")) {
            if (user.getId().equals(0L)) {
                userRepository.insert(new User(user.getUsername()));
            } else {
                userRepository.update(user);
            }
        }
        return "redirect:/user";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userRepository.delete(id);
        return "redirect:/user";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        User user = new User("");
        user.setId(0L);
        model.addAttribute("user", user);
        return "user_form";
    }
}
