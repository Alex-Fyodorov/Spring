package fyodorov.controller;

import fyodorov.persist.User;
import fyodorov.persist.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@Slf4j
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
    public String saveUser(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user_form";
        }
        if (!user.getPassword().equals(user.getMatchingPassword())) {
            bindingResult.rejectValue("password", "Password not match.");
            return "user_form";
        }
        if (user.getId().equals(0L)) {
            userRepository.insert(user);
        } else {
            userRepository.update(user);
        }
        return "redirect:/user";
    }

/*    @PostMapping("/update")
    public String saveUser(User user) {
        if (!user.getUsername().equals("")) {
            if (user.getId().equals(0L)) {
                userRepository.insert(user);
            } else {
                userRepository.update(user);
            }
        }
        return "redirect:/user";
    }*/

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userRepository.delete(id);
        return "redirect:/user";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        log.info("Создали нового пользователя.");
        User user = new User("");
        user.setId(0L);
        model.addAttribute("user", user);
        return "user_form";
    }
}