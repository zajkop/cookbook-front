package gui.cookbookfront.controler;

import gui.cookbookfront.domain.UserData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
class HomeController {

    @GetMapping("/")
    String homePage(Model model) {
        model.addAttribute("isLogged", UserData.isLogged);
        return "main-page";
    }
}
