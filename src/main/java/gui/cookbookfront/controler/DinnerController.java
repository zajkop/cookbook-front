package gui.cookbookfront.controler;

import gui.cookbookfront.domain.Recipe;
import gui.cookbookfront.domain.RecipeHelper;
import gui.cookbookfront.domain.UserData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DinnerController {

    @GetMapping("/dinner")
    String dinner(Model model) {
        Recipe[] dinner = RecipeHelper.getDinners();
        model.addAttribute("dinner", dinner);
        model.addAttribute("isLogged", UserData.isLogged);
        return "dinner";
    }

    @PostMapping("/dinner")
    String addMeal(@RequestParam String id) {
        if (!UserData.recipeIds.contains(id)) {
            UserData.recipeIds.add(id);
            RecipeHelper.addUserMeal(id);
            return "redirect:/profile";
        }
        return "dinner";
    }
}
