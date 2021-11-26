package gui.cookbookfront.controler;

import gui.cookbookfront.domain.RecipeHelper;
import gui.cookbookfront.domain.UserData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static java.lang.String.valueOf;

@Controller
class ProfileController {

    @GetMapping("/profile")
    String showProfile(Model model) {
        if (!UserData.isLogged) {
            return "redirect:/login";
        }
        model.addAttribute("isLogged", true);
        model.addAttribute("meals", RecipeHelper.getUserMeals(valueOf(UserData.id)));
        return "profile-page";
    }

    @PostMapping("/removeMeal")
    String addMeal(@RequestParam String id) {
        if (UserData.recipeIds.contains(id)) {
            UserData.recipeIds.remove(id);
            RecipeHelper.removeUserMeal(id);
        }
        return "redirect:/profile";
    }
}
