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
public class LunchController {

    @GetMapping("/lunch")
    String lunch(Model model) {
        Recipe[] lunch = RecipeHelper.getLunches();
        model.addAttribute("lunch", lunch);
        model.addAttribute("isLogged", UserData.isLogged);
        return "lunch";
    }

    @PostMapping("/lunch")
    String addMeal(@RequestParam String id) {
        if (!UserData.recipeIds.contains(id)) {
            UserData.recipeIds.add(id);
            RecipeHelper.addUserMeal(id);
            return "redirect:/profile";
        }
        return "lunch";
    }
}
