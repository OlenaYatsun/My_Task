package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.entity.User;
import web.service.UserService;


@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String users(Model model) {
        model.addAttribute("users", userService.showUsers());
        return "/allUsers";
    }

    @GetMapping("/{id}")
    public String showById(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.showById(id));
        return "/showById";
    }


    @GetMapping("/{id}/editUser")
    public String editUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.showById(id));
        return "/editUser";
    }


    @GetMapping("/newUser")
    public String newUser(@ModelAttribute("user") User user) {
        return "/newUser";
    }


    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") long id) {
        userService.update(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.delete(id);
        return "redirect:/users";
    }


}
