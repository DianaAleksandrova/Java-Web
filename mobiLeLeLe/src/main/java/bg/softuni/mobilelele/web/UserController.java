package bg.softuni.mobilelele.web;

import bg.softuni.mobilelele.dto.UserLoginDto;
import bg.softuni.mobilelele.dto.UserRegisterDto;
import bg.softuni.mobilelele.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(){
        return "auth-login";
    }


    @PostMapping("/login")
    public String login(UserLoginDto userLoginDto){
        userService.login(userLoginDto);
        return "redirect:/";
    }

    @GetMapping("/register")
    public String register(){
        return "auth-register";
    }

    @PostMapping("/register")
    public String registerConfirm(UserRegisterDto userRegisterDto){

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(){
        userService.logout();
        return "redirect:/";

    }


}
