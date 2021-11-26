package gui.cookbookfront.controler;

import gui.cookbookfront.domain.RecipeHelper;
import gui.cookbookfront.domain.UserAuthenticator;
import gui.cookbookfront.domain.UserData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    String login() {
        return UserData.isLogged ? "redirect:/profile" : "login-page";
    }

    @GetMapping("/register")
    String registerUser() {
        return "register-page";
    }

    @PostMapping("/register")
    String register(@RequestParam String username, @RequestParam String password) {
        if (!UserData.isLogged) {
            RecipeHelper.registerUser(username, password);
            return "redirect:/login";
        }
        return "redirect:/profile";
    }

    @GetMapping("/logout")
    String logout() {
        if (UserData.isLogged) {
            UserData.isLogged = false;
            UserData.recipeIds.clear();
            UserData.id = 0;
        }
        return "redirect:/";
    }

    @PostMapping("/authenticate")
    String authenticate(@RequestParam String username, @RequestParam String password) {
        UserAuthenticator.authenticate(username, password);
        return UserData.isLogged ? "redirect:/profile" : "redirect:/login";
    }
}
