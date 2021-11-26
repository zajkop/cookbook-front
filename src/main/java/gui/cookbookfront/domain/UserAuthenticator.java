package gui.cookbookfront.domain;

import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class UserAuthenticator {

    public static void authenticate(String username, String password) {
        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> obj = Map.of("login", username, "password", password);
        User requestedUser = restTemplate.postForObject("http://localhost:8080/recipe/login", obj, User.class);
        if (requestedUser != null) {
            UserData.isLogged = true;
            UserData.recipeIds = requestedUser.getMeals();
            UserData.id = requestedUser.getId();
        }
    }
}
