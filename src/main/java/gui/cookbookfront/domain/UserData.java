package gui.cookbookfront.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class UserData {

    public static boolean isLogged = false;
    public static int id;
    public static List<String> recipeIds;
}
