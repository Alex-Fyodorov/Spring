package fyodorov.hw8.controller;

import fyodorov.hw8.items.User;
import fyodorov.hw8.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping
    public String userPage(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "user";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "add_user";
    }

    @PostMapping("/insert")
    public String saveUser(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "add_product";
        }
        userRepository.insert(user.getName());
        return "redirect:/user";
    }
}
