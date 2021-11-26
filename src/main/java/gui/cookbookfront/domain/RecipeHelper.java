package gui.cookbookfront.domain;

import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import static java.lang.String.valueOf;

public class RecipeHelper {

    public static Recipe[] getBreakfast() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:8080/recipe/breakfast", Recipe[].class);
    }

    public static Recipe[] getLunches() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:8080/recipe/lunch", Recipe[].class);
    }

    public static Recipe[] getDinners() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:8080/recipe/dinner", Recipe[].class);
    }

    public static byte[] getImageByUri(String imageUri) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:8080/recipe/" + imageUri, byte[].class);
    }

    public static Recipe[] getUserMeals(String userId) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:8080/recipe/user/" + userId, Recipe[].class);
    }

    public static void addUserMeal(String mealId) {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> params = new HashMap<>();
        params.put("userId", valueOf(UserData.id));
        params.put("mealId", mealId);
        restTemplate.postForObject("http://localhost:8080/recipe/user/add-meal", params, User.class);
    }

    public static void removeUserMeal(String mealId) {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> params = new HashMap<>();
        params.put("userId", valueOf(UserData.id));
        params.put("mealId", mealId);
        restTemplate.postForObject("http://localhost:8080/recipe/user/remove-meal", params, User.class);
    }

    public static void registerUser(String username, String password) {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);
        restTemplate.postForObject("http://localhost:8080/recipe/user/register", params, User.class);
    }
}
